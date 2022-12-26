package IssueWords;

import DataProcess.Issue;
import DataProcess.StoreData;
import DataProcess.Time;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static DataProcess.GetWebData.getURL;
import static IssueWords.totalWords.clearMap;

public class getWords {
	static List<String> names = new ArrayList<>();
	static String owner, repoName;
	
	// 调用这个东西就可以获得所有的word
	public static void getWord(){
		names.clear();
		getIssuesNames();
		traverse();
		clearMap();
	}
	
	public static void getIssuesNames() {
		owner = "CC-Vltava";
		repoName = "Java2Project";
//		repoName = StoreData.repoName;
//		owner = StoreData.owner;
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
				String s1 = (String) map.get("url");
				List<String> ce = Arrays.stream(s1.split("/")).toList();
				String id = ce.get(ce.size() - 1);
				names.add(id);
			}
		}
		System.out.println(names);
	}
	
	public static void traverse() {
		for (String id : names) {
			getSingleIssue(id);
			System.out.println(totalWords.getMap());
		}
	}
	
	public static void beginWith(String info, String signal) {
		for(int i = 0; i <= info.length() - 100; i++) {
			if(info.startsWith(signal, i)) {
				int pos = i;
				String text = "";
				while (pos < info.length() && info.charAt(pos) != '\n') {
					text += info.charAt(pos);
					pos++;
				}
				solve(text);
			}
		}
	}
	
	public static void solve(String text) {
		List<String> list = Arrays.stream(text.split(" ")).toList();
		list.forEach(totalWords::addWord);
	}
	
	public static void getSingleIssue(String id) {
		String info = "";
		try {
			info = getSingleURL(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		beginWith(info, "<meta name=\"description\" content=");
		beginWith(info, "<p dir=\"auto\">");
	}
	
	public static String getSingleURL(String id) throws IOException {
		String s = "https://github.com/" + owner + "/" + repoName + "/issues/" + id;
		URL url = new URL(s);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		
		int responseCode = connection.getResponseCode();
		String responseMessage = connection.getResponseMessage();
		InputStream inputStream = connection.getInputStream();
//		System.out.println(responseCode);
//		System.out.println(responseMessage);
		StringBuilder information = new StringBuilder();
		byte[] buffer = new byte[1024];
		int readLen = 0;
		while ((readLen = inputStream.read(buffer)) != -1) {
			String newString = new String(buffer, 0, readLen);
			information.append(newString);
		}
		return String.valueOf(information);
	}
}
