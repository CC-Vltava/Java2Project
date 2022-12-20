package DataProcess;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static DataProcess.GetWebData.getRepoInformation;
import static DataProcess.GetWebData.getRepoName;

public class StoreData {
	static String owner, repoName;
	
	public static void setOwner(String owner) {
		StoreData.owner = owner;
	}
	
	public static void setRepoName(String repoName) {
		StoreData.repoName = repoName;
	}
	
	public static void storeData() {
		getInput();
		makeDir();
		storeRepo();
	}
	
	public static void storeData1() {
		makeDir();
		storeRepo();
	}
	
	public static void getInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input your owner's name");
		owner = scanner.next();
		System.out.println(getRepoName(owner));
		System.out.println("Please select your repo");
		repoName = scanner.next();
		ReadData.owner = owner;
		ReadData.repoName = repoName;
	}
	
	public static void makeDir() {
		String path = "src/Data/" + owner;
		if (!Files.exists(Path.of(path))) {
			try {
				Files.createDirectories(Path.of(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		path = path + "/" + repoName + ".txt";
		if (!Files.exists(Path.of(path))) {
			try {
				Files.createFile(Path.of(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void storeRepo() {
		String path = "src/data/" + owner + "/" + repoName + ".txt";
		System.out.println("Catching Data");
		Repo repo = getRepoInformation(owner, repoName);
		System.out.println("Store Data");
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()   //在序列化的时候不忽略null值
				.create();
		File file = new File(path);
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			String output = gson.toJson(repo);
			writer.write(output);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Finish!");
	}
	
}
