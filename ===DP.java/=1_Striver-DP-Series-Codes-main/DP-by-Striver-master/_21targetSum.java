/*
We are given an array ‘ARR’ of size ‘N’ and a number ‘Target’. Our task is to build
an expression from the given array where we can place a ‘+’ or ‘-’ sign in front of an integer.
We want to place a sign in front of every integer of the array and get our required target.
We need to count the number of ways in which we can achieve our required target.
 */

import java.util.Arrays;

public class _21targetSum {
    public static void main(String[] args) {
        int arr[] = {1,2,3,1};
        int target=3;

        int n = arr.length;
        System.out.println("The number of ways found is "+targetSum(n,target,arr));
    }

    static int targetSum(int n,int target,int[] arr){
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-target<0) return 0;
        if((totSum-target)%2==1) return 0;

        int s2 = (totSum-target)/2;

        int dp[][]=new int[n][s2+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return countPartitionsUtil(n-1,s2,arr,dp);
    }

 //  Same aS partitio with  Given Difference 
    static int countPartitionsUtil(int ind, int target, int[] arr,int[][] dp){

        if(ind == 0){
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target == arr[0])
                return 1;
            return 0;
        }

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken = countPartitionsUtil(ind-1,target,arr,dp);

        int taken = 0;
        if(arr[ind]<=target)
            taken = countPartitionsUtil(ind-1,target-arr[ind],arr,dp);

        return dp[ind][target]= (notTaken + taken);
    }

}
