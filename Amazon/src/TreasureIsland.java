/*
 * You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous
 * reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure
 * out a shortest route to the treasure island.
 *
 * Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from the
 * top-left corner of the map and can move one block up, down, left or right at a time. The treasure island is marked
 * as X in a block of the matrix. X will not be at the top-left corner. Any block with dangerous rocks or reefs will be
 * marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in.
 * The top-left corner is always safe. Output the minimum number of steps to get to the treasure.
 *
 * Example:
 * Input:
 * [['O', 'O', 'O', 'O'],
 *  ['D', 'O', 'D', 'O'],
 *  ['O', 'O', 'O', 'O'],
 *  ['X', 'D', 'D', 'O']]
 * Output: 5
 * Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 */

public class TreasureIsland {
    private int recurseGrid(char[][] map, int i, int j) {
        if (i >= map.length || j >= map[0].length || j < 0 || i < 0) {
            System.out.println("HERE1");
            return 10000;
        }
        System.out.println(i + " " + j + " " + map[i][j]);
        if (map[i][j] == 'X') {
            System.out.println("HERE2");
            return 1;
        } else if (map[i][j] == 'D') {
            System.out.println("HERE3");
            return 10000;
        } else {
            System.out.println("HERE4");
            int one = recurseGrid(map, i, j + 1);
            int two = recurseGrid(map, i + 1, j);
            int three = recurseGrid(map, i, j - 1);
            int four = recurseGrid(map, i - 1, j);
            int minimum = Math.min(Math.min(one, two), Math.min(three, four));
            return minimum + 1;
        }
    }
    public static void main(String[] args) {
        char[][] map = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };

        TreasureIsland ti = new TreasureIsland();
        System.out.println(ti.recurseGrid(map, 0, 0));
    }
}
