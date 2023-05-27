package com;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerService {

	public static void main(String[] args) {

		System.out.println("Consumer Started..");

		//1. Define kafka setup Properties
		Properties props=new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		//props.put(ConsumerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,IntegerDeserializer.class.getName());

		props.put(ConsumerConfig.GROUP_ID_CONFIG,"abc");

		//2. Create Kafka Consumer Object
		@SuppressWarnings("resource")
		KafkaConsumer<String,Integer> consumer=new KafkaConsumer<>(props);

		//3.Link with message broker (subscribe) using topicName
		String topic="chatting13";
		consumer.subscribe(Arrays.asList(topic));

		//4. poll for new data check and read/print

		while(true) {
			//try to get data from message broker for every one second gap
			ConsumerRecords<String, Integer> records=consumer.poll(Duration.ofMillis(1000));
			for(ConsumerRecord<String,Integer> rec: records) {
				System.out.println("Message:  "+rec.value());
				
				String key=rec.key();
				
				String data[]=key.split(",");
				
				for(int i=0;i<data.length;i++) {
					System.out.println(data[i]);
				}
			}
		}
	}
}
