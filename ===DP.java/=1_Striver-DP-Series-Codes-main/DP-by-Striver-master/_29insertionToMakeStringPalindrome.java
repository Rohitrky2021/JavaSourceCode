import java.util.Arrays;

public class _29insertionToMakeStringPalindrome {
    public static void main(String[] args) {
        String s= "abcaa";
        System.out.println("The Minimum insertions required to make string palindrome: "+ minInsertion(s));
    }
    static int minInsertion(String s){
        int n = s.length();
        int k = longestPalindromeSubsequence(s);
        return n-k;
    }
    static int longestPalindromeSubsequence(String s){
        String t = s;
        String ss=new StringBuilder(s).reverse().toString();
        return lcs(ss,t);
    }
    public int lcs(String s) { // LPS funciton
        char[] c = s.toCharArray();
        int n = c.length, max = 0;
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
            max = 0;
            for (int i = j - 1; i >= 0; i--) {
                int len = dp[i];
                if (c[i] == c[j])
                    dp[i] = 2 + max;

                max = Math.max(max, len);
            }
        }
        for (int len : dp)
            max = Math.max(max, len);
        return max;
    }
}

// the catch in the problem is that we make longest palindrome subsequence constant and insert other substr
// portion' reverse at required indexes.
// so our ans is total length of string - lcs
