package CodeForDecorator;

public abstract class ShapeDecorator implements Shape{
	private Shape shape;
	
	public ShapeDecorator(Shape shape) {
		this.shape = shape;
	}
	
	public void draw() {
		shape.draw();
	}
}
