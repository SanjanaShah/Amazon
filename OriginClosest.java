/*
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * Example 1:
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 * Note:
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * @author Sanjana Shah
 */
import java.util.*;
public class OriginClosest {
    private List<int[]> distance(List<int[]> arr) {
        List<int[]> result = new ArrayList<int[]>();
        if(arr == null)
            return result;
        double minDistance = 10000;

        for(int[] a : arr) {
            double distance = calcDistance(a[0], a[1]);
            if(distance < minDistance) {
                minDistance = distance;
                result = new ArrayList<int[]>();
                result.add(a);
            } else if(distance == minDistance) {
                result.add(a);
            }
        }
        return result;
    }
    private double calcDistance(int a, int b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
    public static void main(String[] args) {
        OriginClosest oc = new OriginClosest();
        List<int[]> arr = new ArrayList<int[]>();
        int[] row1 = new int[]{1, 3};
        int[] row2 = new int[]{-2, 2};
        arr.add(row1);
        arr.add(row2);
        List<int[]> result = oc.distance(arr);
        System.out.print("[");
        for(int[] res: result)
            System.out.print("[" + res[0] + ", " + res[1] + "]");
        System.out.print("]");
        System.out.println();
    }
}
