package DataProcess;

import lombok.AllArgsConstructor;


public class ReleaseAndCommit {
	int type; // 1 is release, 0 is commit
	Time time;
	String pushTime;
	boolean isWeekDay;
	
	public ReleaseAndCommit(int type, Time time){
		this.type = type;
		this.time = time;
		pushTime = time.toString();
		isWeekDay = getIsWeekDay();
	}
	
	public Time getTime() {
		return time;
	}
	
	public int getType() {
		return type;
	}
	
	@Override
	public String toString(){
		return (type == 1 ? "release" : "commit") + " " + time;
	}
	
	public boolean getIsWeekDay(){
		int day = time.getDay();
		return day <= 5 && day >= 1;
	}
	
}
