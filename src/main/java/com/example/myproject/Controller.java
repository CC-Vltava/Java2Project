package com.example.myproject;

import DataProcess.ReadData;
import DataProcess.Repo;
import DataProcess.StoreData;
import IssueWords.passWords;
import ResponseData.WebDev;
import ResponseData.WebDeveloper;
import ResponseData.WebRelease;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static IssueWords.getWords.getWord;
import static com.example.myproject.DataProcessor.dataProcess1;

@CrossOrigin(origins = {"*", "null"})
@RestController
public class Controller {
	@GetMapping("/test")
	public String test() {
		return "TEST";
	}
	
	@GetMapping("/get-issues")
	public String getIssues() {
		Repo repo = DataProcessor.repo;
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		return gson.toJson(repo.getIssues());
	}
	
	@GetMapping("/get-developers")
	public String getDevelopers() {
		Repo repo = DataProcessor.repo;
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		return gson.toJson(repo.getDevelopers());
	}
	
	@GetMapping("/get-releaseandcommit")
	public String getReleaseAndCommit() {
		Repo repo = DataProcessor.repo;
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		return gson.toJson(repo.getReleaseAndCommits());
	}
	
	@GetMapping("/get-WWME")
	public String getWWME() {
		Repo repo = DataProcessor.repo;
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		return gson.toJson(repo.getWWME());
	}
	
	@GetMapping("/get-Web-Developer")
	public String getWebDeveloper() {
		Repo repo = DataProcessor.repo;
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		WebDeveloper webDeveloper = repo.getWebDeveloper();
		List<String> name = new ArrayList<>();
		List<Integer> times = new ArrayList<>();
		webDeveloper.getDevelopers().forEach(x -> {
			name.add(x.getName());
			times.add(x.getNumberOfCommit());
		});
		WebDev webDev = new WebDev(webDeveloper.getTotalDeveloper(), name, times);
		return gson.toJson(webDev);
	
	}
	
	@GetMapping("/get-Web-Issue")
	public String getWebIssue() {
		Repo repo = DataProcessor.repo;
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		return gson.toJson(repo.getWebIssue());
	}

	@GetMapping("/get-Web-Release")
	public String getWebRelease() {
		Repo repo = DataProcessor.repo;
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		WebRelease webRelease = new WebRelease(repo.getReleaseAndCommits());
		return (gson.toJson(webRelease));
	}
	
	@GetMapping("/get-Web-Word")
	public String getWebWord() {
		getWord();
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		return (gson.toJson(new passWords()));
	}
	
	@PostMapping("/post")
	public String getRequest(@RequestBody queryForm queryForm) {
		String owner = queryForm.getOwner();
		String repoName = queryForm.getRepoName();
		System.out.println(owner);
		StoreData.setOwner(owner);
		ReadData.setOwner(owner);
		System.out.println(repoName);
		StoreData.setRepoName(repoName);
		ReadData.setRepoName(repoName);
		dataProcess1();
		return "Get Repo";
	}
}
