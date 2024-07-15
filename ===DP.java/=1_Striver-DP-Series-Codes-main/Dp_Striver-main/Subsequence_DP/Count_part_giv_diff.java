package Subsequence_DP;

import java.util.LinkedList;
import java.util.Queue;

public class Count_part_giv_diff {

    //Question --- Count partiion with given difference ***** 

    //Follow up question ---COUNT SUB-SET EQUAL TO TARGET 

    //This function is COUNT SUB-SET EQUAL TO TARGET 
    // Tabulation ----(TC--- 0(N*target) ,SC -0(N*target) )
    public static int Tab(int n, int k, int arr[]) {
        int dp[][] = new int[n][k + 1];

        // ***********TABULATION****************

      

        //Base Case 
        //This is for arr contains 0 
        if(arr[0]==0){
            dp[0][0] = 2;
        }
        else{
            dp[0][0] =1;
        }

        if (arr[0]!=0 && arr[0] <= k) {
            dp[0][arr[0]] = 1;
        }

        // Nested loop = how many parametter change
        for (int i = 1; i < n; i++) {

            for (int target = 0; target <= k; target++) {

                int take = 0;
                if (target >= arr[i]) {
                    take = dp[i - 1][target - arr[i]];
                }

                int nontake = dp[i - 1][target];

                int total = take + nontake;
                dp[i][target] = total;
            }
        }

        return dp[n - 1][k];

    }

    public static void main(String[] args) {


        int arr[] = {5,2,5,1};
        int sum =0;
        for(int v:arr){
            sum+=v;
        }

        int d = 3;
        if(sum-d<0 || (sum-d)%2!=0){
            //if (sum-diff)%2!=0 then it is not possible 
            System.out.println("false");
        }
        else{
            //Here target is (total sum - diff)/2
            int target = (sum-d)/2;

            //this code is count sub-set equal to target .
            //Here target is (total sum - diff)/2.
            System.out.println(Tab(arr.length,target,arr));
        }
        
    }
}
