import java.util.Arrays;
import java.util.Scanner;

// https://chat.openai.com/c/e01ccd14-7ec5-479b-87d9-c11ad120479b


public class M2_369 {
    static final int MOD = 1000000007;
    static final int MAXN = 55;
    static String s;
    static long[][][][][] dp;

    // Function to recursively compute the number of valid 3-6-9 strings
    public static long solve(int pos, int s3, int s6, int s9, int t) {
        // Base case: If any digit count exceeds 17, it's not a valid string
        if (s3 >= 17 || s6 >= 17 || s9 >= 17)
            return 0;
        int k = s.length();
        // Base case: If end of string is reached, check if it forms a valid 3-6-9 string
        if (pos == k) {
            if (s3 == s6 && s6 == s9 && s3 >= 1)
                return 1;
            return 0;
        }
        // Memoization: Check if the result for the current state is already computed
        if (dp[pos][s3][s6][s9][t] != -1)
            return dp[pos][s3][s6][s9][t];
        int lim = t == 1 ? s.charAt(pos) - '0' : 9;
        int nt = t;
        long ans = 0;
        // Iterate through all possible digits up to the limit
        for (int i = 0; i <= lim; i++) {
            if (i != lim)
                nt = 0;
            else
                nt = t;
            // Recur for the next position with updated counts
            ans = (ans + solve(pos + 1, s3 + (i == 3 ? 1 : 0), s6 + (i == 6 ? 1 : 0), s9 + (i == 9 ? 1 : 0), nt) % MOD)
                    % MOD;
        }
        // Store the computed result for future reference
        dp[pos][s3][s6][s9][t] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            s = sc.next();
            // Initialize DP array
            dp = new long[MAXN][18][18][18][2];
            for (int i = 0; i < MAXN; i++) {
                for (int j = 0; j < 18; j++) {
                    for (int k = 0; k < 18; k++) {
                        for (int l = 0; l < 18; l++) {
                            Arrays.fill(dp[i][j][k][l], -1);
                        }
                    }
                }
            }

            // Decrement the given number and compute the count of valid strings less than it
            int i = s.length() - 1;
            while (s.charAt(i) == '0') {
                char[] sArray = s.toCharArray();
                sArray[i] = '9';
                s = new String(sArray);
                i--;
            }
            char[] sArray = s.toCharArray();
            sArray[i]--;
            s = new String(sArray);

            long y = solve(0, 0, 0, 0, 1);

            // Clear DP array for the next computation
            for (int j = 0; j < MAXN; j++) {
                for (int k = 0; k < 18; k++) {
                    for (int l = 0; l < 18; l++) {
                        for (int m = 0; m < 18; m++) {
                            Arrays.fill(dp[j][k][l][m], -1);
                        }
                    }
                }
            }

            // Compute the count of valid strings for the given number
            long x = solve(0, 0, 0, 0, 1);
            long ans = (x - y + MOD) % MOD;
            System.out.println(ans);
        }

        sc.close();
    }
}
