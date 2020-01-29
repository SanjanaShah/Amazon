/*
 * Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target.
 * Return the number of pairs.
 *
 * Test Cases:
 * {1, 2, 3, 4, 4, 5, 6, 7}, target = 7 -> 3 (1, 6; 2, 5; 3, 4)
 * {1, 1, 2, 45, 46, 46}, target = 47 -> 2 (1, 46; 2, 45)
 * {1, 1}, target = 2 -> 1 (1, 1)
 * {1, 5, 1, 5}, target = 6 -> 1 (1, 5)
 *
 * @author Sanjana Shah
 */
public class TwoSum {
    private int pairs(int[] arr, int target) {
        int num = 0;
        boolean appeared;
        for(int i = 0; i < arr.length; i++) {
            appeared = false;
            for(int k = 0; k < i; k++) {
                if(arr[k] == arr[i] || arr[k] + arr[i] == target) {
                    appeared = true;
                    break;
                }
            }
            for(int j = i + 1; !appeared && j < arr.length; j++) {
                if(arr[i] + arr[j] == target) {
                    num++;
                    break;
                }
            }
        }
        return num;
    }

    public static void main(String [] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 7};
        int[] test1 = {1, 1, 2, 45, 46, 46};
        int[] test2 = {1, 1};
        int[] test3 = {1, 5, 1, 5};

        TwoSum ts = new TwoSum();
        System.out.println(ts.pairs(arr, 7));
        System.out.println(ts.pairs(test1, 47));
        System.out.println(ts.pairs(test2, 2));
        System.out.println(ts.pairs(test3, 6));
    }
}
