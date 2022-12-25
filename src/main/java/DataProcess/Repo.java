package DataProcess;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;

@Data
public class Repo {
	String name;
	List<Developer> developers;
	List<Issue> issues;
	List<ReleaseAndCommit> releaseAndCommits;
	
	Repo(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Developer> getDevelopers() {
		return developers;
	}
	
	public List<Issue> getIssues() {
		return issues;
	}
	
	public List<ReleaseAndCommit> getReleaseAndCommits() {
		return releaseAndCommits;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}
	
	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}
	
	public void setReleaseAndCommits(List<ReleaseAndCommit> releaseAndCommits) {
		this.releaseAndCommits = releaseAndCommits;
	}
	
	public List<Integer> getWWME(){
		List<Integer> list = new ArrayList<>();
		int weekday;
		int morning;
		weekday = (int) releaseAndCommits.stream().filter(x -> x.isWeekDay.equals("Weekday")).count();
		morning = (int) releaseAndCommits.stream().filter(x -> x.isMorining.equals("Morning")).count();
		list.add(weekday);
		list.add(releaseAndCommits.size() - weekday);
		list.add(morning);
		list.add(releaseAndCommits.size() - morning);
		return list;
	}
}
