package com.sender;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderService implements CommandLineRunner{

	@Value("${springjms.myQueue}")
	private String  queueName;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Message sent");
		/*
		//send(where->DestinationName,what->Message);
		jmsTemplate.send(queueName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				//Message is a interface, TextMessage is a implementation class
				TextMessage message =session.createTextMessage("Hello From Producer App: "+new Date());
				return message;
			}
		});*/
		//or
		/*jmsTemplate.send(queueName,(session)->{
			//Message is a interface, TextMessage is a implementation class
			TextMessage message =session.createTextMessage("Hello From Producer App: "+new Date());
			return message;
		});*/
		//or
		jmsTemplate.send(queueName,(session)->
			session.createTextMessage("Hello From Producer App: "+new Date()));
	}

}
