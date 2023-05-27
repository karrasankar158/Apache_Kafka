package com;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import com.deserializer.OrderDeSerializer;
import com.model.Order;

public class OrderConsumer {

	public static void main(String[] args) {

		System.out.println("Consumer Started..");

		//1. Define kafka setup Properties
		Properties props=new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		//props.put(ConsumerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,OrderDeSerializer.class.getName());

		props.put(ConsumerConfig.GROUP_ID_CONFIG,"abc");

		//2. Create Kafka Consumer Object
		@SuppressWarnings("resource")
		KafkaConsumer<String,Order> consumer=new KafkaConsumer<>(props);

		//3.Link with message broker (subscribe) using topicName
		String topic="order23";
		consumer.subscribe(Arrays.asList(topic));

		//4. poll for new data check and read/print

		while(true) {
			//try to get data from message broker for every one second gap
			ConsumerRecords<String, Order> records=consumer.poll(Duration.ofMillis(1000));
			for(ConsumerRecord<String,Order> rec: records) {
				String customerName=rec.key();
				
				Order order=rec.value();
				
				System.out.println("customerName: "+customerName);
				
				System.out.println("Product: "+order.getProduct());
				
				System.out.println("Quantity: "+order.getQuantity());
			}
		}
	}
}
