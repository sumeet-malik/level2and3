package CodeForVisitor;

public class ExportToSVGVisitor extends Visitor {

	@Override
	void visit(Circle cir) {
		System.out.println("Export the circle to SVG");
		
	}

	@Override
	void visit(Triangle tri) {
		System.out.println("Export the triangle to SVG");
		
	}

	@Override
	void visit(Rectangle rec) {
		System.out.println("Export the rectangle to SVG");
		
	}
	
}
