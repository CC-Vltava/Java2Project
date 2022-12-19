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
	// 这个直接返回一个字符串了
	public String getResolutionTime(){
		if(isOpenIssue)
			return "This issue is open";
		int year = endTime.year - beginTime.year;
		int month = endTime.month - beginTime.month;
		int day = endTime.day - beginTime.day;
		if(day < 0)
			month--;
		if(month < 0)
			year--;
		if(year != 0)
			return "More than a year";
		if(month == 0)
			return "Less than a month";
		return "About " + month + " months";
	}
}
