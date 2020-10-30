import java.util.*;


public class Array3 {

	public static void main(String[] args) {

		Array3 start = new Array3();
		start.run();

	}

	private void run() {

		Methods m = new Methods();
		
//		int[][] nums1 = { {1,2,1,1,3}, {1,4,2,1,4,1,4}, {1, 4, 2, 1, 4, 4, 4}, {} };
//		for ( int[] nums : nums1 ) {
//			System.out.printf("nums = %s : %d\n", ats(nums), m.maxSpan(nums));
//		}
		
		int[][] nums2 = { {1,3,1,4}, {1,3,1,4,4,3,1}, {3,2,2,4} };
		for ( int[] nums : nums2 ) {
			System.out.printf("nums = %s : %s\n", ats(nums), ats(m.fix34(nums)));
		}
		
	}
	
	private String ats(int[] arr) {
		return Arrays.toString(arr);
	}

}
