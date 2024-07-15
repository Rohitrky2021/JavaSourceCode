package Subsequence_DP;

public class parti_subset_equal_sum {

    //Question    Partition Equal Subset Sum 
    //for example let's say the given array is [2 3 3 3 4 5] then the array can be partitioned as [2 3 5] and [3 3 4] with equal sum 10

    //Follow up Question of SUBSET EQUAL TARGET 

     //Tabulation ----(TC--- 0(N*target) ,SC -0(N*target) )
     public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean  dp[][] = new boolean  [n][k+1];
     
        //***********TABULATION****************

        //Base Case *
        for(int i=0;i<n;i++){
            dp[i][0]  = true;
        }

        if(arr[0]<=k){
            dp[0][arr[0]] = true;
        }
      

        //Nested loop = how many parametter change 
        for(int i=1;i<n;i++){

            for(int target=1;target<=k;target++){

                    boolean take = false;
                    if(target>=arr[i]){
                        take = dp[i-1][target-arr[i]];
                    }

                    boolean nontake =  dp[i-1][target];
                
                    if(take || nontake){
                        dp[i][target] = true;              
                    }
                    else{
                        dp[i][target] = false;
                    }         
            }
        }

        return dp[n-1][k];
        
    }
    public static void main(String[] args) {
        int arr[] = {2,3,3,3,4,5};
        int n = arr.length;
        int sum=0;
        //first calculate total sum 
        for(int v:arr){
            sum+=v;
        } 
        // total sum is odd then it is not possibale 
        if(sum%2!=0){
           System.out.println("false");
        }
        else{
            //if total sum is even then check any sub set sum is equal to total sum/2 ****
            int target = sum/2;  //here target is total sum/2 (this is small change)
            System.out.println(subsetSumToK(n,target,arr));

        }
 
        
         
    }
}
