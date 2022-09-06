package CodeForVisitor;

public class Rectangle extends Shape {

	@Override
	void draw() {
		System.out.println("--------------------------------");
		System.out.println("Draw the rectangle");
	}
	
	void accept(Visitor vis) {
		vis.visit(this);
	}
}
