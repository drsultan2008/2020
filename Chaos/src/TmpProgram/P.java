package TmpProgram;

public class P {
	static void printS1() {
		System.out.println("P.printS1");
	}
	
	void printS2() {
		System.out.println("P.printS2");
	}
	void printS1S2() {
		printS1();
		printS2();
	}
}
