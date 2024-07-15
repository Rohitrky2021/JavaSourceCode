// import java.util.Arrays;
// we have given an arr in which we have given some coins that are some infinite denomination present
// we have to return total no of ways by which we can make target
public class Q22_Coin_change_2 {

    public static long f(int idx, int tar, int[] arr) {

        if (idx == 0) {
            if (tar % arr[0] == 0)
                return 1;
            return 0;
        }

        long nottake = f(idx - 1, tar, arr);

        long take = 0;
        if (arr[idx] <= tar)
            take = f(idx, tar - arr[idx], arr);

        return take + nottake;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int target = 4;

        int n = arr.length;

        // recursion
        // System.out.println(f(n-1, target, arr));

        // memoization
        // long[][] dp = new long[n][target+1];

        // for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        // System.out.println(f2(n-1, target, arr, dp));

        // tabulation
        // long[][] dp = new long[n][target + 1];
        // for (int tar = 0; tar <= target; tar++) {
        //     if (tar % arr[0] == 0)
        //         dp[0][tar] = 1;
        // }

        // for (int idx = 1; idx < n; idx++) {

        //     for (int tar = 0; tar <= target; tar++) {

        //         long nottake = dp[idx - 1][tar];

        //         long take = 0;
        //         if (arr[idx] <= tar)
        //             take = dp[idx][tar - arr[idx]];

        //         dp[idx][tar] = take + nottake;

        //     }

        // }

        // System.out.println(dp[n - 1][target]);

        // space optimization
        long[] dp = new long[target + 1];
        for (int tar = 0; tar <= target; tar++) {
            if (tar % arr[0] == 0)
                dp[tar] = 1;
        }

        for (int idx = 1; idx < n; idx++) {  

            long[] curr = new long[target + 1];

            for (int tar = 0; tar <= target; tar++) {

                long nottake = dp[tar];

                long take = 0;
                if (arr[idx] <= tar)
                    take = curr[tar - arr[idx]];

                curr[tar] = take + nottake;

            }

            dp = curr;

        }

        System.out.println(dp[target]);

    }

    public static long f2(int idx, int tar, int[] arr, long[][] dp) {

        if (idx == 0) {
            if (tar % arr[0] == 0)
                return 1;
            return 0;
        }

        if (dp[idx][tar] != -1)
            return dp[idx][tar];

        long nottake = f2(idx - 1, tar, arr, dp);

        long take = 0;
        if (arr[idx] <= tar)
            take = f2(idx, tar - arr[idx], arr, dp);

        return dp[idx][tar] = take + nottake;

    }

}
