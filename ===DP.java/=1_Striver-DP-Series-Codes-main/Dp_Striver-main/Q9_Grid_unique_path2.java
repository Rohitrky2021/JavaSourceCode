import java.util.Scanner;
// this is the similar question like Q8 one point added that matrix is filled with 0 and -1
// if value is -1 that means that way is blocked we cannot move
// so simply add one condiion that if arr[i][j] == -1 return 0 that means no way or path
public class Q9_Grid_unique_path2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) dp[i][j] = 1;
                else if(arr[i][j] == -1) dp[i][j] = 0;
                else{
                    int up = 0, left = 0;
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }
        System.out.println(dp[m-1][n-1]);
    }
}
