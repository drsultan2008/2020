package JavaCoreThayPhuc.Week06;

public class Cycle extends Vector implements Shape {
	private double r;
	
	Cycle(){
		super();
		r = 0;
	}

	public Cycle(double a, double b, double r) {
		super(a,b);
		this.r = r;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	@Override
	public String toString() {
		return "Cycle [r=" + r + ", getA()=" + getA() + ", getB()=" + getB() + "]";
	}
	
	public double distance(Point x) {
		 return Math.sqrt((x.getX()-a)*(x.getX()-a)+(x.getY()-b)*(x.getY()-b));
	}
	
	public boolean checkPoint(Point x) {
		double tmp = distance(x);
		return tmp<=r;
	}
}
