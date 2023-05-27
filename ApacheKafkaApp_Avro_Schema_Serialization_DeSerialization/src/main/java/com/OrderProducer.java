package com;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.kafka.avro.Order;

import io.confluent.kafka.serializers.KafkaAvroSerializer;


public class OrderProducer {
	
	public static void main(String[] args) {
		//1. Configuration Properties
		Properties props=new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,KafkaAvroSerializer.class.getName());
		props.put("value.serializer",KafkaAvroSerializer.class.getName());
		props.put("schema.registry.url","http://localhost:8081");

		//2. Create Kafka Producer Object
		KafkaProducer<String,Order> producer=new KafkaProducer<>(props);

		//3. Create Kafka Record
		Order order=new Order("Sankar","IPhone",1);

		String topic="orderavro23";
		ProducerRecord<String, Order> record=new ProducerRecord<>(topic,order.getCustomerName().toString(),order);

		//4.  send(record), flush and close
		producer.send(record);
		producer.flush();
		producer.close();

		//5. Print simple message
            System.out.println("Data is Sent!! ");
	}
}
