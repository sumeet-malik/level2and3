package CodeForVisitor;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Shape> shapes = new ArrayList<>();
		Circle cir = new Circle();
		Triangle tri = new Triangle();
		Rectangle rec = new Rectangle();
		shapes.add(cir);
		shapes.add(tri);
		shapes.add(rec);
		
		Visitor svgExport = new ExportToSVGVisitor();
		Visitor drawBoundary = new DrawBoundaryVisitor();
		Visitor downloader = new DownloadVisitor();
		
		
		for(Shape sh: shapes) {
			sh.draw();
			sh.accept(drawBoundary);
			sh.accept(svgExport);
			sh.accept(downloader);
		}
	}
	
	void exportToSVG(List<Shape> shapes) {
		
	}

}
