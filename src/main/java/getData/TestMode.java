package getData;

import java.util.List;

import static getData.GetWebData.*;

public class TestMode {
	public static void testRepoName(){
		System.out.println("testRepoName");
		System.out.println(getRepoName("CC-Vltava"));
		System.out.println();
	}
	public static void testIssues(){
		System.out.println("testIssues");
		List<Issue> issues = getIssues("CC-Vltava", "123");
		for(Issue issue : issues)
			System.out.println(issue);
		System.out.println();
	}
	public static void testTime(){
		System.out.println("testTime");
		Time time = new Time("2022-12-18T11:49:57Z");
		System.out.println(time);
		System.out.println();
	}
	public static void testDeveloper(){
		System.out.println("testDeveloper");
		List<Developer> developers = getDevelopers("CC-Vltava", "cs-self-learning");
		for(Developer developer : developers)
			System.out.println(developer);
		System.out.println();
	}
	public static void testReleaseAndCommit(){
		System.out.println("testReleaseAndCommit");
		List<ReleaseAndCommit> list = getReleaseAndCommit("NekoX-Dev", "NekoX");
		for(ReleaseAndCommit releaseAndCommit : list)
			System.out.println(releaseAndCommit);
		System.out.println();
	}
}
