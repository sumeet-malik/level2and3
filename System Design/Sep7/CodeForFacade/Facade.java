package CodeForFacade;

public class Facade {
	static void work() {
		A o1 = new A();
		B o2 = new B();
		C o3 = new C();
		
		// work
		int x = o1.fun1();
		int y = o1.fun2(x);
		String a1 = o2.fun3();
		String a2 = o2.fun4();
		o3.fun5(y, a1);
		o3.fun6(a2);
	}
}
