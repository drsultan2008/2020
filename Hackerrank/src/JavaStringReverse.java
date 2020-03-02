
import java.io.*;
import java.util.*;
public class JavaStringReverse {
	public static boolean isPalind(StringBuffer s) {
		return s.toString().equals(s.reverse().toString());
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuffer s = new StringBuffer(scan.next());
		if (isPalind(s))
			System.out.print("Yes");
		else System.out.print("No");
		scan.close();
	}
}
