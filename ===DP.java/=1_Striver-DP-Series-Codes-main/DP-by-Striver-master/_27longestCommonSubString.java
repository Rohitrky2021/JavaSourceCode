
//here we used que 26 tabulation
public class _27longestCommonSubString {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abxd";
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0; j <= m; j++)
            dp[0][j] = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println("common substring length is : " + ans);
    }
}
/*
 * Time complexity: O(N * M)
 * Space complexity: O(N)
 * 
 * Where 'N' and 'M' are the lengths of the two strings.
 */
public class Solution {
    public static int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];
        // m is always larger string
        int ans = 0;
        int[] curr = new int[m + 1];
        for (int j = 0; j <= m; j++) {
            prev[j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    ans = Math.max(curr[j], ans);
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr.clone(); // Deep clone Not work here was GIving WR
        }
        return ans;
    }
}

/*
 * Time complexity: O(2 ^ (N + M))
 * Space complexity: O(max(N, M))
 * 
 * Where 'N' and 'M' are the lengths of the two strings.
 */

public class Solution {
    // Function that calculates longest common substring.
    private static int lcsHelper(String str1, String str2, int n, int m, int count) {
        // If travesed complete string then return the value of count.
        if (m == -1 || n == -1) {
            return count;
        }

        // If the characters at 'n' and 'm' are same then call for the rest of the
        // strings.
        if (str1.charAt(n) == str2.charAt(m)) {
            count = lcsHelper(str1, str2, n - 1, m - 1, count + 1);
        }

        count = Math.max(count, Math.max(lcsHelper(str1, str2, n - 1, m, 0), lcsHelper(str1, str2, n, m - 1, 0)));
        return count;
    }

    public static int lcs(String str1, String str2) {
        // Return the value obtained from lcsHelper.
        return lcsHelper(str1, str2, str1.length() - 1, str2.length() - 1, 0);
    }
}
/*
 * Time complexity: O((N * M * min(N, M))
 * Space complexity: O(1)
 * 
 * Where 'N' and 'M' are the lengths of the two strings.
 */

public class Solution {
    public static int lcs(String str1, String str2) {
        // Variable to store the answer.
        int ans = 0;

        // Iterate through first string.
        for (int i = 0; i < str1.length(); i++) {
            // Iterate through second string.
            for (int j = 0; j < str2.length(); j++) {
                // Varible that helps in checking further characters in both the strings.
                int k = 0;
                /*
                 * Keep incrementing the value of 'k' until
                 * it reaches the end of any one of the strings or the
                 * corressponding character in first string and second string becomes not same.
                 */
             while ((i + k) < str1.length() && (j + k) < str2.length() && str1.charAt(i + k) == str2.charAt(j + k)) {
                    k = k + 1;
                }

                // Take the maximum between answer and 'k' as the new value of answer.
                ans = Math.max(ans, k);
            }
        }
        // Return the answer.
        return ans;
    }
}
