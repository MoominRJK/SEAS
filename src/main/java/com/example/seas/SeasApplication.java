package com.example.seas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SeasApplication {

	public static void main(String[] args) {

		ApplicationContext run = SpringApplication.run(SeasApplication.class, args);
	}
}
