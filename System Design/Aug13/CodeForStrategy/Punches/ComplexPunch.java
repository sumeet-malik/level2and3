package CodeForStrategy.Punches;

public class ComplexPunch implements IPunchingBehaviour {
	public ComplexPunch next;
	
	@Override
	public void punch() {
		System.out.println("Hits with a jab");
		next.punch();
	}
	
}
