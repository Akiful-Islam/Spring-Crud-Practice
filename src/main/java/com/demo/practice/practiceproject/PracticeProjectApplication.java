package com.demo.practice.practiceproject;

import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeProjectApplication.class, args);
		System.out.println("Server successfully started!");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Server stopped!");
	}

}
