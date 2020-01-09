/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
import java.util.*;
public class LongestPalindrome {
    public String getSubstrings(String s) {
        List<String> arr = new ArrayList<String>();
        char[] str = s.toCharArray();
        for(int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                int temp = j + i - 1;
                String holder = "";
                for (int k = j; k <= temp; k++)
                    holder += str[k];
                if(isPalindrome(holder))
                    arr.add(holder);
            }
        }
        return getMaxLength(arr);
    }

    public boolean isPalindrome(String s){
        if(s.length() < 2) return false;
        char[] str = s.toCharArray();
        for(int i = 0; i < s.length() / 2; i++) {
            if(str[i] != str[s.length() - 1 - i])
                return false;
        }
        return true;
    }

    public String getMaxLength(List<String> s) {
        if(s == null) return "";
        String max = "";
        for(String elem:s) {
            if(elem.length() > max.length()) {
                max = elem;
            }
        }
        return max;
    }

    public String dynamicMethod(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        int len = s.length();
        String ans = "";
        int max = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.println(s.charAt(j) + " " + s.charAt(i));
                boolean judge = s.charAt(j) == s.charAt(i);
                if(i - j > 2)
                    dp[j][i] = dp[j + 1][i - 1] && judge;
                else
                    dp[j][i] = judge;
                if (dp[j][i] && i - j + 1 > max) {
                    max = i - j + 1;
                    ans = s.substring(j, i + 1);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        //System.out.println(lp.dynamicMethod("babad"));
        System.out.println(lp.getSubstrings("babad"));
        System.out.println(lp.getSubstrings("cbbd"));
    }
}
