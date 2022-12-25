package ResponseData;

import DataProcess.ReleaseAndCommit;

import java.util.ArrayList;
import java.util.List;

public class WebRelease {
	int totalRelease;
	int[] month = new int[12];
	List<String> months;
	
	public WebRelease(List<ReleaseAndCommit> list) {
		totalRelease = (int) list.stream().filter(x -> x.getType() == 1).count();
		list.forEach(x -> {
			int mo = x.getTime().getMonth() - 1;
			month[mo]++;
		});
		months = new ArrayList<>();
		months.add("Jan");
		months.add("Feb");
		months.add("Mar");
		months.add("Apr");
		months.add("May");
		months.add("Jun");
		months.add("Jul");
		months.add("Aug");
		months.add("Sept");
		months.add("Oct");
		months.add("Nov");
		months.add("Dec");
	}
}
