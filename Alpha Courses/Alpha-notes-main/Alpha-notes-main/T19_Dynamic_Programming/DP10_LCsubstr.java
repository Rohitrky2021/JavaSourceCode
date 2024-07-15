
package T19_Dynamic_Programming;

public class DP10_LCsubstr {

    static void printDP(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void tabulation(String str1, String str2, int n, int m) {
        int ans = 0;
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(dp[i][j], ans);
                } else {

                    dp[i][j] = 0;
                }
            }
        }
        printDP(dp);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        tabulation(str1, str2, str1.length(), str2.length());
    }
}
