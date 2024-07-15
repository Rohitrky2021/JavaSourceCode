// this is similar ques like Q14 in that ques we have to return true if their exists any subsets with sum k
// here we have to return count so use 1 and 0 instead of true and false
// and pick & nonpick will be same but add both of them so it'll denotes count

public class Q17_Count_subsets_with_sum_k {

    public static int f(int idx, int tar, int[] arr) {
        if (tar == 0)
            return 1;
        if (idx == 0)
            return arr[idx] == tar ? 1 : 0;

        int nottake = f(idx - 1, tar, arr);

        int take = 0;
        if (arr[idx] <= tar)
            take = f(idx - 1, tar - arr[idx], arr);

        return take + nottake;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 2, 3 };
        int k = 2; // target

        int n = arr.length;

        // recursion
        // System.out.println(f(n-1, k, arr));

        // memoization
        // here we are creating dp array as Integer bcoz if we create int type then we
        // will fill array
        // with -1 and it'll take O(n) space
        // while Integer by default value is null so we can avoid this O(n) space and
        // check for null
        // value
        // Integer[][] dp = new Integer[n][k + 1];
        // System.out.println(f2(n-1, k, arr, dp));

        // tabulation
        int[][] dp = new int[n][k + 1];
        if(arr[0] == 0) dp[0][0] = 2; 
        else dp[0][0] = 1;
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

        System.out.println(dp[n - 1][k]);

        // space optimization
        // in tabulation code we can see in take and nottake idx-1 is used so we can
        // easily optimized
        // the space using 1D array

        // int[] prev = new int[k + 1];
        // prev[0] = 1;
        // if (arr[0] <= k)
        // prev[arr[0]] = 1;

        // for (int idx = 1; idx < n; idx++) {
        // int[] curr = new int[k + 1];
        // curr[0] = 1;
        // for (int tar = 1; tar <= k; tar++) {

        // int nottake = prev[tar];
        // int take = 0;
        // if (arr[idx] <= tar)
        // take = prev[tar - arr[idx]];
        // curr[tar] = take + nottake;

        // }

        // prev = curr;

        // }

        // System.out.println(prev[k]);
    }

    public static int f2(int idx, int tar, int[] arr, Integer[][] dp) {

        // we remove tar == 0 base case bcoz if we have arr : (0, 0, 1)
        // and we are at ind 2 and tar is 1 so when we take arrr[idx] element hen tar become 0
        // and bcoz of tar == 0 base case it'll retutn 1 but their is prev 0, 0 so we have
        // to move till idx == 0 then only we can apply pur base cases
        // if idx == 0 and tar and arr[idx] both are 0 that means we have 2 ways
        // one is already got tar 0 and other will be when we add 0 into sum
        // so other base cases are if tar is 0 or arr[idx] == tar so return 1
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
