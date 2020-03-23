package JavaCoreThayPhuc.Week04;

public class Circle implements Shape {
	private Point O;
	private double r;

	public Circle(Point o, double r) {
		super();
		O = o;
		this.r = r;
	}

	@Override
	public double area() {
		return 2*Math.PI*r;
	}

	@Override
	public double square() {
		return Math.PI*r*r;
	}

	@Override
	public void move(Point x) {
		O.setX(O.getX()+x.getX());
		O.setY(O.getY()+x.getY());
		
		System.out.println("Moved");
	}

	@Override
	public void rotate(int rad) {
		System.out.println("Rotated");
	}

	@Override
	public void zoom(int x) {
		r = r*x;
		
		System.out.println("Zoomed");
	}

}
