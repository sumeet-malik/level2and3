package CodeForVisitor;

public class DrawBoundaryVisitor extends Visitor {

	@Override
	void visit(Circle cir) {
		System.out.println("Draw boundary for circle");
		
	}

	@Override
	void visit(Triangle tri) {
		System.out.println("Draw boundary for triangle");
		
	}

	@Override
	void visit(Rectangle rec) {
		System.out.println("Draw boundary for rectangle");
		
	}
	
}
