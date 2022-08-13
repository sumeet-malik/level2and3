package CodeForChainOfResponsibility;

public class RealHandler2 extends Handler {
	public RealHandler2(Handler next) {
		super(next);
	}
	
	void handleRequest(Request obj) {
		if(obj.state == 0) {
			System.out.println("All 0's are handled here");
		} else if(next != null) {
			System.out.println("Not a 0 number, hence delegating forward");
			next.handleRequest(obj);
		}
	}
}
