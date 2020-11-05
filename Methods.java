
public class Methods {

	public int maxSpan(int[] nums) {
		
//		Consider the leftmost and righmost appearances of some value in an array. We'll say that 
//		the "span" is the number of elements between the two inclusive. A single value has a span 
//		of 1. Returns the largest span found in the given array. (Efficiency is not a priority.)
//
//		maxSpan([1, 2, 1, 1, 3]) → 4
//		maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
//		maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
		
		if ( nums.length == 0 ) return 0;
		int maxspan = 0;
		String numbers = "";
		for ( int i = 0; i < nums.length; i++ ) {
			if ( numbers.indexOf(nums[i]) < 0) {
				numbers += Integer.toString(nums[i]) + ",";
			}
		}
		
		String[] numsarr = numbers.split(",");
		for ( int i = 0; i < numsarr.length; i++ ) {
			int first = Integer.MIN_VALUE;
			int last = Integer.MIN_VALUE;
			int numsarri = Integer.parseInt(numsarr[i]);
			for ( int j = 0; j < nums.length; j++ ) {
				if ( nums[j] == numsarri && first == Integer.MIN_VALUE ) first = j;
				else if ( nums[j] == numsarri && first != Integer.MIN_VALUE ) last = j;
			}
			if ( last != Integer.MIN_VALUE && first != Integer.MIN_VALUE ) {
				int count = last - first;
				maxspan = Math.max(maxspan,  count);				
			}
		}
		return maxspan + 1;
	}

	public int[] fix34(int[] nums) {
		
//		Return an array that contains exactly the same numbers as the given array, but rearranged so 
//		that every 3 is immediately followed by a 4. Do not move the 3's, but every other number may 
//		move. The array contains the same number of 3's and 4's, every 3 has a number after it that is 
//		not a 3, and a 3 appears in the array before any 4.
//
//		fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
//		fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
//		fix34([3, 2, 2, 4]) → [3, 4, 2, 2]
		
		for ( int i = 0; i < nums.length; i++ ){
			if ( nums[i] == 3 ){
				for ( int j = 0; j < nums.length; j++ ) {
					if ( nums[j] == 4 && nums[j-1] != 3 ){
						int temp = nums[i+1];
						nums[i+1] = nums[j];
						nums[j] = temp;
					}
				}
			}
		}
		return nums;
	}

	public int[] fix45(int[] nums) {

//		(This is a slightly harder version of the fix34 problem.) Return an array that contains exactly the same numbers
//		as the given array, but rearranged so that every 4 is immediately followed by a 5. Do not move the 4's, but every
//		other number may move. The array contains the same number of 4's and 5's, and every 4 has a number after it that
//		is not a 4. In this version, 5's may appear anywhere in the original array.
//
//		fix45([5, 4, 9, 4, 9, 5]) → [9, 4, 5, 4, 5, 9]
//		fix45([1, 4, 1, 5]) → [1, 4, 5, 1]
//		fix45([1, 4, 1, 5, 5, 4, 1]) → [1, 4, 5, 1, 1, 4, 5]

		for ( int i = 0; i < nums.length; i++ ) {
			if ( nums[i] == 4 ) {
				for ( int j = 0; j < nums.length; j++ ) {
					if ( nums[j] == 5 && j == 0 ) {
						int temp = nums[i+1];
						nums[i+1] = nums[j];
						nums[j] = temp;
						break;
					}
					else if ( nums[j] == 5 && nums[j-1] != 4 ) {
						int temp = nums[i+1];
						nums[i+1] = nums[j];
						nums[j] = temp;
						break;
					}
				}
			}
		}

		return nums;
	}

	public boolean canBalance(int[] nums) {

//		Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one
//		side is equal to the sum of the numbers on the other side.
//
//		canBalance([1, 1, 1, 2, 1]) → true
//		canBalance([2, 1, 1, 2, 1]) → false
//		canBalance([10, 10]) → true

		if ( nums.length < 2 ) return false;
		if ( nums.length == 2 ) return nums[0] == nums[1];

		for ( int j = 1; j < nums.length; j++ ) {
			int forward = 0;
			int backward = 0;

			for ( int k = 0; k < j; k++ ) forward += nums[k];
			for ( int l = nums.length - 1; l >= j; l-- ) backward += nums[l];

			if ( backward == forward ) return true;
		}

		return false;
	}

	public boolean linearIn(int[] outer, int[] inner) {

//		Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner
//		appear in outer. The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact
//		that both arrays are already in sorted order.
//
//		linearIn([1, 2, 4, 6], [2, 4]) → true
//		linearIn([1, 2, 4, 6], [2, 3, 4]) → false
//		linearIn([1, 2, 4, 4, 6], [2, 4]) → true

		int innerLength = inner.length;
		int tracker = 0;
		for ( int i = 0; i < outer.length; i++ ) {
			if ( tracker > innerLength - 1 ) break;
			else if ( outer[i] == inner[tracker] ) {
//				System.out.printf("outer[i] = %d, tracker = %d, inner[tracker] = %d\n", outer[i], tracker, inner[tracker]);
				tracker++;
			}
		}

		return tracker == innerLength;
	}

	public int[] squareUp(int n) {

//		Given n>=0, create an array length n*n with the following pattern, shown here for n=3 : {0, 0, 1,    0, 2, 1,
//		3, 2, 1} (spaces added to show the 3 groups).
//
//		squareUp(3) → [0, 0, 1, 0, 2, 1, 3, 2, 1]
//		squareUp(2) → [0, 1, 2, 1]
//		squareUp(4) → [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]

		int[] squareup = new int[n*n];
		for ( int i = 0; i < n; i++ ){
			int count = 1;
			for ( int j = n-1; j >= 0; j-- ) {
				if ( count > i + 1 ) break;
				else {
					squareup[(i*n)+j] = count;
					count++;
				}
				
			}

		}

		return squareup;
	}

	public int[] seriesUp(int n) {
		
//		Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n} (spaces added to show 
//		the grouping). Note that the length of the array will be 1 + 2 + 3 ... + n, which is known to sum to exactly 
//		n*(n + 1)/2.
//
//		seriesUp(3) → [1, 1, 2, 1, 2, 3]
//		seriesUp(4) → [1, 1, 2, 1, 2, 3, 1, 2, 3, 4]
//		seriesUp(2) → [1, 1, 2]
		
		int[] seriesup = new int[n*(n+1)/2];
		int counter = 0;
		
		for ( int i = 1; i <= n; i++ ) {
			for ( int j = 1; j < i+1; j++ ) {
				seriesup[counter] = j;
				counter++;
			}
		}
		
		return seriesup;
	}
}
