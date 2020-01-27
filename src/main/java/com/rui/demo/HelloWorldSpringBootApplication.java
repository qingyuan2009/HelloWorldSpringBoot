package com.rui.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @SpringBootApplication 包含了 @EnableAutoConfiguration
public class HelloWorldSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSpringBootApplication.class, args);
	}

}
