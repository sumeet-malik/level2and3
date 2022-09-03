package CodeForProxy;

public class RealWork implements ISomeWork {

	@Override
	public int fun1(int x) {
		return x * x;
		
	}

	@Override
	public int fun2(int x, int y) {
		
		return x + y;
	}
	
}
