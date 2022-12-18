package getData;

public class Time {
	boolean isNull;
	Integer year, month, day, hour, minute, second;
	String time;
	Time(String s){
		if(s == null){
			isNull = true;
		}
		else{
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
	
	@Override
	public String toString(){
		if(isNull)
			return "null";
//		return year.toString() + "-" + month + "-" + day + "T" + hour + ":" + minute + ":" + second + "Z";
		return time;
	}
	
}
