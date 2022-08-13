package CodeForChainOfResponsibility;

public class RealHandler1 extends Handler {
	public RealHandler1(Handler next) {
		super(next);
	}
	
	void handleRequest(Request obj) {
		if(obj.state > 0) {
			System.out.println("All positives are handled here");
		} else if(next != null) {
			System.out.println("Not a positive number, hence delegating forward");
			next.handleRequest(obj);
		}
	}
}
