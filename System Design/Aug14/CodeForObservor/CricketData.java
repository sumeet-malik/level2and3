package CodeForObservor;

public class CricketData extends Subject {
	private int runs;
	
	public int getRuns() {
		return runs;
	}
	
	private void setRuns(int runs) {
		this.runs = runs;
	}
	
	private int overs;
	
	public int getOvers() {
		return this.overs;
	}
	
	private void setOvers(int overs) {
		this.overs = overs;
	}
	
	private int wickets;
	
	public int getWickets() {
		return this.wickets;
	}
	
	private void setWickets(int wickets) {
		this.wickets = wickets;
	}
	
	public void setData(int runs, int wickets, int overs) {
		this.setOvers(overs);
		this.setRuns(runs);
		this.setWickets(wickets);
		super.notifyObservors();
	}
}
