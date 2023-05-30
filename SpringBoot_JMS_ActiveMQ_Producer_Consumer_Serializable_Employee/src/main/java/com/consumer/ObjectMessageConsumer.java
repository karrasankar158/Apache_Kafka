package com.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.model.Employee;

@Component
public class ObjectMessageConsumer {

	@JmsListener(destination = "${springjms.myQueue}")
	public void readData(Employee employee) {
		System.out.println("Consumer Listening");
		System.out.println("Employee Data: "+employee);
	}

}
