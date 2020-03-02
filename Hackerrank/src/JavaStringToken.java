import java.io.*;
import java.util.*;

public class JavaStringToken {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        scan.close();
        
        s = s.trim();
        String arr[] = s.split("[ !,?._'@]+");
        System.out.println(arr.length);
        for(String i:arr){
            System.out.println(i);
         }
        }
}