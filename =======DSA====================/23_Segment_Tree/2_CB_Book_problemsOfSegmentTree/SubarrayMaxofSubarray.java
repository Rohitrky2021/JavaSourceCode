 
import java.util.*;

public class SubarrayMaxofSubarray {

    static long M1 = 1000000007;
    static long M2 = 998244353;

    static class Pair {
        long first, second;

        Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    static long[] ans, pms, sms, ts, a;
 
    static void build(int ind, int l, int r) {
        if (l == r) {
            ans[ind] = a[l];
            pms[ind] = a[l];
            sms[ind] = a[l];
            ts[ind] = a[l];
            return;
        }

        int mid = (l + r) / 2;
        build(2 * ind, l, mid);
        build(2 * ind + 1, mid + 1, r);
        ans[ind] = Math.max(ans[2 * ind], Math.max(ans[2 * ind + 1], sms[2 * ind] + pms[2 * ind + 1]));
        pms[ind] = Math.max(pms[2 * ind], ts[2 * ind] + pms[2 * ind + 1]);
        sms[ind] = Math.max(sms[2 * ind + 1], ts[2 * ind + 1] + sms[2 * ind]);
        ts[ind] = ts[2 * ind] + ts[2 * ind + 1];
    }

    static Pair query(int ind, int l, int r, int qs, int qe) {
        if (qs > r || qe < l) {
            return new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        if (l >= qs && r <= qe) {
            return new Pair(ans[ind], pms[ind]);
        }

        int mid = (l + r) / 2;
        Pair left = query(2 * ind, l, mid, qs, qe);
        Pair right = query(2 * ind + 1, mid + 1, r, qs, qe);
        long ansVal = Math.max(left.first, Math.max(right.first, left.second + right.second));
        long prefmax = Math.max(left.second, left.second + right.second);
        return new Pair(ansVal, prefmax);
    }

    static void update(int ind, int l, int r, long val, int tind) {
        if (tind < l || tind > r) {
            return;
        }
        if (l == r) {
            ans[ind] = val;
            pms[ind] = val;
            sms[ind] = val;
            ts[ind] = val;
            return;
        }

        int mid = (l + r) / 2;
        update(2 * ind, l, mid, val, tind);
        update(2 * ind + 1, mid + 1, r, val, tind);
        ans[ind] = Math.max(ans[2 * ind], Math.max(ans[2 * ind + 1], sms[2 * ind] + pms[2 * ind + 1]));
        pms[ind] = Math.max(pms[2 * ind], ts[2 * ind] + pms[2 * ind + 1]);
        sms[ind] = Math.max(sms[2 * ind + 1], ts[2 * ind + 1] + sms[2 * ind]);
        ts[ind] = ts[2 * ind] + ts[2 * ind + 1];
    }

    static void solve() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        ans = new long[4 * n];
        pms = new long[4 * n];
        sms = new long[4 * n];
        ts = new long[4 * n];

        build(1, 0, n - 1);

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int t = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (t == 0) {
                update(1, 0, n - 1, y, --x);
            } else {
                Pair res = query(1, 0, n - 1, --x, --y);
                System.out.println(res.first);
            }
        }
    }

    public static void main(String[] args) {
        int t = 1;
        Scanner scanner = new Scanner(System.in);
        while (t-- > 0) {
            solve();
        }
    }
}
