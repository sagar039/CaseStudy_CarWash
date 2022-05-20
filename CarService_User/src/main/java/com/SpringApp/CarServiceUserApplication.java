package com.SpringApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//it is a main or starting point of an application we use @SpringBootApplication
//to put @SpringBootApplication to create a Spring Boot application
@SpringBootApplication
public class CarServiceUserApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CarServiceUserApplication.class, args);
	}

}
