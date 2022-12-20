package com.example.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.myproject.DataProcessor.dataProcess;

@SpringBootApplication
public class MyProjectApplication {
	public static void main(String[] args) {
//		dataProcess();
		SpringApplication.run(MyProjectApplication.class, args);
	}
}
