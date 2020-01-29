/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * For n = 0, return empty
 * For n = 1, return ()
 * For n = 2, return ()(), (()).
 * For n = 3, return as above.
 *
 * @author Sanjana Shah
 */
import java.util.*;
public class GenerateParentheses {
    private void parensHelper(int n, int left, int right, StringBuilder sb, List<String> result) {
        if(left < right) //you should not have the number of right parenthesis greater than the number of left.
            return;
        if(left == n && right == n) //reached the end, add string builder to result
            result.add(sb.toString());
        if(left < n) {
            sb.append("(");
            parensHelper(n, left + 1, right, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < n) {
            sb.append(")");
            parensHelper(n, left, right + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>(); //all combinations of parenthesis
        if(n <= 0)
            return result;
        StringBuilder sb = new StringBuilder();
        parensHelper(n, 0, 0, sb, result);
        return result;
    }
    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }
}
