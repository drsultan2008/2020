import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		for (int i=0; i<n; i++) {
			String s = scan.nextLine();
			String regex = "<(.+)>([^<]+)</\\1>";
			Pattern p = Pattern.compile(regex);
			boolean flag=false;
			Matcher m = p.matcher(s);
			while (m.find()) {
				System.out.println(m.group(2));
				flag=true;
			}
			if (!flag)
				System.out.println("None");
		}
		scan.close();
	}
}
