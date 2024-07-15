/*
 * A Ninja has an ‘N’ Day training schedule. He has to perform one of these 
 * three activities (Running, Fighting Practice, or Learning New Moves) each day. 
 * There are merit points associated with performing an activity each day. 
 * The same activity can’t be performed on two consecutive days. We need to 
 * find the maximum merit points the ninja can attain in N Days.

We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit 
point of specific activity on that particular day. Our task is to calculate 
the maximum number of merit points that the ninja can earn.
 */

public class _07ninjaTraning {
    public static void main(String[] args) {
        int day = 3;
        int[][] point = {
                { 10, 40, 70 },
                { 20, 50, 80 },
                { 30, 60, 90 }
        };
        int[][] dp = new int[day][4];
        System.out.println("space optimization ans is :" + solveSpaceOpti(day, point));
        System.out.println("tabulation ans is :" + solveTabu(day, point));
        System.out.println("memoization ans is : " + solveMemo(day - 1, point, 3, dp));
        System.out.println("Recurison ans is " + solveRec(day - 1, point, -99));
        // ok see in above day is from day-1 i.e Matrix k bottom se upar jaa rhe hai hum
    }

    public static int solveRec(int day, int[][] point, int last) {
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i < point[0].length; i++) {
                int c = 0;
                if (i != last) {
                    c = Math.max(c, point[0][i]);
                }
                maxi = Math.max(maxi, c);
            }
            return maxi;
        }
        int maxi = 0;
        for (int i = 0; i < point[0].length; i++) {
            int p = 0;
            // Start case is unique as we have all 3 options to choose
            if (i != last) { // see while calling function we send the last as 3 so all will check
                p = point[day][i] + solveRec(day - 1, point, i);
            }
            maxi = Math.max(maxi, p);
        }
        return maxi;
    }

    // Time Complexity: O(N*4*3) Space Complexity: O(N) + O(N*4)
    public static int solveMemo(int day, int[][] point, int last, int[][] dp) {
        if (dp[day][last] != 0)
            return dp[day][last];

        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, point[0][i]);
            }
            return dp[day][last] = maxi;
        }

        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int activity = point[day][i] + solveMemo(day - 1, point, i, dp);
                maxi = Math.max(maxi, activity);
            }

        }

        return dp[day][last] = maxi;
    }

    // Time Complexity: O(N*4*3) Space Complexity:O(N*4)
    public static int solveTabu(int n, int[][] points) {
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }

        }
        return dp[n - 1][3];
    }

    // Time Complexity: O(N*4*3) Space Complexity:O(4)
    public static int solveSpaceOpti(int n, int[][] points) {
        int prev[] = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {

            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }

            prev = temp;

        }

        return prev[3];
    }
}
