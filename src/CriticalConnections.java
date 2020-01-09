/*
 * Given an underected connected graph with n nodes labeled 1..n. A bridge (cut edge) is defined as an edge which, when
 * removed, makes the graph disconnected (or more precisely, increases the number of connected components in the graph).
 * Equivalently, an edge is a bridge if and only if it is not contained in any cycle. The task is to find all bridges in
 * the given graph. Output an empty list if there are no bridges.
 *
 * Input:
 * n, an int representing the total number of nodes.
 * edges, a list of pairs of integers representing the nodes connected by an edge.
 *
 * @author Sanjana Shah
 */
import java.util.*;

public class CriticalConnections {
    public static class Node {
        int key;
        ArrayList<Integer> arr;
        boolean visited;
        public Node(int value) {
            key = value;
            arr = new ArrayList<Integer>();
            visited = false;
        }
    }

    public void visitNodes(Node[] graph, Node n) {
        if(n.visited)
            return;
        n.visited = true;
        for(int i : n.arr)
            visitNodes(graph, graph[i]);
    }

    public int check(Node[] graph) {
        int sum = 0;
        for (int i = 1; i < 10; i++)
            if (graph[i].visited)
                sum++;
        return sum;
    }

    public void printGraph(Node[] graph) {
        for(int i = 1; i < 10; i++) {
            System.out.println(graph[i].key + " " + graph[i].visited + " " + graph[i].arr);
        }
    }

    public static void main(String[] args) {
        CriticalConnections cc = new CriticalConnections();
        Node[] graph = new Node[10];
        for(int i = 1; i < 10; i++) {
            graph[i] = new Node(i);
        }

        int[] edge1 = new int[]{1, 2};
        int[] edge2 = new int[]{1, 3};
        int[] edge3 = new int[]{2, 3};
        int[] edge4 = new int[]{3, 4};
        int[] edge5 = new int[]{3, 6};
        int[] edge6 = new int[]{4, 5};
        int[] edge7 = new int[]{6, 7};
        int[] edge8 = new int[]{6, 9};
        int[] edge9 = new int[]{7, 8};
        int[] edge10 = new int[]{8, 9};
        List<int[]> edges = new ArrayList<int[]>();
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        edges.add(edge6);
        edges.add(edge7);
        edges.add(edge8);
        edges.add(edge9);
        edges.add(edge10);

        for(int[] edge : edges) {
            graph[edge[0]].arr.add(edge[1]);
            graph[edge[1]].arr.add(edge[0]);
        }

        //cc.printGraph(graph);

        for(int[] edge : edges) {
            for(int i = 1; i < 10; i++)
                graph[i].visited = false;

            for(int i = 0; i < graph[edge[0]].arr.size(); i++) //search edge0's array
                if(graph[edge[0]].arr.get(i) == edge[1]) {     //if the array value at index i equals edge1
                    graph[edge[0]].arr.remove(i);              //remove i from array
                    break;
                }
            for(int i = 0; i < graph[edge[1]].arr.size(); i++)
                if(graph[edge[1]].arr.get(i) == edge[0]) {
                    graph[edge[1]].arr.remove(i);
                    break;
                }
            cc.visitNodes(graph, graph[1]);
            int sum = cc.check(graph);
            if(sum != 9)
                System.out.println(edge[0] + ", " + edge[1]);
            graph[edge[0]].arr.add(edge[1]);
            graph[edge[1]].arr.add(edge[0]);
        }

    }
}
