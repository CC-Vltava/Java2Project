package IssueWords;


import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class passWords {
	List<String> words = new ArrayList<>();
	List<Integer> number = new ArrayList<>();
	public passWords(){
		Map<String, Integer> map = totalWords.getMap();
		map.forEach((word, num) -> {
			words.add(word);
			number.add(num);
		});
	}
}
