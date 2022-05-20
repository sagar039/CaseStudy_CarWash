package saket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//it is a main or starting point of an application we use @SpringBootApplication
//to put @SpringBootApplication to create a Spring Boot application
//The @EnableEurekaServer annotation is used to make your Spring Boot application acts as a Eureka Server.
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerServiceApplication.class, args);
	}

}
