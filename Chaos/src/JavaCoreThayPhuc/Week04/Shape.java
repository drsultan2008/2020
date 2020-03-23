package JavaCoreThayPhuc.Week04;

public interface Shape {
	public double area();
	public double square();
	public void move(Point x);
	public void rotate(int rad);
	public void zoom(int x); 
	public String toString();
}
