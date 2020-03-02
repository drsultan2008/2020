import java.util.Scanner;

public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {
        // Complete the functions
    	StringBuffer aa= new StringBuffer(a.toLowerCase());
    	StringBuffer bb= new StringBuffer(b.toLowerCase());
    	for (int i=0; i<aa.length(); i++) {
    		try {
    			bb.deleteCharAt(bb.toString().indexOf(aa.charAt(i)));
    		}catch(Exception e) {
    			return false;
    		}
    	}
    	if (bb.length()==0)
    		return true;
		return false;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
