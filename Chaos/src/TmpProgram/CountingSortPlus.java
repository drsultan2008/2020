package TmpProgram;

import java.util.HashMap;
import java.util.Random;

public class CountingSortPlus {
	private int[] arr;
	private Random random;
	
	public CountingSortPlus(int n) {
		this.arr = new int[n];
		random = new Random();
		
		for (int i=0; i<n; i++) {
			arr[i] = random.nextInt(100);
		}
	}
	
	public void sort() {
		for (int i:arr) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i:arr) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		
		double lowerBound = (double)((max-min)/(double)(arr.length-1));
		System.out.println(lowerBound);
		
		HashMap<Integer, Pair> part = new HashMap<>();
		
		for (int i=0; i<arr.length; i++) {
			int index = (int) Math.floor((double)(arr[i]-min)/lowerBound);	
			
			if (!part.containsKey(index)) {
				part.put(index, new Pair(arr[i],arr[i]));
			}
			else {
				if (part.get(index).left > arr[i]) {
					part.get(index).setLeft(arr[i]);
				}
				
				if (part.get(index).right<arr[i]) {
					part.get(index).setRight(arr[i]);
				}
			}
		}
		
		int prev = min;
		
		for (int i:part.keySet()) {
			System.out.print(part.get(i).left+" "+ part.get(i).right+" ");
		}
		System.out.println(min);
		
		for (int i:part.keySet()) {
			if (part.get(i).left!=part.get(i).right) {
				System.out.print(part.get(i).left+" "+ part.get(i).right+" ");
			}
			else {
				System.out.print(part.get(i).left+" ");
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		CountingSortPlus sort = new CountingSortPlus(10);
		
		sort.sort();
		
		
	}
	
	public class Pair{
		private int left;
		private int right;
		
		public Pair(int left,int right) {
			this.left = left;
			this.right = right;
		}
		
		public int getLeft() {
			return left;
		}
		
		public int getRight() {
			return right;
		}
		
		public void setLeft(int left) {
			this.left = left;
		}
		
		public void setRight(int right) {
			this.right = right;
		}
	}
}
