package com.deserializer;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Order;

public class OrderDeSerializer implements Deserializer<Order> {

	@Override
	public Order deserialize(String topic, byte[] data) {
		ObjectMapper objectMapper=new ObjectMapper();
		Order order=null;
		try {
			order=objectMapper.readValue(data, Order.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return order;
	}


}
