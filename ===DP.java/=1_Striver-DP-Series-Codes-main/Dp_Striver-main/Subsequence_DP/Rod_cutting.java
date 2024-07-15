package Subsequence_DP;

public class Rod_cutting {

    //Follow up question of ---- coin change 2 

    //Recursion ----Tc--0(2^n),sc-0(M))
    public static int rec(int i,int target,int price[]){
        if(target==0){
            return 0;
        }
        if(i==0){
            int t = price[0]*(target/1);
            return t;
        }

        int take  = Integer.MIN_VALUE;
        if(target>=(i+1)){
            take = price[i]+rec(i,target-(i+1),price);
        }

        int non = rec(i-1,target,price);
        
        return Math.max(take,non);

    }


    //Memorization + DP - --(TC-0(N*M),Sc -0(N*M)+0(M))
    public static int DP(int i,int target,int price[],int dp[][] ){
        if(target==0){
            return 0;
        }
        if(i==0){
            int t = price[0]*(target/1);
            return t;
        }

        if(dp[i][target]!=-1){
            return dp[i][target];
        }

        int take  = Integer.MIN_VALUE;
        if(target>=(i+1)){
            take = price[i]+DP(i,target-(i+1),price,dp);
        }

        int non = DP(i-1,target,price,dp);
        dp[i][target]  = Math.max(take,non);
        
        return Math.max(take,non);    
    }


    //Tabulation --- (TC-0(N*M),Sc -0(N*M) )
    public static int cutRod(int price[], int n) {
        int target = n;
        int dp[][]  = new int [n][target+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] =-1;
            }
        }
		
       
       //-----------------Tabulation----------------------
        for(int i=0;i<=target;i++){
            int t = price[0]*(i/1);
            dp[0][i] = t;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int take  = Integer.MIN_VALUE;
                if(j>=(i+1)){
                    take = price[i]+dp[i][j-(i+1)] ;
                }

                int non = dp[i-1][j] ;
                dp[i][j]  = Math.max(take,non);
            }
        }

        return dp[n-1][target];
    }




    //Space Optimization -----(TC-0(N*M),Sc -0(M) )
    public static int Space(int  price[],int n ){

        int target = n;
    
       // ----------------Space Optimization----------------------
        int dp[]  = new int [target+1];
         for(int i=0;i<=target;i++){
            int t = price[0]*(i/1);
            dp[i] = t;
        }

          for(int i=1;i<n;i++){
                int curr[] = new int [target+1];
                for(int j=0;j<=target;j++){
                    int take  = Integer.MIN_VALUE;
                    if(j>=(i+1)){
                        take = price[i]+curr[j-(i+1)] ;
                    }

                    int non = dp[j] ;
                    curr[j]  = Math.max(take,non);
                }

                dp = curr;
        }

        return dp[target];
    }
    public static void main(String[] args) {
        
    }
}
