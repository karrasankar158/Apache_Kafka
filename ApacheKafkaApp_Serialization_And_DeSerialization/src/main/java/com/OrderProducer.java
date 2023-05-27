package com;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.model.Order;

public class OrderProducer {
	
	public static void main(String[] args) {
		//1. Configuration Properties
		Properties props=new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		//props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		props.put("value.serializer","com.serializer.OrderSerializer");

		//2. Create Kafka Producer Object
		KafkaProducer<String,Order> producer=new KafkaProducer<>(props);

		//3. Create Kafka Record
		Order order=new Order();
		
		order.setCustomerName("Sankar");
		order.setProduct("IPhone");
		order.setQuantity(1);

		String topic="order23";
		ProducerRecord<String, Order> record=new ProducerRecord<>(topic,order.getCustomerName(),order);

		//4.  send(record), flush and close
		producer.send(record);
		producer.flush();
		producer.close();

		//5. Print simple message
            System.out.println("Data is Sent!! ");
	}
}
