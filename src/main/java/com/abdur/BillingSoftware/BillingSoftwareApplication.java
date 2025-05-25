package com.abdur.BillingSoftware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Starter File for the Spring Boot Application
//This file is the entry point for the Spring Boot application
//It contains the main method which is the starting point of the application
//It is annotated with @SpringBootApplication which enables auto-configuration, component scanning, and configuration properties
//It is the main class that will be run when the application is started
//It is the class that will be used to run the application

@SpringBootApplication
public class BillingSoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingSoftwareApplication.class, args);
	}

}
