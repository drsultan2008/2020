package TmpProgram;

public class Student {
	public Student(String name, int age) {
		System.out.println(1);
	}
	
	protected int Student() {
		System.out.println(2);
		return 0;
	}
	
	private Student(int age, String name) {
		System.out.println("?");
	}
	
	public Object Student(String name, int age) {
		System.out.println(3);
		return null;
	}
	
	public void Student(String name, byte age) {
		System.out.println(4);
	}
	
	public static void main(String args[]) {
		Student s = new Student("",0);
	}
	
	
}
