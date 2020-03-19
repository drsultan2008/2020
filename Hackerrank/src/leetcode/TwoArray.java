package leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class TwoArray {
	private int[] nums;
	private int target;
	
	TwoArray(){
		Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			target = scan.nextInt();
			nums = new int[n];
			for (int i=0; i<n; i++) {
				nums[i] = scan.nextInt();
			}
		scan.close();
	}
	
	public int[] twoSum(int nums[], int target) {
		HashMap <Integer,Integer> hashMap = new HashMap<>();
		int[] res = new int[2];
		int index=0;
		
		for (int x:nums) {
			hashMap.put(x, index++);
		}
		
		for (int i=0; i<nums.length; i++) {
			System.out.println(nums[i]);
			if (hashMap.containsKey(target-nums[i])) {
				res[0] = i;
				res[1] = hashMap.get(target-nums[i]);
				if (res[0]!=res[1])
					return res;
			}
		}
		return null;
	}
	
	public static void main(String args[]) {
		TwoArray twoArray = new TwoArray();
//		System.out.println(twoArray.twoSum(twoArray.nums,twoArray.target));
		int[] res = twoArray.twoSum(twoArray.nums, twoArray.target);
		System.out.println(res[0]+ " "+ res[1]);
	}
}
