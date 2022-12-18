package test;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class  Catch {
	public static void main(String[] args) throws IOException {
//		String s = "https://api.stackexchange.com/questions/27873287?site=stackoverflow";
//		String s = "https://pokeapi.co/api/v2/pokemon/pikachu/";
//		String s = "https://api.github.com/repos/CC-Vltava/HelloWorld/issues?state=all";
		String s = "https://github.com/CC-Vltava/HelloWrold/issues?state=all";
		URL url = new URL(s);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		int responseCode = conn.getResponseCode();
		String responseMessage = conn.getResponseMessage();
		String contentEncoding = conn.getContentEncoding();
		System.out.println(responseCode);
		System.out.println(responseMessage);
		System.out.println(contentEncoding);

		String allInput = "";
		InputStream inputStream = conn.getInputStream();
		byte[] buffer = new byte[100];
		int readLength = 0;
		while((readLength = inputStream.read(buffer)) != -1){
			String input = new String(buffer, 0, readLength);
			allInput += input;
			System.out.println(input);
		}
		Gson gson = new Gson();
//		System.out.println((allInput));
		gson.toJson(allInput);
	}
}
