package CodeForDecorator;

public class Test {

	public static void main(String[] args) {
		
//		cir.draw();
		
		Shape cir = new Circle();
		ShapeDecorator cirWithBorder = new BorderShapeDecorator(cir);
//		cirWithBorder.draw();
		
//		ColorShapeDecorator cirWithBorderAndColor = new ColorShapeDecorator(cirWithBorder);
//		cirWithBorderAndColor.draw();
		
		ShapeDecorator cirWithDoubleBorder = new BorderShapeDecorator(cirWithBorder);
		cirWithDoubleBorder.draw();
	}

}
