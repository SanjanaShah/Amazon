/* Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author Sanjana Shah
 *
 * Example:
 * [1, 2, 4] , [1, 3, 4] -> [1, 1, 2, 3, 4, 4]
 */

import java.util.*;
public class MergeSorted {
    private List<Integer> merge(List<Integer> one, List<Integer> two) {
        List<Integer> merged = new ArrayList<Integer>();
        int oneIndex = 0, twoIndex = 0;
        while(oneIndex < one.size() && twoIndex < two.size()) {
            if(one.get(oneIndex) < two.get(twoIndex)) {
                merged.add(one.get(oneIndex));
                oneIndex++;
            } else {
                merged.add(two.get(twoIndex));
                twoIndex++;
            }
        }
        if(oneIndex == one.size() && twoIndex != two.size()) {
            while(twoIndex != two.size()) {
                merged.add(two.get(twoIndex));
                twoIndex++;
            }
        } else if(twoIndex == two.size() && oneIndex != one.size()) {
            while(oneIndex != one.size()) {
                merged.add(one.get(oneIndex));
                oneIndex++;
            }
        }
        return merged;
    }
    public static void main(String[] args) {
        MergeSorted ms = new MergeSorted();

        List<Integer> one = new ArrayList<Integer>();
        one.add(1);
        one.add(2);
        one.add(4);
        List<Integer> two = new ArrayList<Integer>();
        two.add(1);
        two.add(3);
        two.add(4);

        System.out.println(ms.merge(one, two));
    }
}
