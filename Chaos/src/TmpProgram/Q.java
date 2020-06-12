package TmpProgram;

public class Q extends P {
	void printS2() {
		System.out.println("Q.printS2");
	}
	
	public static void main(String args[]) {
		new Q().printS1S2();
	}
}
