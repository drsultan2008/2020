package JavaCoreThayPhuc.Week09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileIO {
	
	
	public static void main(String[] args) {
		int [][] nums = new int[0][0];
		
		nums = read(nums);
		
		displayNums(nums);
		
		todo(nums);
		
	}

	private static void todo(int[][] nums) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("/home/duy/2020/Chaos/src/JavaCoreThayPhuc/Week09/output.txt"))){
			int max = Integer.MIN_VALUE;
			int count =  0;
			
			for (int arr[]:nums) {
				for (int i:arr) {
					max = max < i ? i : max;
					count += i > 0 ? 1 : 0;
				}
			}
			
			bw.write("Max nums: " + max);
			bw.newLine();
			bw.write("Counts > 0 : "+ count);
			
		}catch(IOException e) {
			System.out.println(e);
		}
	}

	private static void displayNums(int[][] nums) {
		for (int [] arr: nums) {
			for (int i:arr) {
				System.out.print(i+ " ");
			}
			System.out.println();
		}
	}

	private static int[][] read(int[][] nums) {
		try (BufferedReader br = new BufferedReader(new FileReader("/home/duy/2020/Chaos/src/JavaCoreThayPhuc/Week09/input.txt"))){
			String line = br.readLine();
			String [] tiny = line.split(" ");
			
			int m = Integer.parseInt(tiny[0]);
			int n = Integer.parseInt(tiny[1]);
			
			nums = new int[Integer.parseInt(tiny[0])][Integer.parseInt(tiny[1])];
			
			for (int i=0; i< m ; i++) {
				line = br.readLine();
				tiny = line.split(" ");
				for (int j=0; j<n; j++) {
					nums[i][j] = Integer.parseInt(tiny[j]);
				}
			}
			
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found"+ e);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		return nums;
	}
	
}
