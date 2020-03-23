package JavaCoreThayPhuc.Week04;

public class ShapeDemoApp {

	public static void main(String[] args) {
		
		Shape theShape = new Box(new Point(0,0),new Point(0,1), new Point(1,1), new Point(1,0));
		
		System.out.println(theShape.toString());
		
		System.out.println("Area: "+ theShape.area());
		
		System.out.println("Square: "+ theShape.square());
	}

}
