/*
 * Given a matrix with r rows and c columns, find the maximum score of a path starting at [0, 0] and ending at
 * [r-1, c-1]. The score of a path is the minimum value in that path. For example, the score of the path
 * 8 → 4 → 5 → 9 is 4.
 * Don't include the first or final entry. You can only move either down or right at any point in time.
 *
 * @author Sanjana Shah
 */

import java.lang.*;
public class MaxMinPath {
    private int traverse(int[][] mat, int row, int col, int minimum) {
        if(row == mat.length || col == mat[0].length || (row == mat.length - 1 && col == mat[0].length - 1))
            return minimum;
        if(mat[row][col] < minimum)
            minimum = mat[row][col];
        int rightMin = traverse(mat, row + 1, col, minimum);
        int downMin = traverse(mat, row, col + 1, minimum);
        return Integer.max(rightMin, downMin);
    }
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 1}};
        MaxMinPath mmp = new MaxMinPath();
        System.out.println(Integer.max(mmp.traverse(mat, 1, 0, 10000), mmp.traverse(mat, 0, 1, 10000)));
    }
}
