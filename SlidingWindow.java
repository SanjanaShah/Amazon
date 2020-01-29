/*
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very
 * right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return
 * the max sliding window.
 * Example:
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 *
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * @author Sanjana Shah
 */

import java.util.*;
public class SlidingWindow {
    private int[] maxWindow(int[] window, int k) {
        int max;
        List<Integer> maxes = new ArrayList<Integer>();
        for(int i = 0; i < window.length - k + 1; i++) {
            max = window[i];
            for(int j = i; j < i + k; j++) {
                if(window[j] > max)
                    max = window[j];
            }
            maxes.add(max);
        }
        int[] maxArray = new int[maxes.size()];
        for(int i = 0; i < maxes.size(); i++)
            maxArray[i] = maxes.get(i);
        return maxArray;
    }
    public static void main(String[] args) {
        int[] window = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        SlidingWindow sw = new SlidingWindow();
        int[] maxArr = sw.maxWindow(window, 3);
        for(int i: maxArr) {
            System.out.print(i + " ");
        }
    }
}
