package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/*
 * To make a deploy a war file
 * 1. Change pom file to .war
 * 2. Extend to SpringBootServletInitializer
 * 3. Overwrite Configure
 */

@SpringBootApplication
public class MicroserviceBootApplication extends SpringBootServletInitializer{

	/**
	 * 
	 * Used when run as Jar
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBootApplication.class, args);
	}

	
	/**
	 * 
	 * Used when run as War
	 */
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MicroserviceBootApplication.class);
	}
	
	
}
