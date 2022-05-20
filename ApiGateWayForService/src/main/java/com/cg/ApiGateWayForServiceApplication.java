package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//The @EnableEurekaClient annotation makes your Spring Boot application act as a Eureka client. 
//To register the Spring Boot application into Eureka Server 
@SpringBootApplication
@EnableEurekaClient
public class ApiGateWayForServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayForServiceApplication.class, args);
	}

}
