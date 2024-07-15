import java.util.Math.*;
public class catalammain {

    // Total it has ==> 14 Applications 
    // https://www.geeksforgeeks.org/applications-of-catalan-numbers/

    // 1 , 1 , 2, 5 , 14, 42, 132 

    // M1 Direct Formula 
    // ya tha formula is --> 2nCn/n+1

//  M2 -->recursive + Memo 
    public static int catalanMemori(int n){
        if(n==0||n==1){
            return 1;
        }
        
        int ans=0;//Cn
        for (int i = 0; i <n; i++) {
            ans+=catalanMemori(i)*catalanMemori(n-i-1);
        }
        return ans;
    }

    // M3 --> Tablulation -Bottom Up 

    public static int catalanTABULAT(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                int left=dp[j];
                int right=dp[i-j-1];//Ci = Cj * Ci-j-1;
                dp[i]+=left*right;
            }
        }
        return dp[n];
    }

        public static void main(String args[]){
            System.out.println(catalanMemori(4));
        }
}
