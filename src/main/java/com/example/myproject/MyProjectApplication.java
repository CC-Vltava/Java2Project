package com.example.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import static com.example.myproject.DataProcessor.dataProcess;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class )
public class MyProjectApplication {
	public static void main(String[] args) {
//		dataProcess();
		SpringApplication.run(MyProjectApplication.class, args);
	}
}
