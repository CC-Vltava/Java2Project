package IssueWords;


import lombok.AllArgsConstructor;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@AllArgsConstructor
class Word{
	public String name;
	public int value;
}
public class passWords {
	List<Word> list = new ArrayList<>();
	public passWords(){
		totalWords.getMap().forEach((name, value) -> {
			list.add(new Word(name, value));
		});
	}
}
