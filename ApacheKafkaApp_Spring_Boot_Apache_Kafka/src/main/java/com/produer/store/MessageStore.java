package com.produer.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStore {

	private List<String> list=new ArrayList<>();

	public void addMessage(String message) {
		list.add(message);
	}
	
	public String getAllMessager() {
		
		return list.toString();
	}

}
