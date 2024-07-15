import java.util.Arrays;

public class _34wildcardMatching {
    public static void main(String[] args) {
        String s = "abdefxi";
        String p = "ab*x?";

        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        System.out.println("memo : " + memo(s,p,n-1,m-1,dp));
        System.out.println("tabu : "+ tabu(s,p,n,m));
        System.out.println("space : " + space(s,p,n,m));
    }

    public static boolean memo(String s, String p, int i, int j, int[][] dp){

        if(i < 0 && j < 0){
            return true;
        }
        if( i < 0 && j>= 0){
            for(int x=0; x<=j;x++){
                if(p.charAt(x) != '*') return false;
            }
            return true;
        }else if(j < 0 && i>=0 ){
            return false;
        }

        if(dp[i][j] != -1) return dp[i][j] == 0 ? false : true;

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            boolean val = memo(s,p,i-1,j-1,dp);
            dp[i][j] = val == true ? 1 : 0;
            return val;
        }else if(p.charAt(j) == '*'){
            boolean val =  memo(s,p,i,j-1,dp) | memo(s,p, i-1, j,dp) | memo(s,p,i-1,j-1,dp);
            dp[i][j] = val == true ? 1 : 0;
            return val;
        }
        else {  // Condition when both not matches False Simple 
            dp[i][j] = 0;
            return false;
        }
    }


    public static boolean tabu(String s, String p, int n, int m){
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true; // 1
        for(int i = 1; i<=n; i++){ // 2
            dp[i][0] = false;
        }
        for(int j = 1; j<=m; j++){ // 3
            if(p.charAt(j-1) != '*'){
                break;
            }
            dp[0][j] = true;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] | dp[i-1][j] | dp[i-1][j-1];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static boolean space(String s, String p, int n, int m){
        boolean[]prev = new boolean[m+1];
        prev[0] = true;

        for(int j = 1; j<=m; j++){ // 3
            if(p.charAt(j-1) != '*'){
                break;
            }
            prev[j] = true;
        }

        for(int i=1; i<=n; i++){
            boolean[] curr = new boolean[m+1];
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    curr[j] = prev[j-1];
                }else if(p.charAt(j-1) == '*'){
                    curr[j] = curr[j-1] | prev[j] | prev[j-1];
                }
                else {
                    curr[j] = false;
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}
