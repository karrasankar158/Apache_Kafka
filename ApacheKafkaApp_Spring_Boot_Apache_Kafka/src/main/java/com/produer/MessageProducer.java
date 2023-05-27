package com.produer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
	
	@Autowired
	private KafkaTemplate< String, String> template;
	
	@Value("${my.app.kafka.topic}")
	private String topic;
	
	public void sendMessage(String message) {
		template.send(topic,message);
	}

}
