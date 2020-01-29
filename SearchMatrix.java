/* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Example
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 * @author Sanjana Shah
 */

public class SearchMatrix {

    private boolean unoptimizedSearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int height = matrix.length;
        int width = matrix[0].length;
        int row = 0, col = 0;

        while (row < height && col < width) {
            int temp = matrix[row][col];
            if (target == temp)
                return true;
            else if (target > temp)
                col++;
            else if (col == width - 1)
                row++;
        }
        return false;
    }

    private boolean optimizedSearch(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;

        int row = 0, col = 0;
        for(int i = 1; i < matrix.length; i++) {
            if(target > matrix[i][0]) {
                row = i - 1;
                break;
            }
        }
        for(int i = 0; i < matrix[0].length; i++) {
            System.out.println(matrix[row][i]);
            if(target < matrix[row][i]) {
                col = i - 1;
                break;
            } else if (target == matrix[row][i]) {
                return true;
            }
        }
        return false;
    }

    private boolean bsMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int height = matrix.length;
        int width = matrix[0].length;
        int row = 0, col = 0;
        int midrow = height/2, midcol = width/2;

        while (row < height && col < width) {
            int temp = matrix[midrow][midcol];
            System.out.println(temp);
            if (target == temp)
                return true;
            else if (target > temp) {

                        /* find row and column with bst method */
            }

                col++;
            else if (col == width - 1)
                row++;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix sm = new SearchMatrix();
        int[][] matrix = {{1,   3,  5,  7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(sm.search(matrix, 3));
    }
}
