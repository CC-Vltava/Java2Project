package com.example.myproject;

import DataProcess.Repo;

import static DataProcess.ReadData.readData;
import static DataProcess.StoreData.storeData;

public class DataProcesser {
	public static Repo repo;
	public static void dataProcess(){
		storeData();
		repo = readData();
	}
}
