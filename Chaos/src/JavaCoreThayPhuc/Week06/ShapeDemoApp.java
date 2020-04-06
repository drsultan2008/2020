package JavaCoreThayPhuc.Week06;

import java.util.ArrayList;
import java.util.List;

public class ShapeDemoApp {

	public static void main(String[] args) {
		Shape theShape = new Vector(1,1);
		System.out.println(theShape);
		Point pointO = new Point(0,0);
		
		System.out.println("Distance to O: "+ theShape.distance(pointO));
		System.out.println("Distance to O(o,o: "+ theShape.distance(new Point(1,2)));
		System.out.println("Point belong Vector ? : "+ theShape.checkPoint(new Point(1,2)));
		
		System.out.println("Create a list:");
		List<Shape> listShape = new ArrayList<>();
		listShape.add(new Vector(1,1));
		listShape.add(new Vector(1,2));
		listShape.add(new Vector(1,3));
		
		System.out.println("Distance to O(0,0) of list:");
		for (Shape iter:listShape) {
			System.out.println(iter+": "+iter.distance(pointO));
		}
		
		Point pointA = new Point(1,2);
		int count =0;
		for (Shape iter:listShape) {
			if (iter.checkPoint(pointA)) {
				count++;
			}
		}
		System.out.println("Number Shape belong A(x,y): "+count);
		
		int res =0;
		for (Shape iter:listShape) {
			res+=iter.distance(pointO);
		}
		System.out.println("Result all Shape to O: "+ res);
		
		theShape = new Cycle(0,0,3);
		System.out.println("Distance to 0: " + theShape.distance(pointO));
		
		System.out.println("Point is belong Cycle: "+ theShape.checkPoint(new Point(2,2)));
		
		System.out.println("Create a list include Vector & Cycle:");
		List<Shape> listShape2 = new ArrayList<>();
		listShape2.add(new Vector(1,1));
		listShape2.add(new Cycle(1,1,1));
		listShape2.add(new Cycle(0,0,3));
		
		System.out.println("Display listShape2: ");
		for (Shape iter:listShape2) {
			System.out.println(iter);
		}
		
		count = 0;
		for (Shape iter:listShape2) {
			if(iter.checkPoint(pointA)) {
				count++;
			}
		}
		System.out.println("Number that PointA belong vector,cycle: "+count);
		
		res= 0;
		for (Shape iter:listShape2) {
			res+=iter.distance(pointO);
		}
		System.out.println("Sum distance form O to Shape: "+res);
	}

}
