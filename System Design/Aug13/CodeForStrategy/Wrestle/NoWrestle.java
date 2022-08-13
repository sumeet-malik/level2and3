package CodeForStrategy.Wrestle;

public class NoWrestle implements IWrestlingBehaviour {

	@Override
	public void wrestle() {
		System.out.println("Doesn't wrestle");
	}
	
}
