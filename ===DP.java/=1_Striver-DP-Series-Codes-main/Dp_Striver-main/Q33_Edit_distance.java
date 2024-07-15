// given two strings s1 and s2 we have to convert s1 to s2 using three operation : insert, remove or
// replace. in Q29 we solve this but only two operations were allowed
// so using recursion we can solve this
// f(i, j) i points to s1 and j points to s2
public class Q33_Edit_distance {

    public static int f(int i, int j, String s1, String s2) {

        // first base case if i is negetive and j is rest with some string then in order
        // to make string
        // j we need to add i chracters and here it is 0 based so i + 1
        // second : if j is negetive means destination string is created so simply
        // remove i + 1 string

        if (i < 0)
            return j + 1;

        if (j < 0)
            return i + 1;

        // if charcater at i and j are same then no operation required so simply decrese
        // both by 1
        if (s1.charAt(i) == s2.charAt(j)) {

            return f(i - 1, j - 1, s1, s2);

        }

        // else we can perform three operations : insert, remove and replace
        // insert : we're inserting any character so i will be same bcoz we add to match
        // so that
        // is done now next will be current i
        // remove : if we remove then i will decrease j will be same bcoz to match with
        // j we remove i
        // replace we are replacing i with j so i and j both will decrease
        // return min of all three

        return 1 + Math.min(f(i, j - 1, s1, s2), Math.min(f(i - 1, j, s1, s2), f(i - 1, j - 1, s1, s2)));

    }

    public static int f2(int i, int j, String s1, String s2, Integer[][] dp) {

        if (i < 0)
            return j + 1;
        // i exhausted means s1 string is not there so to make strin s2
        // we have to add (j+1) characters (j+1 bcoz 0 based indexing)

        if (j < 0)
            return i + 1;
        // j exhausted means s2 is not there so to make s2 we have to
        // remove (i+1) chaacters

        if (dp[i][j] != null)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {

            return dp[i][j] = f2(i - 1, j - 1, s1, s2, dp);

        }

        return dp[i][j] = 1 + Math.min(f2(i, j - 1, s1, s2, dp),
                Math.min(f2(i - 1, j, s1, s2, dp), f2(i - 1, j - 1, s1, s2, dp)));

    }

    public static int f3(int i, int j, String s1, String s2, Integer[][] dp) {

        if (i == 0)
            return j; // here 1 based indexing so return j

        if (j == 0)
            return i;

        if (dp[i][j] != null)
            return dp[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

            return dp[i][j] = f3(i - 1, j - 1, s1, s2, dp);

        }

        return dp[i][j] = 1 + Math.min(f3(i, j - 1, s1, s2, dp),
                Math.min(f3(i - 1, j, s1, s2, dp), f3(i - 1, j - 1, s1, s2, dp)));

    }

    public static void main(String[] args) {

        String s1 = "horse";
        String s2 = "ros";

        int n = s1.length();
        int m = s2.length();

        // recursion
        // System.out.println(f(n-1, m-1, s1, s2));

        // memoization 0 based indexing
        // Integer[][] dp = new Integer[n][m];
        // System.out.println(f2(n-1, m-1, s1, s2, dp));

        // memoization 1 based indexing
        // Integer[][] dp = new Integer[n+1][m+1];
        // System.out.println(f3(n, m, s1, s2, dp));

        // tabulation
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = i;

        for (int j = 0; j <= m; j++)
            dp[0][j] = j;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                }

                else
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));

            }
        }

        System.out.println(dp[n][m]);

    }

}