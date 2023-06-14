package com.microapi.microapi;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microapi.microapi.users.ResponseData;
import reactor.core.publisher.Mono;

public class WebClientService {
	private final WebClient webClient;
	private static final ObjectMapper mapper = new ObjectMapper();


   

	public WebClientService() {
        this.webClient = WebClient.create();
    }
	public List<String> callExternalAPI() throws JsonMappingException, JsonProcessingException {
		List<String> output = new ArrayList<String>();
        String apiUrl = "https://reqres.in/api/users";
        // Send the GET request and receive the response
        Mono<String> response = webClient.get()
	        .uri(apiUrl)
	        .accept(MediaType.APPLICATION_JSON)
	        .retrieve()
	        .bodyToMono(String.class).log();
        String json = response.block();
        ResponseData responseData = mapper.readValue(json, ResponseData.class);
        responseData.getData().forEach(Data -> {
        	output.add(Data.getEmail());
        });
        return output;
	}

}
