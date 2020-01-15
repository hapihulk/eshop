package com.eshop.messageservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.messageservice.producer.KafkaProducer;

@RestController
public class KafkaController {

	@Autowired
    private final KafkaProducer producer;

    public KafkaController(final KafkaProducer producer) {
        this.producer = producer;
    }

    @RequestMapping("/api/v1/publish")
    public String sendMessageToKafkaTopic(@RequestParam("message") final String message){
    	
        this.producer.sendMessage(message);
        
        return message;
    }
}
