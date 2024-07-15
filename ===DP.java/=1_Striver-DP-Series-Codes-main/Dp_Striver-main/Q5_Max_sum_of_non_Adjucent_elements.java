import java.util.Arrays;
import java.util.Scanner;

// this is similar question like leetcode 198 house robber, stickler theif, max money
// in this question we have given an array of size n
// we have to find out maximum sum of subsequence elements and we cannot pick two adjacent elements
// like if we pick ith element then we cannot pick i+1
// so we can solve this using recursion
// using dp (memoization/tabulation)
public class Q5_Max_sum_of_non_Adjucent_elements {

    public static int helper(int n, int[] dp, int[] arr){
        if(n == 0) return arr[0]; // arr doesn't have any negetive element so the best option we have
        // to pick this element
        if(n < 0) return 0; // for handling negetive indexes

        if(dp[n] != -1) return dp[n];

        int take = arr[n] + helper(n - 2, dp, arr);
        int nontake = 0 + helper(n - 1, dp, arr);

        return dp[n] = Math.max(take, nontake);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // size of array
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = scn.nextInt();
        scn.close();

        // memoziation
        int[] dp = new int[n];
        Arrays.fill(dp, -1); 
        System.out.println(helper(n-1, dp, arr));

        // tabulation
        // craeet a dp[] of size n
        // int[] dp = new int[n];
        // dp[0] = arr[0]; 
        // if we have 1 element and out array contains positive elements so we have two options
        // either pic so sum will be arr[0], second non pick so sum will be 0
        // and we are required to find out max sum so it'll be on take so for first we're putting arr[0]
        // now start loop from i = 1 to n

        for(int i = 1; i < n; i++){
            int take = arr[i];
            // we are taking ith element so now you cannot take i-1 so take i-2 but check if i is greater
            // than 1 then only otherwise it'll give an error of array out of bound 
            if(i > 1) take += dp[i - 2];

            // for non take we can use previous element
            int nontake = 0 + dp[i-1];

            // now compare both and put max value into dp[i]
            dp[i] = Math.max(take, nontake);
        }

        // System.out.println(dp[n-1]);
        // in this method we are using a for loop of n size so space complexity is O(n)
        // time complexity is also O(n)
        // we can optimize the space complexity by using two variale prev1 and prev2
        // which we used in the previous question
    }
}
