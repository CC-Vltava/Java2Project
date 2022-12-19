package DataProcess;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


public class GetWebData {
	public static String getURL(String s, String method) throws IOException {
		URL url = new URL(s);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(method);
		connection.connect();
		
		int responseCode = connection.getResponseCode();
		String responseMessage = connection.getResponseMessage();
		InputStream inputStream = connection.getInputStream();
//		System.out.println(responseCode);
//		System.out.println(responseMessage);
		String information = "";
		byte[] buffer = new byte[1024];
		int readLen = 0;
		while ((readLen = inputStream.read(buffer)) != -1) {
			String newString = new String(buffer, 0, readLen);
			information += (newString);
		}
		return information;
	}
	
	public static List<String> getRepoName(String owner) {
		String s = "https://github.com/" + owner;
		String information = "";
		try {
			information = getURL(s + "?tab=repositories", "GET");
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> ans = new ArrayList<>();
//		System.out.println(information);
		String findPosition = "<a href=\"/" + owner + "/";
		int firstPosition = information.indexOf(findPosition);
		for (int i = firstPosition; i < information.length() - 50; i++) {
			if (information.substring(i, i + findPosition.length()).equals(findPosition)) {
//				System.out.println(information.substring(i, i + findPosition.length()));
				String name = "";
				int posNow = i + findPosition.length();
				while (information.charAt(posNow) != '"') {
					name += information.charAt(posNow);
					posNow++;
				}
				ans.add(name);
			}
		}
		return ans;
	}
	
	public static List<Issue> getIssues(String owner, String repoName){
		List<Issue> issues = new ArrayList<>();
		String targetURL = "https://api.github.com/repos/" + owner + "/" + repoName + "/issues?state=all";
		String information = "";
		try {
			information = getURL(targetURL, "GET");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		List list = gson.fromJson(information, List.class);
		for(Object s : list){
			if(s instanceof LinkedTreeMap<?,?>)
			{
				LinkedTreeMap<?, ?> map = (LinkedTreeMap<?, ?>) s;
				Issue issue = new Issue(map.get("state").equals("open"),
						new Time((String) map.get("created_at")), new Time((String) map.get("closed_at")));
				issues.add(issue);
			}
		}
		return issues;
	}
	
	public static List<Developer> getDevelopers(String owner, String repoName){
		List<Developer> developers = new ArrayList<>();
		String targetURL = "https://api.github.com/repos/" + owner + "/" + repoName + "/" + "contributors";
		String information = "";
		try {
			information = getURL(targetURL, "GET");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		List list = gson.fromJson(information, List.class);
		for(Object s : list){
			if(s instanceof LinkedTreeMap<?,?>)
			{
				LinkedTreeMap<?, ?> map = (LinkedTreeMap<?, ?>) s;
				Developer developer = new Developer((String) map.get("login"),
						(int)Math.round((Double) map.get("contributions")));
				developers.add(developer);
			}
		}
		return developers;
	}
	
	public static List<ReleaseAndCommit> getRelease(String owner, String repoName){
		List<ReleaseAndCommit> releaseList = new ArrayList<>();
		String targetURL = "https://api.github.com/repos/" + owner + "/" + repoName + "/" + "releases";
		String information = "";
		try {
			information = getURL(targetURL, "GET");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		List list = gson.fromJson(information, List.class);
		for(Object s : list){
			if(s instanceof LinkedTreeMap<?,?>)
			{
				LinkedTreeMap<?, ?> map = (LinkedTreeMap<?, ?>) s;
				ReleaseAndCommit releaseAndCommit = new ReleaseAndCommit(1,
						new Time((String) map.get("created_at")));
				releaseList.add(releaseAndCommit);
			}
		}
		return releaseList;
	}
	
	public static List<ReleaseAndCommit> getCommit(String owner, String repoName){
		List<ReleaseAndCommit> commitList = new ArrayList<>();
		String targetURL = "https://api.github.com/repos/" + owner + "/" + repoName + "/" + "commits";
		String information = "";
		try {
			information = getURL(targetURL, "GET");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		List list = gson.fromJson(information, List.class);
		for(Object s : list){
			if(s instanceof LinkedTreeMap<?,?>)
			{
				LinkedTreeMap<?, ?> map = (LinkedTreeMap<?, ?>) s;
				ReleaseAndCommit releaseAndCommit = new ReleaseAndCommit(0,
						new Time((String) (((LinkedTreeMap<?, ?>) ((LinkedTreeMap<?, ?>) map.get("commit")).get("author")).get("date"))));
				commitList.add(releaseAndCommit);
			}
		}
		return commitList;
	}
	
	public static List<ReleaseAndCommit> getReleaseAndCommit(String owner, String repoName){
		List<ReleaseAndCommit> releaseList = getRelease(owner, repoName);
		List<ReleaseAndCommit> commitList = getCommit(owner, repoName);
		List<ReleaseAndCommit> list = new ArrayList<>();
		list.addAll(releaseList);
		list.addAll(commitList);
		list.sort((x, y) -> String.CASE_INSENSITIVE_ORDER.compare(x.getTime().time, y.getTime().time));
		return list;
	}
	
	public static Repo getRepoInformation(String owner, String repoName){
		Repo repo = new Repo(repoName);
		repo.setIssues(getIssues(owner, repoName));
		repo.setDevelopers(getDevelopers(owner, repoName));
		repo.setReleaseAndCommits(getReleaseAndCommit(owner, repoName));
		return repo;
	}
	
	public static void main(String[] args) throws IOException {
//		testRepoName();
//		testTime();
//		testIssues();
//		testDeveloper();
//		testReleaseAndCommit();
//		testRepo2Json();
	}
}

