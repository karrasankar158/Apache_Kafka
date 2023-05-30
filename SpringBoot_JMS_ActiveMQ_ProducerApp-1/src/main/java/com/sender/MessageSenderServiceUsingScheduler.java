package com.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderServiceUsingScheduler {

	@Value("${springjms.myQueue}")
	private String  queueName;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Scheduled(cron = "*/10 * * * * *")
	public void mq() {
		System.out.println("Message sent");
		jmsTemplate.send(queueName,(session)->
		session.createTextMessage("Hello From Producer App: "+new Date()));
	}

}
