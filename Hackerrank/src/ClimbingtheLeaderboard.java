import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

import javafx.util.Pair;

public class ClimbingtheLeaderboard {
	
	private int[] scores, alice;
	private int m,n;
	private Scanner scan;
	
	ClimbingtheLeaderboard(){
		scan = new Scanner(System.in);
		m = scan.nextInt();
		scores = new int[m];
		for (int i=0; i<m; i++) {
			scores[i] = scan.nextInt();
		}
		
		n = scan.nextInt();
		alice = new int[n];
	
		for (int i=0; i<n; i++) {
			alice[i] = scan.nextInt();
		}
		
		scan.close();
	}
	void climbingLeaderboard() {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		for (int it:scores) {
			treeSet.add(it);
		}
		HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		int count =1;
		for (int it:treeSet){
			count++;
		}
	
		int count2=count;
		for (int it:treeSet) {
			hashMap.put(it,count--);
			System.out.print(it+":"+count+" ");
		}
//		System.out.print(count2);
		
		for (int it:alice) {
			if (hashMap.containsKey(treeSet.higher(it))) {
				System.out.println(hashMap.get(treeSet.higher(it)));
			}
			else if (treeSet.higher(it)==null) {
				System.out.println(1);
			}
			else if (treeSet.lower(it)==null) {
				System.out.println(count2);
			} 
		}
	}
	
	public static void main(String args[]) {
		ClimbingtheLeaderboard temp = new ClimbingtheLeaderboard();
		temp.climbingLeaderboard();
	}
}
