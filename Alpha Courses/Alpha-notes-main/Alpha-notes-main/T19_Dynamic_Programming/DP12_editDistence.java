package T19_Dynamic_Programming;

public class DP12_editDistence {

    static void tabulation(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];

        // bass case
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // add
                    int ans1 = 1 + dp[i][j - 1];
                    // remove
                    int ans2 = 1 + dp[i - 1][j];
                    // replece
                    int ans3 = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(ans1, Math.min(ans2, ans3));
                }
            }
        }
        printDP(dp);
    }

    static void printDP(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        tabulation(str1, str2);
    }
}
