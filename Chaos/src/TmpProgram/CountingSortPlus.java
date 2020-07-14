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
            System.out.println("double: "+ (arr[i]-min)/lowerBound);
			int index = (int)(Math.round((arr[i]-min)/lowerBound));	
	
            System.out.print(index+" ");
        
			if (!part.containsKey(index)) {
				part.put(index, new Pair(arr[i],arr[i]));
			}
			else {
                
                if (part.get(index).getLeft() == arr[i]){
                    part.get(index).setNumLeft();
                }

                if (part.get(index).getRight() == arr[i]){
                    part.get(index).setNumRight();
                }

				if (part.get(index).left>arr[i]) {
					System.out.println("left "+part.get(index).getLeft()+" "+arr[i]);
                    part.get(index).setLeft(arr[i]);
			        System.out.println("key left "+part.get(index).getLeft());
                }
				
				if (part.get(index).right<arr[i]) {
					part.get(index).setRight(arr[i]);
                    System.out.println("right "+part.get(index).getRight()+" "+arr[i]);
				}
			}
		}
		
        System.out.println(); 

		int prev = min;
		
		for (int i:part.keySet()) {
			System.out.print(part.get(i).getLeft()+" "+ part.get(i).getRight()+" ");
		}

		System.out.println();

		for (int i:part.keySet()) {
            if (part.get(i).getLeft() != part.get(i).getRight()){
                for (int j=0; j<part.get(i).getNumLeft(); j++){
                    System.out.print(part.get(i).getLeft()+" ");
                } 

                for (int j=0; j<part.get(i).getNumRight(); j++){
                    System.out.print(part.get(i).getRight()+" ");
                }
            }
            else{
                for (int j=0; j<part.get(i).getNumLeft();j++){
                    System.out.print(part.get(i).getLeft()+" ");
                }
            }
        }

        System.out.println();
	
        for(int i=0; i<arr.length; i++){
            if (part.containsKey(i)){
                System.out.print(part.get(i).getLeft()+" "+ part.get(i).getRight()+" ");
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
        private int numLeft;
        private int numRight;

		public Pair(int left,int right) {
			this.left = left;
			this.right = right;
		    numLeft = numRight = 1;
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

        public void setNumLeft(){
            numLeft++;
        }

        public void setNumRight(){
            numRight++;
        }

        public int getNumLeft(){
            return numLeft;
        } 

        public int getNumRight(){
            return numRight;
        }
	}
}
