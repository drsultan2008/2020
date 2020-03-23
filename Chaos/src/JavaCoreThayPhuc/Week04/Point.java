package JavaCoreThayPhuc.Week04;

public class Point {
	double x;
	double y;
	
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public static double distance(Point A, Point B) {
		return Math.sqrt((A.getX()-B.getX())*(A.getX()-B.getX()) + (A.getY()-B.getY())*(A.getY()-B.getY()));
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}
