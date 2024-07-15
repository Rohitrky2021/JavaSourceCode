// we have given some infinite coins which are in arr we have target T also given
// we have to reach target using minimum coins
// like we have infinite coins of 1, 2, 3 and target T is 7
// possible coins denominations
// 1 + 1 + 1 + 1 + 1 + 1 + 1 = 7 coins
// 2 + 2 + 2 + 1 = 4 coins
// 2 + 2 + 3 = 3 coins
// 1 + 3 + 3 = 3 coinds
// like this we have many ways and we can see min coins used is 3 so our ans will be 3

// approach
// we can use recusion so we try all patha and compare count of coins and returrn min countt
// like we used approach in target sum of not take and take
// not take : if we not take then T will be same
// take : firstly check that we can take this coin or not
// if take then we use 1 coin so add 1 and call for same idx again bcoz we have infinite supply
// so we can use same idx many time
// at end return min of take or not take
// base case : when we reach at idx = 0 then check if T % arr[0] == 0 that means check if T is divisible by
// 0th idx or not if yes then return count by T / arr[0]

public class Q20_Minimum_coins {

    public static int f(int idx, int T, int[] arr) {

        if (idx == 0) {

            if (T % arr[idx] == 0)
                return T / arr[idx];
            else
                return (int) 1e9;

        }

        int nottake = 0 + f(idx - 1, T, arr);

        int take = (int) 1e9;
        if (arr[idx] <= T)
            take = 1 + f(idx, T - arr[idx], arr);

        return Math.min(take, nottake);

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3 };
        int T = 7; // target
        int n = arr.length;

        // recursion
        int ans = f(n-1, T, arr);
        if(ans >= (int)1e9) System.out.println(-1);
        else System.out.println(ans);

        // memoization
        Integer[][] dp = new Integer[n][T+1];
        int ans = f2(n-1, T, arr, dp);
        if(ans >= (int)1e9) System.out.println(-1);
        else System.out.println(ans);

        // tabulation
        int[][] dp = new int[n][T + 1];

        for (int tar = 0; tar <= T; tar++) {

            if (tar % arr[0] == 0)
                dp[0][tar] = tar / arr[0];

            else
                dp[0][tar] = (int) 1e9;

        }

        for (int idx = 1; idx < n; idx++) {

            for (int tar = 0; tar <= T; tar++) {

                int nottake = 0 + dp[idx - 1][tar];

                int take = (int) 1e9;

                if (arr[idx] <= tar)
                    take = 1 + dp[idx][tar - arr[idx]];

                dp[idx][tar] = Math.min(take, nottake);

            }

        }

        int ans = dp[n - 1][T];
        if (ans >= (int) 1e9)
            System.out.println(-1);
        else
            System.out.println(ans);

        // space optimization
        int[] prev = new int[T + 1];

        for (int tar = 0; tar <= T; tar++) {

            if (tar % arr[0] == 0)
                prev[tar] = tar / arr[0];

            else
                prev[tar] = (int) 1e9;

        }

        for (int idx = 1; idx < n; idx++) {

            int[] curr = new int[T + 1];

            for (int tar = 0; tar <= T; tar++) {

                int nottake = 0 + prev[tar];

                int take = (int) 1e9;

                if (arr[idx] <= tar)
                    take = 1 + curr[tar - arr[idx]];

                    curr[tar] = Math.min(take, nottake);

            }

            prev = curr;

        }

        int ans = prev[T];
        if (ans >= (int) 1e9)
            System.out.println(-1);
        else
            System.out.println(ans);

    }

    public static int f2(int idx, int T, int[] arr, Integer[][] dp) {

        if (idx == 0) {

            if (T % arr[idx] == 0)
                return T / arr[idx];
            else
                return (int) 1e9;

        }

        if (dp[idx][T] != null)
            return dp[idx][T];

        int nottake = 0 + f2(idx - 1, T, arr, dp);

        int take = (int) 1e9;
        if (arr[idx] <= T)
            take = 1 + f2(idx, T - arr[idx], arr, dp);

        return dp[idx][T] = Math.min(take, nottake);

    }

}
