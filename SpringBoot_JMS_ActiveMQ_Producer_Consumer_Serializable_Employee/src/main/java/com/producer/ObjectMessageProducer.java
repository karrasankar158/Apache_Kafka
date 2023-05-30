package com.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.model.Employee;

@Component
public class ObjectMessageProducer implements CommandLineRunner{

	@Value("${springjms.myQueue}")
	private String  queueName;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("SENT");
		//this is network understable format so toString will not work here.
		jmsTemplate.convertAndSend(queueName, new Employee(101,"SUPERCODE"));
		
	}

}
