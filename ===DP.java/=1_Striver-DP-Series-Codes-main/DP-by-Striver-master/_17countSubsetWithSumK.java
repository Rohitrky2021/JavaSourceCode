public class _17countSubsetWithSumK {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3 };
        int n = arr.length;
        int tar = 4;
        int[][] dp = new int[n][tar + 1];
        int ans = solve(arr, tar, n - 1, dp);
        System.out.println("ans is " + ans);
    }

// Time Complexity:O(N*K) Space Complexity: O(N*K) + O(N)
    public static int solve(int arr[], int t, int i, int[][] dp) {
        // if(t == 0) return 1; --> Gives Error as cases of taking 0
        // if(i == 0) return t == arr[i] ? 1 : 0;
        if (i == 0) {
            if (t == 0 && arr[i] == 0)
                return 2;
            if (t == 0 || arr[i] == t)
                return 1;
            return 0;
        }

        if (dp[i][t] != 0)
            return dp[i][t];
        int take = 0;
        if (arr[i] <= t)
            take = solve(arr, t - arr[i], i - 1, dp);
        int not = solve(arr, t, i - 1, dp);
        return dp[i][t] = (take + not) % ((int) (1e9) + 7);
    }
// Tabulation TC: O(N*K) SC: O(N*K)
    public static int Tabu(int arr[], int k, int i, int[][] dp) {
        if (arr[0] == 0) // 0 use kro ya zero k bina same tho ->2 ways
            dp[0][0] = 2;
        else
            dp[0][0] = 1;
        if (arr[0] != 0 && arr[0] <= k) // if arr[0] is 0 then we cannot put 1 so check
            dp[0][arr[0]] = 1;
        for (int idx = 1; idx < n; idx++) {
            for (int tar = 0; tar <= k; tar++) {
                int nottake = dp[idx - 1][tar];
                int take = 0;
                if (arr[idx] <= tar)
                    take = dp[idx - 1][tar - arr[idx]];
                dp[idx][tar] = take + nottake;
            }
        }

        return dp[n - 1][k];
    }
// space optimization SC: O(K)
 public static int Spaceopt(int arr[], int k, int i, int[][] dp) {
     int[] prev = new int[k + 1];
     prev[0] = 1;
     if (arr[0] <= k)
         prev[arr[0]] = 1;

     for (int idx = 1; idx < n; idx++) {
         int[] curr = new int[k + 1];
         curr[0] = 1;
         for (int tar = 1; tar <= k; tar++) { 
             int nottake = prev[tar];
             int take = 0;
             if (arr[idx] <= tar)
                 take = prev[tar - arr[idx]];
             curr[tar] = take + nottake;
         }
         prev = curr;
     }
     return prev[k];
    }
}
