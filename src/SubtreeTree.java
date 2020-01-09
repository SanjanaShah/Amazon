/*
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with
 * a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 *
 *
 * Example 1:
 * Given tree s:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 *
 * Example 2:
 * Given tree s:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 */

import java.util.*;

public class SubtreeTree {
    private static class Node {
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    private static ArrayList<Integer> createArr(Node node, ArrayList<Integer> arr) {
        if(node == null)
            return arr;
        arr = createArr(node.left, arr);
        arr.add(node.key);
        arr = createArr(node.right, arr);
        return arr;
    }

    public static void main(String[] args) {
        SubtreeTree st = new SubtreeTree();

        // create s
        Node s = new Node(3);
        s.right = new Node(5);
        Node sl = new Node(4);
        sl.left = new Node(1);
        sl.right = new Node(2);
        s.left = sl;

        // create t
        Node t = new Node(4);
        t.left = new Node(1);
        t.right = new Node(2);

        //create v
        Node v = new Node(4);
        v.left = new Node(1);
        Node vr = new Node(2);
        vr.left = new Node(0);
        v.right = vr;

        ArrayList<Integer> sArr = new ArrayList<Integer>();
        ArrayList<Integer> tArr = new ArrayList<Integer>();
        ArrayList<Integer> vArr = new ArrayList<Integer>();

        sArr = createArr(s, sArr);
        tArr = createArr(t, tArr);
        vArr = createArr(v, vArr);

        //System.out.println(sArr);
        //System.out.println(tArr);
        //System.out.println(vArr);

        System.out.println(sArr.containsAll(tArr));
        System.out.println(sArr.containsAll(vArr));
    }
}
