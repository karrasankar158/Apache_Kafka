package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootJmsActiveMqProducerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJmsActiveMqProducerAppApplication.class, args);
	}

}
