package CodeForVisitor;

public class DownloadVisitor extends Visitor {

	@Override
	void visit(Circle cir) {
		System.out.println("Download the circle");
		
	}

	@Override
	void visit(Triangle tri) {
		System.out.println("Download the triangle");
		
	}

	@Override
	void visit(Rectangle rec) {
		System.out.println("Download the rectangle");
		
	}
	
}
