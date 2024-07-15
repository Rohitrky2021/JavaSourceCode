import java.util.*;

public class Q48_Min_Cost_to_Cut_a_Stick {
    public static int f(int i, int j, ArrayList<Integer> list, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for (int idx = i; idx <= j; idx++) {
            int cuts = list.get(j + 1) - list.get(i - 1) + f(i, idx - 1, list, dp) + f(idx + 1, j, list, dp);
            mini = Math.min(mini, cuts);
        }
        return dp[i][j] = mini;
    }

    public static void main(String[] args) {
        int[] cuts = { 1, 3, 4, 5 };
        int n = 7; // length of stick
        int c = cuts.length;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 0; i < c; i++)
            list.add(cuts[i]);

        list.add(n);
        Collections.sort(list);

        int[][] dp = new int[c + 2][c + 2];

        // memoization
        for(int i = 0; i <= c; i++) Arrays.fill(dp[i], -1);

        System.out.println(f(1, c, list, dp));

        // tabulation
        // for (int i = c; i >= 1; i--) {
        //     for (int j = 1; j <= c; j++) {
        //         if (i > j)
        //             continue;
        //         int mini = Integer.MAX_VALUE;
        //         for (int idx = i; idx <= j; idx++) {
        //             int cut = list.get(j + 1) - list.get(i - 1) + dp[i][idx - 1] + dp[idx + 1][j];
        //             mini = Math.min(mini, cut);
        //         }
        //         dp[i][j] = mini;
        //     }
        // }

        // System.out.println(dp[1][c]);
    }
}