package T19_Dynamic_Programming;

public class DP15_catalonSerise {

    static int rec1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += rec1(i) * rec1(n - i - 1);
        }

        return ans;
    }

    static int rec2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans += rec2(i) * rec2(n - i - 1);
        }
        ans *= 2;
        if ((n & 1) == 1) {
            int temp = rec2(n / 2);
            ans += temp * temp;
        }
        return ans;
    }

    static int memo1(int n, int dp[]) {
        if (n == 0 || n == 1) {
            dp[n] = 1;
            return dp[n];
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += memo1(i, dp) * memo1(n - i - 1, dp);
        }

        dp[n] = ans;
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[n];
    }

    static int memo2(int n, int dp[]) {
        if (n == 0 || n == 1) {
            dp[n] = 1;
            return dp[n];
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = memo2(i, dp);
        }
        for (int i = 0; i < n; i++) {
            ans += dp[i] * dp[n - i - 1];
        }
        dp[n] = ans;
        return dp[n];
    }

    static void tabulatiion(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;
        int dp[] = new int[n + 1];
        int ans = memo1(n, dp);
        System.out.println(ans);
    }
}
