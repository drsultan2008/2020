import java.util.Scanner;
import java.util.*;

public class listSimple {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=Integer.parseInt(scan.nextLine());
		List<Integer> l = new ArrayList<Integer>();
		for (int i=0; i<n; i++)
			l.add(scan.nextInt());
		n=scan.nextInt();
		while(n-->0) {
			String q=scan.next();
			if (q.equals("Insert"))
				l.add(scan.nextInt(),scan.nextInt());
			else 
				l.remove(scan.nextInt());
		}
		for (int iter:l)
			System.out.print(iter+" ");
		scan.close();
	}
}
