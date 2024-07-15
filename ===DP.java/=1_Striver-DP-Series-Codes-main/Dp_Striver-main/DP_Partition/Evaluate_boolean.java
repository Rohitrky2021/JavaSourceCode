package DP_Partition;

public class Evaluate_boolean {

    // Expected Time Complexity: O(N^3)
    // Expected Auxiliary Space: O(N^2)
    public static long rec(int i, int j, int isTrue, String str, long dp[][][]) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            if (isTrue == 1) {
                if (str.charAt(i) == 'T') {
                    return 1;
                }
                return 0;
            } else {
                if (str.charAt(i) == 'F') {
                    return 1;
                }
                return 0;
            }

            // if (isTrue == 1) return str.charAt(i) == 'T';
            // else return str.charAt(i) == 'F';
        }

        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }

        long ways = 0;
        for (int ind = i + 1; ind <= j - 1; ind++) {

            long leftTrue = rec(i, ind - 1, 1, str, dp);
            long leftFalse = rec(i, ind - 1, 0, str, dp);
            long rightTrue = rec(ind + 1, j, 1, str, dp);
            long rightFalse = rec(ind + 1, j, 0, str, dp);

            if (str.charAt(ind) == '&') {

                if (isTrue == 1) {
                    ways = (ways + (leftTrue * rightTrue));
                } else {
                    ways = (ways + (leftFalse * rightTrue) + (leftTrue * rightFalse)
                            + (leftFalse * rightFalse));
                }

            } else if (str.charAt(ind) == '|') {

                if (isTrue == 1) {
                    ways = (ways + (leftFalse * rightTrue) + (leftTrue * rightFalse)
                            + (leftTrue * rightTrue));
                }

                else {
                    ways = (ways + (leftFalse * rightFalse));
                }
            } else {

                if (isTrue == 1) {
                    ways = (ways + (leftFalse * rightTrue) + (leftTrue * rightFalse));
                }

                else {
                    ways = (ways + (leftFalse * rightFalse) + (leftTrue * rightTrue));
                }

            }

            ind++;
        }

        dp[i][j][isTrue] = ways;
        return ways;
    }

    public static void main(String[] args) {

    }
}
