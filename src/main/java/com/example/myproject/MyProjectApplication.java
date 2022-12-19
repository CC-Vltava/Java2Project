package com.example.myproject;

import DataProcess.GetWebData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static DataProcess.StoreData.getInput;
import static DataProcess.StoreData.storeData;
import static com.example.myproject.DataProcesser.dataProcess;

@SpringBootApplication
public class MyProjectApplication {
	public static void main(String[] args) {
		dataProcess();
		SpringApplication.run(MyProjectApplication.class, args);
	}
	
}
