package com.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReaderService{
	
	@JmsListener(destination ="${springjms.myQueue}" )
	public void readData(String txt) {
		System.out.println("Consumer Data is: "+txt);
	}
}
