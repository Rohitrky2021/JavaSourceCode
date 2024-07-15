package One_d_DP;

import java.util.Arrays;

public class Frog_Jump_k_dis {

    // Question - frog can jum at max k step (sam prob as frog can jump 1 or two step )

     
    // Simple Recursion --(Tc - (k*2N) Sc-o(N))
    public static int frogRec(int k, int i, int height[], int n, int dp[]) {
        if (i == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {

            int one = frogRec(k, i - j, height, n, dp) + Math.abs(height[i] - height[i - j]);
            min = Math.min(one, min);
            if (i == j) {
                return min;
            }

        }

        return min;
    }

    // Memorization solution--(Tc - 0(k*n) ,Sc - 0(n) )
    public static int frogDp(int k, int i, int height[], int n, int dp[]) {
        if (i == 0) {
            return 0;
        }

        if (dp[i] != -1) {

            return dp[i];
        } 
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {

            int one = 0;
          
            one = frogDp(k, i - j, height, n, dp);

            one = one + Math.abs(height[i] - height[i - j]);
            min = Math.min(one, min);
            if (i == j) {
                return min;
            }

        }

        dp[i] = min;
        return min;
    }

    //This problem has tabulation but this is not optimize bec there TC-0(K*N) , Sc - 0(N)
    public static void main(String[] args) {
        
        int height[] = {40 ,30,20};
        int n = height.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        System.out.println(frogDp(5, n - 1, height, n, dp));
    }
}
