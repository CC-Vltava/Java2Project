package DataProcess;

import lombok.AllArgsConstructor;


public class ReleaseAndCommit {
	int type; // 1 is release, 0 is commit
	Time time;
	String pushTime;
	boolean isWeekDay;
	String release;
	
	public ReleaseAndCommit(int type, Time time){
		this.type = type;
		this.time = time;
		pushTime = time.toString();
		isWeekDay = getIsWeekDay();
		release = get();
	}
	
	public String get() {
		if(time.hour >= 8 && time.hour <= 12)
			return "Morning";
		if(time.hour >= 12 && time.hour <= 18)
			return "Afternoon";
		return "Evening";
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
