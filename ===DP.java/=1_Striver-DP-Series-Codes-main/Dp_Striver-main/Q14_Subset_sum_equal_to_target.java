// import java.util.Arrays;
// given n, size of array, and all elements of array is given
// k is the target we want to get with the help of subset of array 
// if their exist any one subset whose sum is k then return true else return false
public class Q14_Subset_sum_equal_to_target {

    public static boolean f(int idx, int target, int[] arr) {
        // base case
        // when f(n-1, tar) given that means we have given array till n-1 and we need to
        // check is their
        // any subset exist with target tar
        // f(0, tar) that means we have given a one size array so if that arr[0] == tar
        // then return true
        // in any case if our tar become 0 then also return true, no need to go till 0th
        // idx
        if (target == 0)
            return true;
        if (idx == 0) {
            // if(arr[0] == target) return true;
            // else return false;
            // these two lines can also be written in one line
            return arr[0] == target;
        }

        // now for creating subset we have two options
        // either we can take this arr[idx] element or not
        // if taking then only idx will decrease, target will be same
        boolean nottake = f(idx - 1, target, arr);
        if (nottake)
            return true;

        // now if we want to take that arr[idx] element then we have to check first
        // if arr[idx] is less than or equal to target then only we can take this
        // if arr[idx] is greater than target then their is no need to take the element
        // if we are taking the arr[idx] then subtract arr[idx] from target that means
        // here we acheive arr[idx] ans rest target we want to find
        boolean take = false;
        if (arr[idx] <= target)
            take = f(idx - 1, target - arr[idx], arr);

        return take || nottake;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int k = 30; // target
        int n = arr.length;

        // recusion
        // System.out.println(f(n-1, k, arr));

        // memoization
        // since functions are overlapping so no need to call it again
        // use memoization technique and solve for only that which is not yet solved
        // basically in recusion we uses two parameters idx and target so
        // we have to create a 2D dp of size n*(k+1)
        // fill this with -1
        // and before solvinf this check is that cell value is not -1 then return that
        // value
        // the dp we created is of type int so we can check cell value to get info about
        // cell is
        // already used or not
        // int[][] dp = new int[n][k+1];
        // for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        // System.out.println(ff(n-1, k, arr, dp));

        // tabulation
        // create 2D dp of size n * (k+1)
        // in recusion base case when target was 0 we return true
        // so for dp[row][0] make it true
        // it is always possible to make target 0
        // second base case was if idx == 0 then we check if arr[0] == tar then return
        // true
        // so in 0th row at arr[0] col mark it true
        // bcoz we have one size array is presnt and we the help of that array
        // we can acheive target of arr[0] only
        // boolean[][] dp = new boolean[n][k + 1];

        // // // first base case
        // for (int i = 0; i < n; i++)
        // dp[i][0] = true;

        // // // second base case
        // if(arr[0] <= k) dp[0][arr[0]] = true;

        // // // now start row from 1 to n and col from 1 to k
        // // // copy the body of recusion inside loop and replace f with dp and in
        // place
        // // of
        // // // return
        // // // store it in dp
        // // // at end print dp[n-1][k] bcoz is recursion we start from f(n-1, k)
        // for (int idx = 1; idx < n; idx++) {
        // for (int target = 1; target <= k; target++) {
        // boolean nottake = dp[idx - 1][target];
        // if (nottake) {
        // dp[idx][target] = true;
        // continue;
        // }
        // boolean take = false;
        // if (arr[idx] <= target)
        // take = dp[idx - 1][target - arr[idx]];

        // dp[idx][target] = take || nottake;
        // }
        // }

        // System.out.println(dp[n - 1][k]);

        // space optimization
        // as we can see in tabulation we are using 2D dp
        // and while calculating cell value we are using dp[idx-1][..]
        // this idx-1 indicates that we are using prev row so use 1D dp of size k+1
        // use two 1D arrays, one prev and second curr
        // but make sure 0th col is always true so mark it true
        // copy code of tabulation
        // replace dp[idx-1] with prev and dp[idx] with curr
        boolean[] prev = new boolean[k + 1];

        prev[0] = true;

        // arr[0] has to be less then or equal to k then only we can mark it true
        // suppose arr[0] is greater than target then it'll not give accurate result
        if (arr[0] <= k) 
            prev[arr[0]] = true;

        for (int idx = 1; idx < n; idx++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean nottake = prev[target];
                boolean take = false;
                if (arr[idx] <= target)
                    take = prev[target - arr[idx]];

                curr[target] = take || nottake;
            }
            prev = curr;
        }

        System.out.println(prev[k]);

    }

    public static boolean ff(int idx, int target, int[] arr, int[][] dp) {

        if (target == 0)
            return true;
        if (idx == 0) {
            return arr[0] == target;
        }

        // if cell value is not equal to -1 then check the cell value, if it is 1 then
        // return true
        // if it is 0 then return false
        if (dp[idx][target] != -1)
            return dp[idx][target] == 1 ? true : false;

        boolean nottake = ff(idx - 1, target, arr, dp);

        boolean take = false;
        if (arr[idx] <= target)
            take = ff(idx - 1, target - arr[idx], arr, dp);

        // if any one is true then set cell value as 1 else 0
        dp[idx][target] = (take || nottake) ? 1 : 0;

        return take || nottake;
    }
}
