package com.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.dto.User;

@Service
public class UserConsumerService {

	
	@KafkaListener(topics = {"userproTopic"})
	public void consumerUserData(User user) {
		System.out.println("User name Is: "+user.getName());
		System.out.println("User Fav Is: "+user.getFav());
		System.out.println("User Age Is: "+user.getAge());
	}

}
