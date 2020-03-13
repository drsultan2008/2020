	import java.util.Arrays;
	import java.util.Scanner;
	
	public class PickingNumbers {
		private int[] arr;
		private Scanner scan;
		PickingNumbers(){
			scan = new Scanner(System.in);
			int n = scan.nextInt();
			arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i]= scan.nextInt();
			}
			scan.close();
		}
		int pickingNumbers() {
			Arrays.sort(arr);
			int len=arr.length;
			int max=0;
			for(int i=len-1;i>=0;i--){
			    int count=1;
			    for(int j=i-1;j>=0;j--){     

			        if((arr[i]-arr[j])<2){
			            count++;
			        }

			    }
			    max=count>max?count:max;
			}

			    return max;
		}
		public static void main(String args[]) {
			PickingNumbers pn = new PickingNumbers();
			System.out.print(pn.pickingNumbers());
		}
		
	}
