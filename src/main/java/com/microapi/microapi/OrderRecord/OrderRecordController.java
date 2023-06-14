package com.microapi.microapi.OrderRecord;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.microapi.microapi.WebClientService;
import com.microapi.microapi.users.Data;

import jakarta.validation.Valid;

@RestController
@Service
@Transactional
public class OrderRecordController {
	@Autowired
	private OrderRecordRepo orderRepo;
	
	public boolean validator(OrderRecord order) throws JsonMappingException, JsonProcessingException {//returns true if user is invalid
		//TODO: compare email against api get request
		WebClientService web = new WebClientService();
		List<String> emails = web.callExternalAPI();
		List<OrderRecord> orders = orderRepo.findAll();
		for (OrderRecord o : orders) {
            // Perform the necessary comparison based on your requirements
            if (order.getEmail().equals(o.getEmail()) && order.getProductID().equals(o.getProductID())) {
                return true;//the order is valid if customer has note entered this product already
            }
        }
		for (String e : emails) {
			if(order.getEmail().equals(e)) {
				return false;//the order is valid if email exists in list called by webclientservice
			}
		}
		return true;
	}

	@PostMapping("/orders")
	ResponseEntity<Long> postOrder(@Valid @RequestBody Data o) throws JsonMappingException, JsonProcessingException {
		OrderRecord order = new OrderRecord(o.getId(), o.getEmail(), o.getFirst_name(), o.getLast_name(), o.getAvatar());
		if(validator(order)) return null;
		System.out.println(order.getId());
		System.out.println(order.getEmail());
		orderRepo.save(order);
		return ResponseEntity.ok(order.getProductID());
	}
	@GetMapping("/getOrders")
	public List<OrderRecord> getOrder() {
		List<OrderRecord> orders = orderRepo.findAll();
		return orders;
	}
	
}
