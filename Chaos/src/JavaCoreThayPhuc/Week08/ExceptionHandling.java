package JavaCoreThayPhuc.Week08;

import java.util.Scanner;

public class ExceptionHandling {
	private int arg1, arg2;
	private int[] arr;
	
	public ExceptionHandling() {
		arg1 = 0;
		arg2 = 0;
		arr = new int[10];
	}
	
	public ExceptionHandling(int arg1, int arg2, int[] arr) {
		super();
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arr = arr;
	}
	

	public int readInt() {
		int x = 0;
		
		try(Scanner scanner = new Scanner(System.in)){
			System.out.println("Input number: ");
				x = scanner.nextInt();
		}
		catch(Exception e) {
			System.out.print("Not number");
		}
		
		return x;
	}
	
	public void readArr() {
		for (int i=0; i<arr.length; i++) {
			arr[i] = readInt();
		}
	}
	
	public void getIndexArr(int index) {
		try {
			System.out.println("arr["+index+"]"+"="+arr[index]);
		}
		catch(Exception e) {
			System.out.println("Error");
		}
	}

}
