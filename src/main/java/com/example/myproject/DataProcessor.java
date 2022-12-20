package com.example.myproject;

import DataProcess.Repo;

import static DataProcess.ReadData.readData;
import static DataProcess.StoreData.storeData;
import static DataProcess.StoreData.storeData1;

public class DataProcessor {
	public static Repo repo;
	public static void dataProcess(){
		storeData();
		repo = readData();
	}
	public static void dataProcess1(){
		storeData1();
		repo = readData();
	}
}
