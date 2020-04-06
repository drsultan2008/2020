package JavaCoreThayPhuc.Week06;

public class Vector implements Shape {

	protected double a;
	protected double b;
	
	public Vector(){
		a=0;
		b=0;
	}
	
	public Vector(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}
	
	@Override
	public String toString() {
		return "Vector [a=" + a + ", b=" + b + "]";
	}

	@Override
	public double distance(Point x) {
		 return Math.abs(a*x.getX()+(-1)*x.getY()+b)/Math.sqrt((a*a+1));
	}

	@Override
	public boolean checkPoint(Point x) {
		return x.getY()==a*x.getX()+b;
	}

}
