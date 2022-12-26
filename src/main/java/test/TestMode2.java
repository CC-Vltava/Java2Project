package test;

import IssueWords.passWords;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static IssueWords.getWords.getIssuesNames;
import static IssueWords.getWords.getWord;
import static IssueWords.totalWords.clearMap;

public class TestMode2 {
	public static void main(String[] args) {
		testIssueWords();
	}
	
	private static void testIssueWords() {
		getWord();
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		System.out.println((gson.toJson(new passWords())));
	}
}
