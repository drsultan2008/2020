import java.util.Scanner;
import java.util.*;

class JavaExceptionHandling {
    /*
    * Create the method long power(int, int) here.
    */
	public static int power(int m, int n) throws Exception {
		if (m==0 && n==0) {
			throw new Exception("n and p should not be zezo.");
		}
		if (m<0||n<0)
			throw new Exception("n or p should not be nagative.");
		
		if (n==0) return 1;
		int res=power(m,n/2);
		if (n%2==0) {
			return res*res;
		}else {
			return res*res*m;
		}
	}
    
}

public class JavaExceptionHandling {
    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();
            
            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}