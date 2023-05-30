package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms //require this annotation at consumer side only
public class SpringBootJmsActiveMqProducerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJmsActiveMqProducerAppApplication.class, args);
	}

}
