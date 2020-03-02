import java.util.*;
import java.security.*;

public class JavaMD5{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s=scan.nextLine();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			byte[] digest = md.digest();
			for (byte b: digest)
				System.out.printf("%02x",b);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		scan.close();
	}
}