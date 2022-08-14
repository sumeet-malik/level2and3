package CodeForDecorator;

public class BorderShapeDecorator extends ShapeDecorator {
	public BorderShapeDecorator(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		System.out.print(" With border ");
		super.draw();
	}
	
	
}
