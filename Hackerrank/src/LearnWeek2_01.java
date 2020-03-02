import java.util.*;
import java.math.*;
public class LearnWeek2_01 {
	public static boolean isPrime(int n) {
		if (n<=1) return false;
		if (n<=3) return true;
		if (n%2==0||n%3==0) return false;
		for (int i=5; i*i<=6; i+=6)
			if (n%i==0||n%(i+2)==0) return false;
		return true;
	}
	public static int sumPrime(int n) {
		BitSet bt = new BitSet(n+1);
		int res=0;
		for (int i=2; i*i<=n; i++) {
			if (!bt.get(i)) {
				int j=i*i;
				while (j<n) {
					bt.set(j);
					j*=i;
				}
			}
		}
		for (int i=2; i<n; i++)
			if (bt.get(i))
				res+=i;
		return res;
	}
	public static double res1(int arr[]) {
		double res1=0;
		for (int i=1; i<=arr.length; i++)
			res1+=(i%2==0?-1:1)*(i*i)/arr[i];
		return res1;
	}
	public static int max(int arr[]) {
		int m=1;
		for (int x:arr)
			m=(x%3==0)?((m<x)?x:m):m;
		return m;
	}
	public static void printMatrix(int arr[][]) {
		for (int x[]:arr) {
			for (int y:x)
				System.out.println(y+" ");
			System.out.println();
		}
		return;
	}
	public static void main(String[] args) {
		int n=20;
		int res=0;
		for (int i=0; i<n; i++)
			res+=isPrime(i)?i:0;
		System.out.println(res);
		System.out.print(sumPrime(n));
	}
}	