package DataProcess;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class Issue {
	boolean isOpenIssue;
	Time beginTime, endTime;
	@Override
	public String toString(){
		String ans = isOpenIssue ? "opened" : "closed" + " ";
		ans += beginTime.toString() + " " + endTime.toString();
		return ans;
	}
}
