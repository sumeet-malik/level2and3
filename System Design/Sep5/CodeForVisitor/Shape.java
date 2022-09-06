package CodeForVisitor;

public abstract class Shape {
	abstract void draw();
	abstract void accept(Visitor vis);
}
