import java.util.Scanner;
import java.util.*;

public class JavaArrayList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList[] arr = new ArrayList[n];
		for (int i=0; i<n; i++) {
			int m = scan.nextInt();
			arr[i] = new ArrayList();
			for (int j=0; j<m; j++)
				arr[i].add(scan.nextInt());
		}
		int q = scan.nextInt();
		for (int i=0; i<q; i++) {
			try {
				System.out.println(arr[scan.nextInt()-1].get(scan.nextInt()-1));
			}catch(Exception e) {
				System.out.println("ERROR!");
			}
		}
		scan.close();
	}
}
