// this is similar ques like count partition with given difference
// we have given a target we can use two signs + or - if we assign positive that means we have to add them
// if - that means we have to subtract so by adding all our array will divide in two subsetrs s1 - s2 = d
// and this is similar ques like Q18 
public class Q21_Target_sum {

    public static int f(int idx, int tar, int[] arr) {

        if (idx == 0) {
            if (tar == 0 && arr[idx] == 0)
                return 2;

            if (tar == 0 || arr[idx] == tar)
                return 1;

            return 0;
        }

        int nottake = f(idx - 1, tar, arr);

        int take = 0;
        if (arr[idx] <= tar)
            take = f(idx - 1, tar - arr[idx], arr);

        return take + nottake;

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 1 };
        int target = 3;

        int n = arr.length;

        int totalsum = 0;
        for (int val : arr)
            totalsum += val;

        if (totalsum - target < 0 || (totalsum - target) % 2 == 1)
            System.out.println(0);

        // recursion
        // System.out.println(f(n-1, (totalsum - target) / 2, arr));

        int s2 = (totalsum - target) / 2;

        // memoization
        // Integer[][] dp = new Integer[n][s2+1];
        // System.out.println(f2(n-1, s2, arr, dp));

        // tabulation
        int[][] dp = new int[n][s2 + 1];
        if (arr[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;

        if (arr[0] != 0 && arr[0] <= s2)
            dp[0][arr[0]] = 1;

        for (int idx = 1; idx < n; idx++) {
            for (int tar = 0; tar <= s2; tar++) {
                int nottake = dp[idx - 1][tar];

                int take = 0;
                if (arr[idx] <= tar)
                    take = dp[idx - 1][tar - arr[idx]];

                dp[idx][tar] = take + nottake;
            }
        }

        System.out.println(dp[n-1][s2]);

    }

    public static int f2(int idx, int tar, int[] arr, Integer[][] dp) {

        if (idx == 0) {
            if (tar == 0 && arr[idx] == 0)
                return 2;

            if (tar == 0 || arr[idx] == tar)
                return 1;

            return 0;
        }

        if (dp[idx][tar] != null)
            return dp[idx][tar];

        int nottake = f2(idx - 1, tar, arr, dp);

        int take = 0;
        if (arr[idx] <= tar)
            take = f2(idx - 1, tar - arr[idx], arr, dp);

        return dp[idx][tar] = take + nottake;

    }

}
