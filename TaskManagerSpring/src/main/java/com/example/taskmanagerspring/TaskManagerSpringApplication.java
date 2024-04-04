package com.example.taskmanagerspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Base64;


@SpringBootApplication
public class TaskManagerSpringApplication {

	public static void main(String[] args)throws Exception {
		SpringApplication.run(TaskManagerSpringApplication.class, args);

		Long userId = 1L;

		// Encode long
		String encodedLong = Base64.getEncoder().encodeToString(String.valueOf(userId).getBytes());

		System.out.println("Encoded userId: " + encodedLong);
	}
}
