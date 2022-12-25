package DataProcess;

import ResponseData.WebDeveloper;
import ResponseData.WebIssue;
import ResponseData.WebRelease;
import com.example.myproject.DataProcessor;
import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

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
	
	
	
	public WebDeveloper getWebDeveloper() {
		Repo repo = DataProcessor.repo;
		WebDeveloper webDeveloper = new WebDeveloper();
		webDeveloper.setTotalDeveloper(repo.getDevelopers().size());
		int cnt = 0;
		for(Developer developer : repo.getDevelopers()){
			webDeveloper.addDeveloper(developer);
			cnt++;
			if(cnt == 3)
				break;
		}
		return webDeveloper;
	}
	
	
	public WebIssue getWebIssue() {
		Repo repo = DataProcessor.repo;
		WebIssue webIssue = new WebIssue();
		webIssue.setOpenIssue((int) repo.getIssues().stream().filter(x -> x.isOpenIssue).count());
		webIssue.setClosedIssue((int) repo.getIssues().stream().filter(x -> !x.isOpenIssue).count());
		List <Issue> issues = repo.getIssues().stream().filter(x -> !x.isOpenIssue).toList();
//		System.out.println(issues);
//		System.out.println(issues.get(0).getResolutionTime1().getTheDay());
//		System.out.println(issues.get(1).getResolutionTime1().getTheDay());
		double E, E2;
		E = issues.stream().map(Issue::getResolutionTime1).mapToDouble(time -> time.day + time.month * 30 + time.year * 365).average().orElse(0);
		E2 = issues.stream().map(Issue::getResolutionTime1).mapToDouble(time ->
				(time.day + time.month * 30 + time.year * 365) * (time.day + time.month * 30 + time.year * 365)).average().orElse(0);
		webIssue.setMeanDays(E);
		webIssue.setVarDays(E2 - E * 2);
		int ma = 0, mi = 123123123;
		for(int i = 0; i < issues.size(); i++){
			int val = issues.get(i).getResolutionTime1().getTheDay();
			ma = max(ma, val);
			mi = min(mi, val);
		}
		webIssue.setDifferDays(ma - mi);
		return webIssue;
	}
	
	
//	public WebRelease getWebRelease() {
//
//	}
}
