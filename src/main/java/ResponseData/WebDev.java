package ResponseData;

import java.util.ArrayList;
import java.util.List;

public class WebDev {
	int totalDevelopers;
	List<String> name = new ArrayList<>();
	List<Integer> times = new ArrayList<>();
	public WebDev(int totalDevelopers, List<String> name, List<Integer> times){
		this.totalDevelopers = totalDevelopers;
		this.name = name;
		this.times = times;
	}
}
