package DataProcess;

import lombok.Data;

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
}
