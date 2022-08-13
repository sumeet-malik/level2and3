package CodeForChainOfResponsibility;

public class Test {

	
	public static void main(String[] args) {
		Handler o3 = new RealHandler3(null);
		Handler o2 = new RealHandler2(o3);
		Handler o1 = new RealHandler1(o2);
		
		
		
		Request req = new Request();
		req.state = 10;
		
		o1.handleRequest(req);
	}

}
