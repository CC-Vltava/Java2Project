package DataProcess;

import lombok.AllArgsConstructor;

public class Issue {
	boolean isOpenIssue;
	Time beginTime, endTime;
	String bTime, eTime;
	String resolutionTime;
	
	public Issue(boolean isOpenIssue, Time t1, Time t2) {
		this.isOpenIssue = isOpenIssue;
		beginTime = t1;
		endTime = t2;
		bTime = t1.toString();
		eTime = t2.toString();
		this.getResolutionTime();
	}
	
	@Override
	public String toString() {
		String ans = isOpenIssue ? "opened" : "closed" + " ";
		ans += beginTime.toString() + " " + endTime.toString();
		return ans;
	}
	
	// 这个直接返回一个字符串了
	public void getResolutionTime() {
		if (isOpenIssue) {
			resolutionTime = "This issue is open";
			return;
		}
		int year = endTime.year - beginTime.year;
		int month = endTime.month - beginTime.month;
		int day = endTime.day - beginTime.day;
		if (day < 0)
			month--;
		if (month < 0)
			year--;
		if (year != 0)
			resolutionTime = "More than a year";
		else if (month == 0)
			resolutionTime = "Less than a month";
		else
			resolutionTime = "About " + month + " months";
	}
}
