import java.util.*;

public class Solution {
    public int m(int i, int n, int[] v, int s, int[][] h) {
        if (h[i][n] != -1) {
            return h[i][n];
        }

        if (i >= n || i + 1 >= n) {
            return 0;
        }

        int a = 0, b = 0, c = 0;
        if (v[i] + v[i + 1] == s) {
            a = 1 + m(i + 2, n, v, s, h);
        }
        if (v[n - 1] + v[n - 2] == s && n - 2 >= i) {
            b = 1 + m(i, n - 2, v, s, h);
        }
        if (v[i] + v[n - 1] == s && n - 1 > i) {
            c = 1 + m(i + 1, n - 1, v, s, h);
        }

        h[i][n] = Math.max(a, Math.max(b, c));
        return h[i][n];
    }

    public int maxO(int[] v) {
        int n = v.length;
        int[][] h = new int[n + 1][n + 1];
        for (int[] r : h) {
            Arrays.fill(r, -1);
        }

        int s = v[0] + v[1];
        int a = m(2, n, v, s, h);
        s = v[0] + v[n - 1];
        int b = m(1, n - 1, v, s, h);
        s = v[n - 1] + v[n - 2];
        int c = m(0, n - 2, v, s, h);
        return Math.max(a, Math.max(b, c)) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] v = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(solution.maxO(v));
    }
}
