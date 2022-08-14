package CodeForDecorator;

public class ColorShapeDecorator extends ShapeDecorator {
	public ColorShapeDecorator(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		System.out.print(" With color ");
		super.draw();
	}
	
	
}
