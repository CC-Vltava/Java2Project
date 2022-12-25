package test;

import com.example.myproject.DataProcessor;
import com.google.gson.Gson;
import DataProcess.*;
import com.google.gson.GsonBuilder;

import java.util.List;


import static DataProcess.GetWebData.*;
import static com.example.myproject.DataProcessor.dataProcess;

public class TestMode {
	public static void testRepoName() {
		System.out.println("testRepoName");
		System.out.println(getRepoName("CC-Vltava"));
		System.out.println();
	}
	
	public static void testIssues() {
		System.out.println("testIssues");
		List<Issue> issues = getIssues("CC-Vltava", "123");
		for (Issue issue : issues)
			System.out.println(issue);
		System.out.println();
	}
	
	public static void testTime() {
		System.out.println("testTime");
		Time time = new Time("2022-12-18T11:49:57Z");
		System.out.println(time);
		System.out.println();
	}
	
	public static void testDeveloper() {
		System.out.println("testDeveloper");
		List<Developer> developers = getDevelopers("CC-Vltava", "cs-self-learning");
		for (Developer developer : developers)
			System.out.println(developer);
		System.out.println();
	}
	
	public static void testReleaseAndCommit() {
		System.out.println("testReleaseAndCommit");
		List<ReleaseAndCommit> list = getReleaseAndCommit("NekoX-Dev", "NekoX");
		for (ReleaseAndCommit releaseAndCommit : list)
			System.out.println(releaseAndCommit);
		System.out.println();
	}
	
	public static void testRepo2Json() {
		Repo repo = getRepoInformation("CC-Vltava", "123");
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		String output = gson.toJson(repo);
		Repo test = gson.fromJson(output, Repo.class);
		System.out.println(test);
	}
	
	public static void testDataProcesser(){
		dataProcess();
		System.out.println(DataProcessor.repo);
	}
	
	public static void testRepoOutput(){
		Repo repo = getRepoInformation("NekoX-Dev", "NekoX");
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		String output = gson.toJson(repo);
		System.out.println(output);
	}
	
	public static void testIssueOutput(){
		Issue issue = new Issue(false, new Time("2022-12-18T11:49:57Z"), new Time("2025-12-18T11:49:57Z"));
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		String output = gson.toJson(issue);
		System.out.println(output);
	}
	
	public static void main(String[] args) {
//		testDataProcesser();
//		testTimeOutput();
//		testIssueOutput();
//		testRepoOutput();
//		testTIME();
		testWeb();
	}
	
	private static void testWeb() {
		Repo repo = getRepoInformation("NekoX-Dev", "NekoX");
		DataProcessor.repo = repo;
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		String output = gson.toJson(repo.getWebDeveloper());
		System.out.println(output);
		output = gson.toJson(repo.getWebIssue());
		System.out.println(output);
	}
	
	private static void testTIME() {
		Repo repo = getRepoInformation("NekoX-Dev", "NekoX");
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		String output = gson.toJson(repo.getWWME());
		System.out.println(output);
	}
	
}
