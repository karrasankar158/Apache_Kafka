package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.produer.MessageProducer;
import com.produer.store.MessageStore;

@RestController
public class KafkaRestController {

	@Autowired
	private MessageProducer producer;

	@Autowired
	private MessageStore store;
	/**
	 *  send message to Kafka
	 * @param message
	 * @return
	 */
	@GetMapping("/send")
	public String sendMessage(@RequestParam("message") String message) {
		producer.sendMessage(message);
		return "DONE";
	}

	/**
	 * read data
	 * @return
	 */
	@GetMapping("/all")
	public String getAllMessages() {
		return store.getAllMessager();
	}

}
