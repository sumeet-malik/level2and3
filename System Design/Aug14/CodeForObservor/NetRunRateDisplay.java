package CodeForObservor;

public class NetRunRateDisplay implements Observor {

	@Override
	public void update(Subject s) {
		// TODO Auto-generated method stub
		display((CricketData)s);
	}

	public void display(CricketData d) {
		System.out.println("------------NRR------------------");
		double nrr = d.getRuns() * 1.0 / d.getOvers();
		System.out.println("NRR - " + nrr);
	}
}
