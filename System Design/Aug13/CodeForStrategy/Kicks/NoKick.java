package CodeForStrategy.Kicks;

public class NoKick implements IKickingBehaviour {

	@Override
	public void kick() {
		System.out.println("Doesn't kick");
	}
	
}
