package JavaCoreThayPhuc.Week04;

public class Triangle implements Shape {
	Point A,B,C;
	
	public Triangle(Point a, Point b, Point c) {
		super();
		A = a;
		B = b;
		C = c;
	}

	@Override
	public double area() {
		double a = Point.distance(A, B);
		double b = Point.distance(B, C);
		double c = Point.distance(C, A);
		
		double p = (a+b+c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}

	@Override
	public double square() {
		double a = Point.distance(A, B);
		double b = Point.distance(B, C);
		double c = Point.distance(C, A);
		
		return a+b+c;
	}

	@Override
	public void move(Point x) {
		A.setX(A.getX()+x.getX());
		A.setY(A.getY()+x.getY());
		
		B.setX(B.getX()+x.getX());
		B.setY(B.getY()+x.getY());
		
		C.setX(C.getX()+x.getX());
		C.setY(C.getY()+x.getY());
		
		System.out.println("Moved");
	}

	@Override
	public void rotate(int rad) {
		Point I = new Point((A.getX()+B.getX()+C.getX())/2, (A.getY()+C.getY()+B.getY())/3);
		
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

	}

	@Override
	public void zoom(int x) {
		A.setX(A.getX()*x);
		A.setY(A.getY()*x);
		
		B.setX(B.getX()*x);
		B.setY(B.getY()*x);
		
		C.setX(C.getX()*x);
		C.setY(C.getY()*x);

	}

}
