package com.eshop.messageservice.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "test", groupId = "group-id")
	public void consume(String message) {
		
		System.out.println(message);
	}
}
