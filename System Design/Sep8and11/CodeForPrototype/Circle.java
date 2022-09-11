package CodeForPrototype;

public class Circle implements Shape {
	int x;
	int rad;
	
	public Circle() {
		// makes hit to the db to set x and rad;
	}
	
	private Circle(int x, int rad) {
		this.x = x;
		this.rad = rad;
	}
	
	@Override
	public Shape cloneShape() {
		// TODO Auto-generated method stub
		return new Circle(this.x, this.rad);
	}

}
