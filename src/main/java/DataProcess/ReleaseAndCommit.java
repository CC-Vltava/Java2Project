package DataProcess;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReleaseAndCommit {
	int type; // 1 is release, 0 is commit
	Time time;
	
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
}
