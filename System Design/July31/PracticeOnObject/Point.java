package PracticeOnObject;

public class Point {
	private int x;
	private int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.x + ", " + this.y + "]";
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.x + this.y;
	}
	
	@Override
	public boolean equals(Object obj) {
		Point other = (Point)obj;
		
		if(this.x == other.x && this.y == other.y) {
			return true;
		} else {
			return false;
		}
	}
}
