package org.example;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		Student student = new Student("CC", 18, 12010201);
		System.out.println(student);
		Gson gson = new Gson();
		System.out.println(gson.toJson(student));
		List<Student> list = new ArrayList<>();
		list.add(student);
		System.out.println(gson.toJson(list));
	}
}
