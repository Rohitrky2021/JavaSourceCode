import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(0, n, ans, 0, "");
        return ans;
    }

    public void helper(int close, int n, List<String> ans, int open, String s) {
        if (open == n && close == n) {
            ans.add(s);
            return;
        }

        if (open < n) {
            helper(close, n, ans, open + 1, s + "(");
        }

        if (close < open) {  // jub open jaada ho tabhi close daalnaa
            helper(close + 1, n, ans, open, s + ")");
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generator = new GenerateParenthesis();
        int n = 3; // You can change the value of 'n' to generate different combinations.
        List<String> combinations = generator.generateParenthesis(n);

        System.out.println("Valid Parentheses Combinations for n=" + n + ":");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}
