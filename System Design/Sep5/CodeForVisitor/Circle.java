package CodeForVisitor;

public class Circle extends Shape {

	@Override
	void draw() {
		System.out.println("--------------------------------");
		System.out.println("Draw the circle");
	}
	
	void accept(Visitor vis) {
		vis.visit(this);
	}
	
}
