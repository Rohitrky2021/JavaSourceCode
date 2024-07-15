package One_d_DP;

public class Min_cost_Climb_Stair {

    // Using Simple Recursion  --(Tc  -0(2^n) Sc- 0(N) )
    public static int RecCost(int i, int cost[], int n) {
        if (i == n) {
            return 0;
        }

        int one = cost[i] + RecCost(i + 1, cost, n);
        int two = Integer.MAX_VALUE;
        if (i != n - 1) {
            two = cost[i] + RecCost(i + 2, cost, n);
        }
        return Math.min(one, two);

    }

    // Using Memorization DP - (TC  -0(N) ,Sc- 0(N))
    public static int Costdp(int i, int cost[], int n, int dp[]) {
        if (i == n) {
            return 0;
        }

        int one = cost[i];
        if (dp[i + 1] == -1) {
            one = one + Costdp(i + 1, cost, n, dp);
        } else {
            one = one + dp[i + 1];
        }

        int two = Integer.MAX_VALUE;
        if (i != n - 1) {

            two = cost[i];

            if (dp[i + 1] == -1) {
                two = two + Costdp(i + 2, cost, n, dp);
            } else {
                two = two + dp[i + 2];
            }
        }
        dp[i] = Math.min(one, two);
        return Math.min(one, two);

    }


    //Using Tabulation +Space Optimization --(Tc -0(N) , SC  -0(1))
    public static int CostTab(int[] cost) {
        int p1 = cost[1];
        int p2 = cost[0];
       
        for(int i=2;i<cost.length;i++){
           int curr = cost[i]+Math.min(p1,p2);
           p2 = p1 ;
           p1 = curr;
          
        }
        return Math.min(p2,p1);

    }

    public static void main(String[] args) {
        int arr[]  = {3,6,7};
        System.out.println(CostTab(arr));
    }
}
