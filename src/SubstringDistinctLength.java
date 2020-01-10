/*
 * Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.
 *
 * Example 1:
 * Input: s = "abcabc", k = 3
 * Output: ["abc", "bca", "cab"]
 *
 * Example 2:
 * Input: s = "abacab", k = 3
 * Output: ["bac", "cab"]
 *
 * Example 3:
 * Input: s = "awaglknagawunagwkwagl", k = 4
 * Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
 *
 * Explanation:
 * Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl"
 * "wagl" is repeated twice, but is included in the output once.
 *
 * Constraints:
 * The input string consists of only lowercase English letters [a-z]
 * 0 ≤ k ≤ 26
 *
 * @author Sanjana Shah
 */

import java.util.ArrayList;
import java.util.List;

public class SubstringDistinctLength {
    private List<String> getSubstrings(String s) {
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

    private List<String> distinctLength(List<String> s, int n) {
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

        List<String> result = new ArrayList<String>();
        for(String str : arr) {
            if(str.length() == n && !result.contains(str)) {
                result.add(str);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubstringDistinctLength sdl = new SubstringDistinctLength();

        List<String> arr = sdl.getSubstrings("abcabc");
        System.out.println(sdl.distinctLength(arr, 3));
    }
}
