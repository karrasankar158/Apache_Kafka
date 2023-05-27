package com.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.produer.store.MessageStore;

@Component
public class MessageConsumer {

	@Autowired
	private MessageStore store;

	@KafkaListener(topics ="${my.app.kafka.topic}",groupId = "abc")
	public void consume(String message) {
		store.addMessage(message);
	}
}
