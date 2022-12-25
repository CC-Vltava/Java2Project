package ResponseData;

import DataProcess.ReleaseAndCommit;

import java.util.List;

public class WebRelease {
	int totalRelease;
	int[] month = new int[12];
	public WebRelease(List<ReleaseAndCommit> list){
		totalRelease = (int) list.stream().filter(x -> x.getType() == 1).count();
		list.forEach(x -> {
			int mo = x.getTime().getMonth() - 1;
			month[mo]++;
		});
	}
	
	public int[] getMonth() {
		return month;
	}
	
	public int getRelease() {
		return totalRelease;
	}
}
