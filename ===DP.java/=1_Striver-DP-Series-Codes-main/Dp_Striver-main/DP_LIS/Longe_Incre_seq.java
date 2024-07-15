package DP_LIS;

import java.util.*;

public class Longe_Incre_seq {

    // Recursion -- Time - 0(N^2) ,space - 0(N)
    public static int rec(int i,int prev,int nums[]){
        if(i>=nums.length){
            return 0;
        }
        int take= 0;
        if(prev==-1 || nums[prev]<nums[i]){
            take = 1+rec(i+1,i,nums);
        }
        int non = rec(i+1,prev,nums);
        return Math.max(non,take);
    }


    // Memorization -- Time - 0(N^2) , Space - 0(N*N)
    public static  int DP(int i, int prev, int nums[], int dp[][]) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }

        int take = 0;
        if (prev == -1 || nums[prev] < nums[i]) {
            take = 1 + DP(i + 1, i, nums, dp);
        }
        int non = DP(i + 1, prev, nums, dp);

        int max = Math.max(non, take);
        dp[i][prev + 1] = max;
        return max;
    }


    //Tabulation --Time -  0(N^2) , Space - 0(N*N);
      public static int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int curr[] = new int [n+1];
            for (int prev = -1; prev < i; prev++) {
                int take = 0;
                if (prev == -1 || nums[prev] < nums[i]) {
                    take = dp[i+1]+1; 
                }
                int non = dp[prev + 1]; 

                int max = Math.max(non, take);
                curr[prev + 1] = max;
              
            }
            dp= curr;
        }
     
        return dp[0];

    }


    // Space Optimization --Time - 0(N^2) , Space - 0(N);
    public static  int SpaceOptimization(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int curr[] = new int [n+1];
            for (int prev = -1; prev < i; prev++) {
                int take = 0;
                if (prev == -1 || nums[prev] < nums[i]) {
                    take = dp[i+1]+1; 
                }
                int non = dp[prev + 1]; 

                int max = Math.max(non, take);
                curr[prev + 1] = max;
              
            }
            dp= curr;
        }
     
        return dp[0];

    }


    // Algorithm way ---Time - 0(N^2) ,Space - 0(N)
    public static int LIS(int n, int a[])
    {
        int ans =0;
        int dp[] = new int [n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            int max =1;
            for(int j=0;j<i;j++){
                if(a[i]>a[j]){
                    int t  = dp[j];
                    t++;
                    max = Math.max(max,t);
                    dp[i] = max;
                }
                
            }
            
            ans = Math.max(ans,max);
        }
        
        return ans;
    }



    //****OPTIMIZE METHOD*********
    // ******* Binary Searching Approach ***** [Only get length of LIS but not print this approach]
    // Time - 0(N* log(N)),,,Space - 0(N)  
    public static int lowerBound(ArrayList<Integer> arr,int x) {
        int start = 0;
        int end = arr.size()-1;
        int n = arr.size();
        int ans =n;
      
        while(start<=end){ 
          
            int mid = (start+end)/2;
            if(arr.get(mid)>=x){
                end = mid-1;
                ans = mid;
            }
            else{
                start = mid+1;
            }
        }
 
        return ans;
     }
     
     static int longestSubsequence(int size, int a[])
     {
         ArrayList<Integer> lis = new ArrayList<>();
         lis.add(a[0]);
         for(int i=1;i<size;i++){
             if(lis.get(lis.size()-1)<a[i]){
                 lis.add(a[i]);
             }
             else{
                 int in = lowerBound(lis,a[i]);
                 lis.set(in,a[i]);
             }
         }
         
         int length = lis.size();
         return length;
     }
    
    

    public static void main(String[] args) {
        int prices[] = new int [6];
        prices[0] = 7;
        prices[1] = 1;
        prices[2] = 5;
        prices[3] = 3;
        prices[4] = 6;
        prices[5] = 4;
        int n  = prices.length;
        int dp[][] = new int [n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(DP(0,-1,prices,dp));
    }
}
