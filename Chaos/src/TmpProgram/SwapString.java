package TmpProgram;

import java.util.concurrent.atomic.AtomicReference;

public class SwapString {
	
	public void swapString(StringBuilder a, StringBuilder b) {
		a.append(b);
	}
	
	public static void main(String args[]) {
		StringBuilder a = new StringBuilder("Hello");
		StringBuilder b = new StringBuilder("Word");
		
		System.out.println(a+""+b);
		
		SwapString swap = new SwapString();
		swap.swapString(a, b);
		
		System.out.println(a+""+b);
	}
}
