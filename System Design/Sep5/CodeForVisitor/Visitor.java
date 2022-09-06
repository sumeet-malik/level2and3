package CodeForVisitor;

public abstract class Visitor {
	abstract void visit(Circle cir);
	abstract void visit(Triangle tri);
	abstract void visit(Rectangle rec);
}
