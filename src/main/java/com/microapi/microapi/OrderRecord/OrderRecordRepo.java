package com.microapi.microapi.OrderRecord;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRecordRepo extends JpaRepository<OrderRecord, Long> {

}