import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class _42printLIS {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 3, 2, 3 };
        int n = arr.length;

        System.out.println("tabu " + tabu(arr, n));
        System.out.println("sapce : " + space(arr, n));
    }

    public static int tabu(int[] arr, int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int len = dp[i + 1][prev + 1];
                if (prev == -1 || arr[i] > arr[prev]) {
                    len = Math.max(len, 1 + dp[i + 1][i + 1]);
                }
                dp[i][prev + 1] = len;
            }
        }
        return dp[0][0];
    }

    public static int space(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        int last_ind = 0;
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j; // This hash we use bcoz it helps in Printing LIS trackback
                }

            }
            if (dp[i] > maxi) {
                maxi = dp[i];
                last_ind = i; // last ka index leke track back krnege
            }
        }
        Stack<Integer> st = new Stack<>();
        st.push(arr[last_ind]);
        while (hash[last_ind] != last_ind) {
            last_ind = hash[last_ind]; // ye backtrack krwaate jaa rha hai
            st.push(arr[last_ind]);
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        return maxi;
    }
}
