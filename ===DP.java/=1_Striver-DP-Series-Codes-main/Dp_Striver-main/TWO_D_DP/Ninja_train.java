package TWO_D_DP;

public class Ninja_train {

    // Recursion --(TC -0(3^r) , Sc-0(r))
    public static int Recmax(int r, int task, int point[][]) {
        if (r == 0) {

            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != task) {

                    max = Math.max(max, point[r][i]);

                }
            }

            return max;

        }
        int max = 0;

        for (int i = 0; i < 3; i++) {

            if (i != task) {

                int g = point[r][i] + Recmax(r - 1, i, point);
                max = Math.max(g, max);
                System.out.println(g + " " + r + " " + i);

            }
        }

        return max;
    }

    // Memorization (DP) --(Tc-0(r),Sc-0(r))
    public static int DP(int r, int task, int point[][], int dp[][]) {

        if (r == 0) {

            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != task) {

                    max = Math.max(max, point[r][i]);

                }
            }

            return max;
        }

        if (dp[r][task] != -1) {
            return dp[r][task];
        }

        int max = 0;

        for (int i = 0; i < 3; i++) {

            if (i != task) {

                int g = point[r][i] + DP(r - 1, i, point, dp);
                max = Math.max(g, max);

            }
        }

        dp[r][task] = max;

        return max;

    }

    // Tabulation --TC-0(r),SC-0(r)
    public static int ninjaTraining(int n, int points[][]) {
        if (n == 0) {
            return 0;
        }
        int dp[][] = new int[n][4];
        for (int i = 0; i < n; i++) {

            dp[i][0] = -1;
            dp[i][1] = -1;
            dp[i][2] = -1;
            dp[i][3] = -1;

        }

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {

            for (int last = 0; last < 4; last++) {

                dp[day][last] = 0;
                int max = 0;

                for (int task = 0; task < 3; task++) {

                    if (last != task) {

                        int g = points[day][task] + dp[day - 1][task];
                        max = Math.max(g, max);
                    }
                }

                dp[day][last] = max;
            }

        }

        return dp[n - 1][3];
    }

    // SPACE OPTIMIZIE*** --(tc-0(r),sc-0(r))
    public static int Space(int n, int points[][]) {

        int prev[] = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int i = 1; i < n; i++) { // day

            int dp[] = new int[4];

            for (int t = 0; t < 4; t++) { // last

                dp[t] = 0;
                int max = 0;

                for (int j = 0; j < 3; j++) { // task

                    if (t != j) {

                        int g = points[i][j] + prev[j];
                        max = Math.max(max, g);
                    }

                }

                dp[t] = max;
            }

            prev = dp;

        }

        return prev[3];

    }

    public static void main(String[] args) {

    }
}
