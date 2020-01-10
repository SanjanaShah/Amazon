import java.util.ArrayList;
import java.util.List;

/*
 * Given a string s and an int k, return an int representing the number of substrings (not unique) of s with exactly k
 * distinct characters. If the given string doesn't have k distinct characters, return 0.
 *
 * Example 1:
 * Input: s = "pqpqs", k = 2
 * Output: 7
 * Explanation: ["pq", "pqp", "pqpq", "qp", "qpq", "pq", "qs"]
 *
 * Example 2:
 * Input: s = "aabab", k = 3
 * Output: 0
 *
 * Constraints:
 * The input string consists of only lowercase English letters [a-z]
 * 0 ≤ k ≤ 26
 *
 * @author Sanjana Shah
 */
public class SubstringDistinct {
    public List<String> getSubstrings(String s) {
        List<String> arr = new ArrayList<String>();
        char[] str = s.toCharArray();
        for(int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                int temp = j + i - 1;
                String holder = "";
                for (int k = j; k <= temp; k++)
                    holder += str[k];
                arr.add(holder);
            }
        }
        return arr;
    }

    private List<String> distinct(List<String> s, int n) {
        List<String> arr = new ArrayList<String>();
        for(String str: s) {
            char[] sep = str.toCharArray();
            List<Character> visited = new ArrayList<Character>();
            for(Character c : sep) {
                if(!visited.contains(c)) {
                    visited.add(c);
                }
            }
            if(visited.size() == n)
                arr.add(str);
        }
        return arr;
    }

    public static void main(String[] args) {
        SubstringDistinct sd = new SubstringDistinct();

        List<String> arr = sd.getSubstrings("pqpqs");
        System.out.println(sd.distinct(arr, 2).size());
    }
}
