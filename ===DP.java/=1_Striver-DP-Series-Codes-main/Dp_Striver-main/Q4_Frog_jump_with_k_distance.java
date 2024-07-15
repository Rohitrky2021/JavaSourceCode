import java.util.*;
// this is the follow up question of Q3 frog jump, in that we have given that 2 jumps are allowed
// and here we have given k so k jumps are allowed
// so in that we calcuate first and second step but here we create a for loop and calculate 
public class Q4_Frog_jump_with_k_distance {
    public static int solve(int n, int k, int[] dp, int[] h){
        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];

        // by default minstep stored max value
        // now inside loop firstly check n-i is greater than or equal to 0 or not
        // if yes than onlu solve and compare values with min step
        int minStep = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++){
            if(n-i >= 0){
            int jump = solve(n - i, k, dp, h) + Math.abs(h[n] - h[n-i]);
            minStep = Math.min(jump, minStep);
            }
        }
        return dp[n] = minStep;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // total no of steps

        int[] heights = new int[n];
        for(int i = 0; i < n; i++) heights[i] = scn.nextInt(); // energy required on n steps
        int k = scn.nextInt(); // jumps which are possibls
        scn.close();

        // memoization
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);

        // System.out.println(solve(n-1, k, dp, heights));

        // tabulation
        int[] dp = new int[n];
        dp[0] = 0;

        for(int i = 1; i < n; i++){
            int minStep = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++){
                if(i-j >= 0){
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]); 
                    minStep = Math.min(minStep, jump); 
                }
            }
            dp[i] = minStep;
        }
        System.out.println(dp[n-1]);

    }
}
