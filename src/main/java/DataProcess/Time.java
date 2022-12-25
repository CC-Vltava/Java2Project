package DataProcess;

public class Time {
	boolean isNull;
	Integer year, month, day, hour, minute, second;
	String time;
	
	public Time(String s) {
		if (s == null) {
			isNull = true;
		} else {
			// 2022-12-18T11:49:57Z
			time = s;
			year = Integer.parseInt(s.substring(0, 4));
			month = Integer.parseInt(s.substring(5, 7));
			day = Integer.parseInt(s.substring(8, 10));
			hour = Integer.parseInt(s.substring(11, 13));
			minute = Integer.parseInt(s.substring(14, 16));
			second = Integer.parseInt(s.substring(17, 19));
		}
	}
	public Time(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int getTheDay(){
		return day;
	}
	
	@Override
	public String toString() {
		if (isNull)
			return "null";
		return time;
	}
	
	public int getDay() {
		int C = year / 100;
		int y = year % 100;
		int m = month;
		int d = day;
		if (m <= 2) {
			m += 12;
			y--;
		}
		int val = (C / 4) - 2 * C + y + (y / 4) + (26 * (m + 1) / 10) + d - 1;
		return (val % 7 + 7) % 7;
	}
	
	public int getMonth() {
		return month;
	}
}
