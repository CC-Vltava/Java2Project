package com.example.myproject;

import DataProcess.ReadData;
import DataProcess.Repo;
import DataProcess.StoreData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;

import static DataProcess.GetWebData.getRepoName;
import static com.example.myproject.DataProcessor.dataProcess1;

@CrossOrigin(origins = {"*", "null"})
@RestController
public class Controller {
	@GetMapping("/test")
	public String test(){
		return "TEST";
	}
	@GetMapping("/get-issues")
	public String getIssues(){
		Repo repo = DataProcessor.repo;
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		return gson.toJson(repo.getIssues());
	}
	@GetMapping("/get-developers")
	public String getDevelopers(){
		Repo repo = DataProcessor.repo;
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		return gson.toJson(repo.getDevelopers());
	}
	@GetMapping("/get-releaseandcommit")
	public String getReleaseAndCommit(){
		Repo repo = DataProcessor.repo;
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		return gson.toJson(repo.getReleaseAndCommits());
	}
	@PostMapping("/post-owner")
	public String getOwner(@RequestBody String owner){
		StoreData.setOwner(owner);
		ReadData.setOwner(owner);
		return getRepoName(owner).toString();
	}
	@PostMapping("/post-reponame")
	public String getRepo(@RequestBody String repoName){
		StoreData.setRepoName(repoName);
		ReadData.setRepoName(repoName);
		dataProcess1();
		return "Get Repo Name!";
	}
}
