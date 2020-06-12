package TmpProgram;

public class Son extends Father {
	public Son() {
		t = 4;
	}
	
	public static void main(String args[]) {
		Son s1 = new Son();
		System.out.println(s1.t);
	}
}
