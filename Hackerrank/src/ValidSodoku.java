import java.util.*;

public class ValidSodoku{
	public static boolean ValidRow(int arr[][]) {
		for (int i=0; i<9; i++) {
			BitSet bt = new BitSet(9);
			for (int j=0; j<9; j++) {
				if (bt.get(arr[i][j]-1))
					return false;
				else 
					bt.set(arr[i][j]-1);
			}	
		}
		return true;
	}
	public static boolean ValidCol(int arr[][]) {
		for (int j=0; j<9; j++) {
			BitSet bt = new BitSet(9);
			for (int i=0; i<9; i++) {
				if (bt.get(arr[i][j]-1))
					return false;
				else 
					bt.set(arr[i][j]-1);
			}
		}
		return true;
	}
	public static boolean ValidBlock(int arr[][]) {
		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++)
				if (!ValidSubBlock(arr,i*3,j*3)) {
					return false;
				}	
					
		return true;
	}
	public static boolean ValidSubBlock(int arr[][], int m, int n) {
		BitSet bt = new BitSet(9);
		for (int i=m,k=0; k<3; i++,k++) {
			for (int j=n,k1=0; k1<3; j++,k1++){
				if (bt.get(arr[i][j]-1))
					return false;
				else 
					bt.set(arr[i][j]-1);
				}
			System.out.println();
		}
		return true;
	}
	
	public static boolean ValidAll(int arr[][]) {
		return ValidBlock(arr) && ValidRow(arr) && ValidCol(arr);
	}
	public static void main(String[] args) {
		int arr[][] = new int[9][9];
		Scanner scan = new Scanner(System.in);
		for (int i=0; i<9; i++)
			for (int j=0; j<9; j++)
				arr[i][j]=scan.nextInt();
		for (int i=0; i<9; i++) {
			for (int j=0;j<9; j++)
				System.out.print(arr[i][j]+" ");
				System.out.println();
		}
		System.out.print(ValidAll(arr)==true?"YES":"NO");
		scan.close();
	}
}