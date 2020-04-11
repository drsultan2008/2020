
public class ThaoVy01 {

	public static void main(String[] args) {
		float left = -5;
		float right = 5;
		float mid = 0;
		while (Math.abs(left-right)>0.0001 && Math.abs(right-left)>0.0001) {
			System.out.println("Khoảng phân ly nghiệm: [" +left+","+right+"]" );
			mid = (left+right)/2;
			System.out.println("Giá trị phương trình: x^2-x-1: "+mid);
			System.out.println("Mid: "+ mid);
			if (mid*mid-mid-1>0) {
				right = mid;
			}
			else {
				left=mid;
			}
		}
		
		System.out.println("X: "+ mid);
	}

}
