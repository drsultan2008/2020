import java.util.*;
import java.math.*;

public class JavaBigdecimal {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String arr[] = new String[n];
		for (int i=0; i<n; i++)
			arr[i]=scan.nextLine();
		Arrays.sort(arr, 0, n, (a, b) -> new BigDecimal(b).compareTo(new BigDecimal(a)));
		for (String it:arr)
			System.out.println(it);
		scan.close();
	}
}
