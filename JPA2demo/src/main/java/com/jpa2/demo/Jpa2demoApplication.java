package com.jpa2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= "com.jpa2")
public class Jpa2demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jpa2demoApplication.class, args);
	}

}
