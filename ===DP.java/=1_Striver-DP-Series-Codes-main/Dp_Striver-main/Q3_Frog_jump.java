import java.util.*;
// in the qustion we have given n staricase and height array which contains energy at each stairs
// their is frog who can jump either 1 step or 2 step and lost some energy
// if frog go to jth stair from ith stair then energy used by frog will be abs of height[j] - height[i]
// so frog want to go to nth stair by using min energy
public class Q3_Frog_jump {

    public static int solve(int n, int[] dp, int[] heights){

        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];

        int left = solve(n-1, dp, heights) + Math.abs(heights[n] - heights[n-1]); // for one step jump
        int right = Integer.MAX_VALUE;
        // for 2 step jump, so it is compulosory to check wheather index is greater than 1 or not
        // otherwise we will get array out of bound exception
        if(n - 2 >= 0) right = solve(n-2, dp, heights) + Math.abs(heights[n-2] - heights[n]);

        return dp[n] = Math.min(left, right);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] heights = new int[n];
        for(int i = 0; i < n; i++) heights[i] = scn.nextInt();
        scn.close();
        
        // memoization
        // int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println(solve(n-1, dp, heights));

        // tabulation
        int[] dp = new int[n]; // taking n as size bcoz we are doing 0 based indexing 
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            int fs = dp[i-1] + Math.abs(heights[i] - heights[i-1]); // first step
            int ss = Integer.MAX_VALUE;
            if(i > 1) ss = dp[i-2] + Math.abs(heights[i] - heights[i-2]); // second step

            dp[i] = Math.min(fs, ss);
        }

        System.out.println(dp[n-1]);

        // optiized of sc as o(1)
        // use three variables
        int prev1 = 0, prev2 = 0;
        for(int i = 1; i < n; i++){
            int fs = prev1 + Math.abs(heights[i] - heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1) ss = prev2 + Math.abs(heights[i] - heights[i-2]);
            int curr = Math.min(fs, ss);
            prev2 = prev1;
            prev1 = curr;
        }
        System.out.println(prev1);
    }
}
