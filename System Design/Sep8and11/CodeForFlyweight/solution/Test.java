package CodeForFlyweight.solution;

public class Test {

	public static void main(String[] args) {
		Tank[] tanks = new Tank[100000];
		
		for(int i = 0; i < 20000; i++) {
			tanks[i] = new Tank();
			tanks[i].type = TankTypeFactory.getTankType("typeA");
		}

		for(int i = 20000; i < 40000; i++) {
			tanks[i] = new Tank();
			tanks[i].type = TankTypeFactory.getTankType("typeB");
		}
		
		for(int i = 40000; i < 100000; i++) {
			tanks[i] = new Tank();
			tanks[i].type = TankTypeFactory.getTankType("typeC");
		}

	}

}
