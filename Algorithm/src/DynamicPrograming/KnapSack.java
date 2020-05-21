package DynamicPrograming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KnapSack {
	private int[] w;
	private int[] v;
	private int[][] dp;
	private int n;
	private int max;
	
	public KnapSack(int n,int max) {
		this.n = n;
		this.max = max;
		w = new int[n+1];
		v = new int[n+1];
		dp = new int[n+1][max+1];
		read();
		process();
	}
	
	public void read() {
		try(BufferedReader br = new BufferedReader(new FileReader("/home/duy/2020/Algorithm/src/DynamicPrograming/data.txt"))){
			for (int i=0; i<n; i++) {
				String arr[] = br.readLine().split(" ");
				v[i+1] = Integer.parseInt(arr[0]);
				w[i+1] = Integer.parseInt(arr[1]);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void show() {
		for (int[] arr:dp) {
			for (int i:arr) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
	}
	
	public int process() {
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=max; j++) {
				if (w[i]>j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]] + v[i]);
				}
			}
		}
		
		return dp[n][max];
	}
	
	public void trace() {
		int i = n;
		int j = max;
		while (i>0 || j>0) {
			System.out.println(i+" v:"+v[i]);
			while (dp[i-1][j] == dp[i][j]) {
				i--;
			}
			
			j = j-w[i];

			if (i<=0 || j<=0) {
				break;
			}
		}
	}
	
	public static void main(String args[]) {
		KnapSack ks = new KnapSack(5,11);
		ks.show();
		System.out.println(ks.process());
		ks.trace();
	}
}
