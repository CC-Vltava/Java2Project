package DataProcess;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {
	static String owner, repoName;
	
	public static void setOwner(String owner) {
		ReadData.owner = owner;
	}
	
	public static void setRepoName(String repoName) {
		ReadData.repoName = repoName;
	}
	
	public static Repo readData() {
		String input = getData();
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		return gson.fromJson(input, Repo.class);
	}
	
	public static String getData() {
		String path = "src/Data/" + owner + "/" + repoName + ".txt";
		File file = new File(path);
		String input = "";
		try {
			FileReader reader = new FileReader(file);
			char[] data = new char[1024];
			int length = 0;
			while ((length = reader.read(data)) > 0) {
				String str = new String(data, 0, length);
				input += str;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
}
