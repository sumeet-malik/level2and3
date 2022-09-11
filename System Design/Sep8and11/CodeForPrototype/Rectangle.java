package CodeForPrototype;

import java.util.ArrayList;

public class Rectangle implements Shape {
	int tlx;
	int tly;
	int width;
	int height;
	ArrayList<Integer> list = new ArrayList<>();
	
	public Rectangle() {
		// makes hit to the db to create
		list.add(10);
		list.add(20);
		list.add(30);
		
	}
	
	private Rectangle(int tlx, int tly, int width, int height, ArrayList<Integer> list) {
		this.tlx = tlx;
		this.tly = tly;
		this.width = width;
		this.height = height;
		this.list = new ArrayList<>();
		for(int val: list) {
			this.list.add(val);
		}
	}
	
	@Override
	public Shape cloneShape() {
		// TODO Auto-generated method stub
		return new Rectangle(this.tlx, this.tly, this.width, this.height, this.list);
	}

}
