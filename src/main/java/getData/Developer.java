package getData;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Developer {
	String name;
	int numberOfCommit;
	
	public String getName() {
		return name;
	}
	
	public int getNumberOfCommit() {
		return numberOfCommit;
	}
	
	@Override
	public String toString(){
		return name + " " + numberOfCommit;
	}
}
