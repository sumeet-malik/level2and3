package CodeForObservor;

public class ScoreCardDisplay implements Observor {

	@Override
	public void update(Subject s) {
		// TODO Auto-generated method stub
		display((CricketData)s);
	}

	public void display(CricketData d) {
		System.out.println("----------ScoreCard------------------");
		System.out.println("Runs - " + d.getRuns());
		System.out.println("Wickets - " + d.getWickets());
		System.out.println("Overs - " + d.getOvers());
	}
}
