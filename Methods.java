
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
		
		int[] fixthreefour = new int[nums.length];
		
		String three = "";
		String four = "";
		
		for ( int i = 0; i < nums.length; i++ ) {
			if ( nums[i] == 3 ) three += i + ",";
			if ( nums[i] == 4 ) four += i + ",";
		}
		
		String[] arr3 = three.split(",");
		String[] arr4 = four.split(",");
		for ( int j = 0; j < arr3.length; j++ ) {
			int arr3j = Integer.parseInt(arr3[j]);
			int arr4j = Integer.parseInt(arr4[j]);
			for ( int k = 0; k < nums.length; k++ ) {
				fixthreefour[k] = nums[k];
			}
		}
		
		return fixthreefour;
	}

}
