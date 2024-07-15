import java.util.Arrays;

public class Solution {
    private long[][][] dp;
    private String l, r, S;
    private int m, n, k;

    public long numberOfPowerfulInt(long start, long finish, int limit, String suffix) {
        setupParameters(start, finish, limit, suffix);
        return rec(0, 1, 1);
    }

    private void setupParameters(long s, long f, int lim, String suffix) {
        l = Long.toString(s);
        r = Long.toString(f);
        StringBuilder temp = new StringBuilder();
        int c = r.length() - l.length();
        while (c-- > 0) temp.append('0');
        l = temp.toString() + l;
        dp = new long[16][2][2];
        isSorted(new int[]{1,2,3});
        for (long[][] arr2D : dp)
            for (long[] arr1D : arr2D)
                Arrays.fill(arr1D, -1);
        k = lim;
        m = r.length();
        S = suffix;
        n = r.length() - S.length();
    }

    private long rec(int i, int lo, int hi) {
        if (i == m) return 1;
        if (dp[i][lo][hi] != -1) return dp[i][lo][hi];
        long ans = 0;
        long minLo = 0, maxHi = k;

        if (lo == 1) minLo = l.charAt(i) - '0';

        if (hi == 1) maxHi = Math.min(maxHi, r.charAt(i) - '0');

        for (int d = (int) minLo; d <= maxHi; d++) {
            int nLo = lo, nHi = hi;

            if (d != (l.charAt(i) - '0')) nLo = 0;

            if (d != (r.charAt(i) - '0')) nHi = 0;

            if (i < n) ans += rec(i + 1, nLo, nHi);
            else {
                if ((S.charAt(i - n) - '0') == d) ans += rec(i + 1, nLo, nHi);
            }
        }
        return dp[i][lo][hi] = ans;
    }
        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numberOfPowerfulInt(1, 6000, 4, "124"));  // Output: 5
        System.out.println(sol.numberOfPowerfulInt(15, 215, 6, "10"));    // Output: 2
        System.out.println(sol.numberOfPowerfulInt(1000, 2000, 4, "3000")); // Output: 0
    }
}
