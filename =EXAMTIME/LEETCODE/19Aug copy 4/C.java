import java.util.*;

class C {
    public static void main(String[] args) {
        C solution = new C();

        int[] nums1 = { 1, 2, 1, 1, 3 };
        int k1 = 2;
        System.out.println(solution.maximumLength(nums1, k1));

        int[] nums2 = { 1, 2, 3, 4, 5, 1 };
        int k2 = 0;
        System.out.println(solution.maximumLength(nums2, k2));
    }

    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][][] dp = new int[n + 1][n + 1][k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = -1; prev < n; prev++) {
                int prevIndex = prev + 1;
                for (int remainingK = 0; remainingK <= k; remainingK++) {

                    int not = dp[i + 1][prevIndex][remainingK];

                    int take = 0, takee = 0;

                    if (remainingK > 0) {

                        if (prev == -1 || nums[i] != nums[prev]) {

                            take = 1 + dp[i + 1][i + 1][remainingK - 1];
                        }
                    }

                    if (prev == -1 || nums[i] == nums[prev]) {
                        takee = 1 + dp[i + 1][i + 1][remainingK];
                    }

                    dp[i][prevIndex][remainingK] = Math.max(not, Math.max(take, takee));
                }
            }
        }

        return dp[0][0][k];
    }

    // public int maximumLength(int[] nums, int k) {
    // int n = nums.length;
    // int[][][] dp = new int[n + 1][n + 1][k + 1];

    // int ans=solve(nums, 0, -1, k, dp);

    // return ans;
    // }

    // public int solve(int[] arr, int i, int prev, int k, int[][][] dp) {
    // if (i == arr.length )
    // return 0;

    // if(k<0)return 0;

    // if (dp[i][prev + 1][k] != 0)
    // return dp[i][prev + 1][k];

    // int not = solve(arr, i + 1, prev, k, dp);

    // int take = 0, takee = 0;

    // if ((prev == -1 ||( k>0 && arr[i] != arr[prev]))) {
    // take = 1 + solve(arr, i + 1, i, k - 1, dp);
    // }

    // if ((prev == -1 || arr[i] == arr[prev])) {
    // takee = 1 + solve(arr, i + 1, i, k, dp);
    // }

    // int result = Math.max(take, Math.max(takee, not));
    // dp[i][prev + 1][k] = result;

    // return result;
    // }
}
