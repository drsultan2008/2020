import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExceptionHandlingTryCatch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int x = scan.nextInt();
			int y = scan.nextInt();
			System.out.print(x/y);
		}catch(InputMismatchException e) {
			System.out.print(e.getClass().getName());
		}catch(Exception e) {
			System.out.print(e);
		}
		scan.close();
	}
}
