import java.math.BigInteger;
import java.util.*;

public class JavaBigInterger {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BigInteger a = new BigInteger(scan.nextLine());
		BigInteger b = new BigInteger(scan.nextLine());
		BigInteger f=a.add(b);
		System.out.println(f);
		f=a.subtract(b);
		System.out.println(f=a.multiply(b));
		scan.close();
	}
}
