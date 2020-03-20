package AlgoThayDung;

import java.util.Scanner;

public class QuickSelect {
	int arr[];
	int k;
	int n;
	QuickSelect(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n];
		k = scan.nextInt();
		for (int i=0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
	}
	
	int quickSelect(int p, int r, int k) {
		if (p==r) {
			return arr[p];
		}
		else {
			int q = partition(p,r);
			int x = arr[q];
			int xRank = q-p+1;
			if (k==xRank) {
				return x;
			}
			else if(k<xRank){
				return quickSelect(p,q-1,k); // select from left subarray
			}
			else {
				return quickSelect(q+1,r,k-xRank); // select from right 
			}
		}
	}
	
	int partition(int low, int high) {
		int pivot = arr[high];
		int i = low -1;
		
		for (int j=low; j<high; j++) {
			if (arr[j] < pivot) {
				i++;
				int tmp = arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
			}
		}
		int tmp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = tmp;
		return i+1;
	}
	
	public static void main(String args[]) {
		QuickSelect qS = new QuickSelect();
		System.out.println(qS.quickSelect(0, qS.n-1, qS.k));
	}
	
}
