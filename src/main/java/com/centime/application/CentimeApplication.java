package com.centime.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.centime.application.*"})
public class CentimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentimeApplication.class, args);
	}

}
