/*
 * Minimum Swaps
 * Given a list containing ones and zeroes, return the minimum number of swaps to partition the ones and zeroes on opposite sides of the list.
 * A swap is defined as swapping adjacent elements. Assume you have a function that reverses a given int array.
 * Whether 0's go to left or right side does not matter.
 * 
 * Example:
 * minswaps([1, 0, 1, 0, 1, 0, 1, 1]) would return 6 since we can move the ones to the right side in 6 swaps.
 *
 * @author: Sanjana Shah
 */

public static int minSwaps(int[] a) {
	return Math.min(helper(a), helper(reverse(a))); // call min function on a from forwards and backwards
}

public static int helper(int[] a) {
	int zeroes = 0; // keeps track of number of past zeros
	int answer = 0;
	for(int i = 0; i < a.length; i++) {
		if(a[i] == 0) {
			zeroes += 1; // if value at current index is a zero, add to zeros and skip it
		} else {
			answer += zeroes; // else if value at current index is a one, add the number of zeros to swap it with and move on
		}
	}
	return answer;
}
