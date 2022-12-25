package ResponseData;

public class WebIssue {
	int openIssue, closedIssue;
	double meanDays, varDays;
	int differDays;
	
	public void setClosedIssue(int closedIssue) {
		this.closedIssue = closedIssue;
	}
	
	public void setDifferDays(int differDays) {
		this.differDays = differDays;
	}
	
	public void setMeanDays(double meanDays) {
		this.meanDays = meanDays;
	}
	
	public void setVarDays(double varDays) {
		this.varDays = varDays;
	}
	
	public void setOpenIssue(int openIssue) {
		this.openIssue = openIssue;
	}
}
