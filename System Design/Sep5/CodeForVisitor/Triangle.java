package CodeForVisitor;

public class Triangle extends Shape {

	@Override
	void draw() {
		System.out.println("--------------------------------");
		System.out.println("Draw the triangle");
	}
	
	void accept(Visitor vis) {
		vis.visit(this);
	}
}
