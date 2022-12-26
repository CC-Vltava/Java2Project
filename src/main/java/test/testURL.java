package test;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class testURL {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String name = "CC-Vltava";
		String s = "https://github.com/" + name;
		
//		boolean getInput = false;
//		if(getInput)
//			s = scanner.next();
		
		URL url = new URL(s + "?tab=repositories");
		System.out.println("We are going to " + name + "'s repo!");
		
		
		url = new URL("https://github.com/CC-Vltava/Java2Project/issues/4");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		
		int responseCode = connection.getResponseCode();
		String responseMessage = connection.getResponseMessage();
		InputStream inputStream = connection.getInputStream();
		System.out.println(responseCode);
		System.out.println(responseMessage);
		StringBuilder information = new StringBuilder();
		byte[] buffer = new byte[1024];
		int readLen = 0;
		while((readLen = inputStream.read(buffer)) != -1){
			String newString = new String(buffer, 0, readLen);
			information.append(newString);
//			System.out.println(newString);
		}
		System.out.println(information);
		
		// <meta name="description" content=+description
		// <p dir="auto">+comment
		
	}
}

