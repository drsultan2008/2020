import java.util.*;
import java.math.*;

public class JavaPrimalityTestBigInteger {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BigInteger f = new BigInteger(scan.nextLine());
		System.out.print(f);
		System.out.print(f.isProbablePrime(1)==true?"prime":"not prime");
		scan.close();
	}
}
