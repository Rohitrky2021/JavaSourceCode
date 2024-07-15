import java.util.Arrays;
import java.util.Scanner;

public class number369 {
    static final int MOD = 1000000007;
    static final int MAXN = 100005;
    static int n;
    static long[][][][][] dp;

    // Function to recursively compute the number of valid 3-6-9 strings
    public static long solve(String s, int index, int count3, int count6, int count9, int isPrefixEqual) {
        // Memoization: Check if the result for the current state is already computed
        if (dp[index][count3][count6][count9][isPrefixEqual] != -1)
            return dp[index][count3][count6][count9][isPrefixEqual];

        long res = 0;

        if (index == n) {
            // If the end of the string is reached, check if it forms a valid 3-6-9 string
            if (count3 >= 1 && count3 == count6 && count6 == count9) {
                return 1L; // Valid string
            }
        } else {
            if (isPrefixEqual == 1) {
                // If the current prefix is equal, consider only the digits up to the corresponding digit in the string
                for (int i = 0; i <= s.charAt(index) - '0'; i++) {
                    if (s.charAt(index) - '0' == i) {
                        // Recur with incremented counts if the current digit is 3, 6, or 9
                        res += solve(s, index + 1, (i == 3) ? count3 + 1 : count3, (i == 6) ? count6 + 1 : count6,
                                (i == 9) ? count9 + 1 : count9, 1);
                        res %= MOD;
                    } else {
                        // Recur without incrementing counts for other digits
                        res += solve(s, index + 1, (i == 3) ? count3 + 1 : count3, (i == 6) ? count6 + 1 : count6,
                                (i == 9) ? count9 + 1 : count9, 0);
                        res %= MOD;
                    }
                }
            } else {
                // If the current prefix is not equal, consider all digits from 0 to 9
                for (int i = 0; i <= 9; i++) {
                    // Recur for all possible digits
                    res += solve(s, index + 1, (i == 3) ? count3 + 1 : count3, (i == 6) ? count6 + 1 : count6,
                            (i == 9) ? count9 + 1 : count9, 0);
                    res %= MOD;
                }
            }
        }

        // Store the computed result for future reference
        dp[index][count3][count6][count9][isPrefixEqual] = res;
        return res;
    }

    // Function to compute the number of valid 3-6-9 strings in a given string
    public static long f(String s) {
        // Count occurrences of 3, 6, and 9 in the string
        int count3 = 0, count6 = 0, count9 = 0;
        for (char c : s.toCharArray()) {
            if (c == '3')
                count3++;
            else if (c == '6')
                count6++;
            else if (c == '9')
                count9++;
        }
        // Return 1 if the string forms a valid 3-6-9 string, else return 0
        return (count3 >= 1 && count3 == count6 && count6 == count9) ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();

            // Initialize DP array
            dp = new long[55][55][55][55][2];
            for (int i = 0; i < 55; i++) {
                for (int j = 0; j < 55; j++) {
                    for (int k = 0; k < 55; k++) {
                        for (int l = 0; l < 55; l++) {
                            Arrays.fill(dp[i][j][k][l], -1);
                        }
                    }
                }
            }

            // Calculate the number of valid strings for range [a, b]
            n = b.length();
            long ansR = solve(b, 0, 0, 0, 0, 1);

            // Clear DP array for the next computation
            for (int i = 0; i < 55; i++) {
                for (int j = 0; j < 55; j++) {
                    for (int k = 0; k < 55; k++) {
                        for (int l = 0; l < 55; l++) {
                            Arrays.fill(dp[i][j][k][l], -1);
                        }
                    }
                }
            }

            // Calculate the number of valid strings for range [0, a]
            n = a.length();
            long ansL = solve(a, 0, 0, 0, 0, 1);

            // Compute the final answer
            long ans = (ansR - ansL + f(a) + MOD) % MOD;
            System.out.println(ans);
        }

        sc.close();
    }
}
