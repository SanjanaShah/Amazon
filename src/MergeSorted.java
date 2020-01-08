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


/* LeetCode Solution */
//////(Need to do)
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> merged = new ArrayList<Integer>();
        int oneIndex = 0, twoIndex = 0;
        while(l1.next != null && l2.next != null) {
            if(l1.next.val < l2.next.val) {
                merged.add(l1.next.val);
                l1 = l1.next;
            } else {
                merged.add(l2.next.val);
                l2 = l2.next;
            }
        }
        if(l1 == null) {
            while(l2 != null) {
                merged.add(l2.next.val);
                l2 = l2.next;
            }
        } else if(l2 == null) {
            while(l1 != null) {
                merged.add(l1.next.val);
                l1 = l1.next;
            }
        }
        ListNode first = new ListNode();
        first.val = merged.get(0).val;
        ListNode head = new ListNode();
        first.val = merged.get(1).val;
        for(int i = 2; i < merged.size(); i++) {
            ListNode nextPointer = new ListNode();
            nextPointer.val = merged.get(i);
            head.next = val;
            head = head.next;
        }
        return head;
    }
}
 */