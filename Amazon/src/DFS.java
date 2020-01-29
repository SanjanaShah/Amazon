/*
 * Depth First Search Implementation
 */

import java.util.*;
public class DFS {
    public static class Node {
        int key;
        Node[] children;
        public void Node(int value) {
            key = value;
            children = new Node[];
        }
    }
    void printDFS(Node node)
    {
        if (node == null)
            return;
        for(Node child : node.children) {
            printDFS(child);
        }
        System.out.print(node.key + " ");
    }

    public static void main(String[] args) {
        DFS dfs = new DFS;
        Node node1 = new Node(7);
        Node node2 = new Node(5);
        Node node3 = new Node(8);
        Node node4 = new Node(2);
        Node node5 = new Node(3);
        Node node6 = new Node(9);
        Node node7 = new Node(1);
        Node node9 = new Node(4);

        node1.children =
        dfs.printDFS(node1);
    }
}
