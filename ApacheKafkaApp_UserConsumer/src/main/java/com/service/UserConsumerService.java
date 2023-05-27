package com.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumerService {

	
	@KafkaListener(topics = {"userproTopic"})
	public void consumerUserData(int age) {
		System.out.println("User Age Is: "+age);
	}

}
