package JavaCoreThayPhuc.Week06;

public class ShapeDemoApp {

	public static void main(String[] args) {
		Shape theShape = new Vector(1,1);
		System.out.println(theShape);
		Point pointO = new Point(0,0);
		System.out.println("Distance to O: "+ theShape.distance(pointO));
		
	}

}
