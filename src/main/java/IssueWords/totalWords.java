package IssueWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class totalWords {
	static Map<String, Integer> map = new HashMap<>();
	
	public static void addWord(String word) {
		if (map.containsKey(word))
			map.replace(word, map.get(word) + 1);
		else
			map.put(word, 1);
	}
	
	public static Map<String, Integer> getMap() {
		return map;
	}
	public static boolean check(String x){
		for(int i = 0; i < x.length(); i++)
		{
			char c = x.charAt(i);
			if(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') ||('0' <= c && c <= '9'))
				continue;
			return true;
		}
		return false;
	}
	public static void clearMap() {
		List<String> list = new ArrayList<>();
		map.keySet().forEach(x -> {
			if (x.length() >= 10 || x.length() <= 1)
				list.add(x);
			if (x.equals("your") || x.equals("you") || x.equals("would") || x.equals("is") || x.equals("are") || x.equals("the"))
				list.add(x);
			if (map.get(x) <= 5)
				list.add(x);
			if (x.equals("be") || x.equals("just") || x.equals("with") || x.equals("Please") || x.equals("when") || check(x))
				list.add(x);
		});
		list.forEach(x -> {
			map.remove(x);
		});
		System.out.println(map);
	}
	
}
