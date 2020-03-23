package JavaCoreThayPhuc.Week04;

public class Box implements Shape {
	private Point A,B,C,D;
	
	public Box(Point a, Point b, Point c, Point d) {
		super();
		A = a;
		B = b;
		C = c;
		D = d;
	}

	@Override
	public double area() {
		double a = Point.distance(A, B);
		double b = Point.distance(B, C);
		double c = Point.distance(C, D);
		double d = Point.distance(D, A);
		
		return a*b;
	}

	@Override
	public double square() {
		double a = Point.distance(A, B);
		double b = Point.distance(B, C);
		double c = Point.distance(C, D);
		double d = Point.distance(D, A);
		
		return a+b+c+d;
	}

	@Override
	public void move(Point x) {
		A.setX(A.getX()+x.getX());
		A.setY(A.getY()+x.getY());
		
		B.setX(B.getX()+x.getX());
		B.setY(B.getY()+x.getY());
		
		C.setX(C.getX()+x.getX());
		C.setY(C.getY()+x.getY());
		
		D.setX(D.getX()+x.getX());
		D.setY(D.getY()+x.getY());
		
		System.out.println("Moved!");
	}

	@Override
	public void rotate(int rad) {
		Point I = new Point((A.getX()+C.getX())/2, (A.getY()+C.getY())/2);
		
		double ax = (A.getX()-I.getX())*Math.cos(rad) - (A.getY()-I.getY())*Math.sin(rad) + I.getX();
		double ay = (A.getX()-I.getX())*Math.sin(rad) - (A.getY()-I.getY())*Math.cos(rad) + I.getY();
		A.setX(ax);
		A.setY(ay);
		
		double bx = (B.getX()-I.getX())*Math.cos(rad) - (B.getY()-I.getY())*Math.sin(rad) + I.getX();
		double by = (B.getX()-I.getX())*Math.sin(rad) - (B.getY()-I.getY())*Math.cos(rad) + I.getY();
		B.setX(bx);
		B.setY(by);
		
		double cx = (C.getX()-I.getX())*Math.cos(rad) - (C.getY()-I.getY())*Math.sin(rad) + I.getX();
		double cy = (C.getX()-I.getX())*Math.sin(rad) - (C.getY()-I.getY())*Math.cos(rad) + I.getY();
		C.setX(cx);
		C.setY(cy);
		
		double dx = (D.getX()-I.getX())*Math.cos(rad) - (D.getY()-I.getY())*Math.sin(rad) + I.getX();
		double dy = (D.getX()-I.getX())*Math.sin(rad) - (D.getY()-I.getY())*Math.cos(rad) + I.getY();
		D.setX(dx);
		D.setY(dy);
		
		System.out.println("Rotated!");
	}

	@Override
	public void zoom(int x) {
		A.setX(A.getX()*x);
		A.setY(A.getY()*x);
		
		B.setX(B.getX()*x);
		B.setY(B.getY()*x);
		
		C.setX(C.getX()*x);
		C.setY(C.getY()*x);
		
		D.setX(D.getX()*x);
		D.setY(D.getY()*x);
	}

	@Override
	public String toString() {
		return "Box [A=" + A + ", B=" + B + ", C=" + C + ", D=" + D + "]";
	}
	
	
	
	
}