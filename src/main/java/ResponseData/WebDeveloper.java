package ResponseData;

import DataProcess.Developer;

import java.util.ArrayList;
import java.util.List;

public class WebDeveloper {
	int totalDeveloper;
	List<Developer> developers;
	public WebDeveloper(){
		totalDeveloper = 0;
		developers = new ArrayList<>();
	}
	
	public void addDeveloper(Developer developer){
		developers.add(developer);
	}
	
	public List<Developer> getDevelopers() {
		return developers;
	}
	
	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}
	
	public int getTotalDeveloper() {
		return totalDeveloper;
	}
	
	public void setTotalDeveloper(int totalDeveloper) {
		this.totalDeveloper = totalDeveloper;
	}
}
