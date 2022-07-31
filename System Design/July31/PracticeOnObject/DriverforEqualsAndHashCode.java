package PracticeOnObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class DriverforEqualsAndHashCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] points = new Point[10];
		points[0] = new Point(0, 0);
		points[1] = new Point(1, 5);
		points[2] = new Point(2, 3);
		points[3] = new Point(5, 4);
		points[4] = new Point(2, 3);
		points[5] = new Point(1, 5);
		points[6] = new Point(0, 0);
		points[7] = new Point(2, 3);
		points[8] = new Point(5, 4);
		points[9] = new Point(0, 0);
		
		System.out.println(points[0].hashCode());
		System.out.println(points[6].hashCode());
		System.out.println(points[9].hashCode());
		
		System.out.println(points[0].equals(points[6]));
		System.out.println(points[6].equals(points[9]));
		System.out.println(points[0].equals(points[9]));
		
		

		
		
		
		HashMap<Point, Integer> map = new HashMap<>();
		for(Point p: points) {
			if(map.containsKey(p)) {
				map.put(p, map.get(p) + 1);
			} else {
				map.put(p,  1);
			}
		}
		
		System.out.println(map);
		
		String
	}

}
