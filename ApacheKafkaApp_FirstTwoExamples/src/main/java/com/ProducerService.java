package com;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;


public class ProducerService {
	
	public static void main(String[] args) {
		//1. Configuration Properties
		Properties props=new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		//props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,IntegerSerializer.class.getName());

		//2. Create Kafka Producer Object
		KafkaProducer<String,Integer> producer=new KafkaProducer<>(props);

		//3. Create Kafka Record
		Integer id=123;
		String message="22.5726 N,88.3639 E";
		String topic="chatting13";
		ProducerRecord<String, Integer> record=new ProducerRecord<>(topic,message,id);

		//4.  send(record), flush and close
		producer.send(record);
		producer.flush();
		producer.close();

		//5. Print simple message
            System.out.println("Data is Sent!! ");
	}
}
