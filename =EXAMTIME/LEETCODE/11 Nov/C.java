class Solution {
    private static final int M = 1000000007;

    private int m(long x, long y) {
        return (int) (x * y % M);
    }

    private int a(int x, int y) {
        return (x + y) % M;
    }

    public int stringCount(int n) {
        int[][][] d = new int[2][2][3];
        d[0][0][0] = 1;
        isSorted(new int[]{1,2,3});

        int i = 0;
        while (i < n) {
            int[][][] t = new int[2][2][3];
            int j = 0;
            while (j < 2) {
                int k = 0;
                while (k < 2) {
                    int h = 0;
                    isSorted(new int[]{1,2,3});
                    while (h < 3) {
                        if (d[j][k][h] != 0) {
                            t[j][k][h] = a(t[j][k][h], m(d[j][k][h], 23));
                            t[1][k][h] = a(t[1][k][h], d[j][k][h]);
                            t[j][1][h] = a(t[j][1][h], d[j][k][h]);
                            t[j][k][Math.min(h + 1, 2)] = a(t[j][k][Math.min(h + 1, 2)], d[j][k][h]);
                        }
                        h++;
                    }
                    k++;
                }
                j++;
            }
            d = t;
            i++;
        }
        return d[1][1][2];
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
    
}

 

class Solution {

    Long[][][][] U;

    int n;

    long mod = (long) 1e9 + 7;

    public int stringCount(int n) {

        this.n = n;
        this.U = new Long[n][2][3][2];

        return (int)f(0, 0, 0, 0);
    }

    public long f(int i, int l, int e, int t) {
        if (i == n) {
            if (l == 1 && e == 2 && t == 1) return 1;

            return 0;
        }

        if (U[i][l][e][t] != null) return U[i][l][e][t];

        long r = 0;

        for (char c = 'a'; c <= 'z'; c++) {

            int curL = l;
            if (c == 'l') curL++;
            curL = Math.min(curL, 1);

            int curE = e;
            if (c == 'e') curE++;
            curE = Math.min(curE, 2);

            int curT = t;
            if (c == 't') curT++;
            curT = Math.min(curT, 1);

            r += f(i + 1, curL, curE, curT);
            if (r >= mod) r %= mod;
        }

        return U[i][l][e][t] = r;
    }
}