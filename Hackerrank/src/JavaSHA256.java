import java.util.*;
import java.security.*;

public class JavaSHA256 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.reset();
			md.update(scan.nextLine().getBytes());
			byte[] digest = md.digest();
			for (byte b:digest)
				System.out.printf("%02x",b);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		scan.close();
	}
}
