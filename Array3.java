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
		
//		int[][] nums2 = { {1,3,1,4}, {1,3,1,4,4,3,1}, {3,2,2,4} };
//		for ( int[] nums : nums2 ) {
//			System.out.printf("nums = %s : %s\n", ats(nums), ats(m.fix34(nums)));
//		}

//		int[][] nums3 = { {5,4,9,4,9,5}, {1,4,1,5}, {1,4,1,5,5,4,1} };
//		for ( int[] nums : nums3 ) {
//			System.out.printf("nums = %s : %s\n", ats(nums), ats(m.fix45(nums)));
//		}

//		int[][] nums4 = { {1,1,1,2,1}, {2,1,1,2,1}, {10,10} };
//		for ( int[] nums : nums4 ) {
//			System.out.printf("nums = %s : %b\n", ats(nums), m.canBalance(nums));
//		}

//		int[][][] nums5 = { { {1,2,4,6}, {2,4} }, { {1,2,4,6}, {2,3,4} }, { {1,2,4,4,6}, {2,4} } };
//		for ( int[][] nums : nums5 ) {
//			System.out.printf("outer = %s, inner = %s : %b\n", ats(nums[0]), ats(nums[1]),
//					m.linearIn(nums[0], nums[1]));
//		}

//		int[] nums6 = {3,2,4};
//		for ( int n : nums6 ) {
//			System.out.printf("n = %d : %s\n", n, ats(m.squareUp(n)));
//		}
		
		int[] nums7 = {3,4,2};
		for ( int n : nums7 ) {
			System.out.printf("n = %d : %s\n", n, ats(m.seriesUp(n)));
		}
		
	}
	
	private String ats(int[] arr) {
		return Arrays.toString(arr);
	}

}
