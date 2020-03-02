import java.io.*;
import java.util.*;

public class JavaSubarray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner scan = new Scanner(System.in);
    	int n=scan.nextInt();
    	int arr[] = new int[n];
    	int count=0;
    	arr[0]=scan.nextInt();
    	if (arr[0]<0) {
    		count++;
    	}
    	for (int i=1; i<n; i++) {
    		arr[i]=arr[i-1]+scan.nextInt();
    		if (arr[i]<0) {
    			count++;
    		}
    		for (int j=0; j<i; j++) {
    			if (arr[i]-arr[j]<0) {
    				count++;
    			}
    		}
    	}
    	System.out.print(count);
    	scan.close();
    }
}

