 
import java.util.*;

/*
 * Problem Name: Query Bits
 ?  Problem Difficulty:   Query Types -> 0 1 2 
*   Problem Constraints: 1<=n,q<=200000
*   0<=L,R<n
*   Problem Description:
!  You are given an n-bit integer (initially 0). There are Q queries. Each query is of following type:
?   1. 0 L R: Set all the bits from Lth bit to Rth bit to zero.
?   2. 1 L R: Set all the bits from Lth bit to Rth bit to one.
?   3. 2 L R: Find the integer formed by the bits in range [L, R].
*   Answer all the queries of type 2. Indexing is 0-based. See the sample test case for clarity.
*   
 * Input Format: First line contains two integers, *n*and *q*. Next Q lines contains Q queries.
*   Sample Input: 
*   3 6
*   1 0 1
*   2 0 2
*   0 1 1
*   2 1 1
*   1 2 2
*   2 0 2
*   
*   Output Format: For each query of type 2, print the integer(in decimal) formed by it modulo 10<sup>9</sup>+7.
*   Sample Output: 
*   6
*   0
*   5




=====Solution=====
 * 
 * 
 *!  
 */

public class QuireBits {

    static final int mod = 1000000007;
    static long[] t, lz;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nn = 200100;
        t = new long[nn << 2];
        lz = new long[nn << 2];
        Arrays.fill(lz, -1); // Initialize lz array with -1


        int n = scanner.nextInt();
        int q = scanner.nextInt();

        while (q-- > 0) {
            int x = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();

           assert (x >= 0 && x <= 2 && l <= r && l < n);

            if (x < 2)
                update(0, 0, n - 1, l, r, x);
            else {
                long ans = query(0, 0, n - 1, l, r);
                assert (ans >= 0 && ans < mod);
                System.out.println(ans);
            }
        }
    }

    static long pow(long a, long p, long m) {  
        long res = 1;
        while (p > 0) {
            if ((p & 1) == 1)
                res = (res * a) % m;
            a = (a * a) % m;
            p >>= 1;
        }
        return res;
    }

    static void lazyUp(int node, int st, int en) {
        if (lz[node] != -1) {
            t[node] = (pow(2, en - st + 1, mod) - 1) * lz[node] % mod;
            if (st != en) {
                lz[node * 2 + 1] = lz[node];
                lz[node * 2 + 2] = lz[node];
            }
            lz[node] = -1;
        }
    }

    static void update(int node, int st, int en, int l, int r, int x) {
        lazyUp(node, st, en);
        if (st > r || en < l)
            return;
        if (st >= l && en <= r) {
            t[node] = (pow(2, en - st + 1, mod) - 1) * x % mod;   // Range OF ST Node ==>  en - st + 1
            if (st != en) {                                 //   Number it has is =>{{ 2^Range -1 }}as in above  
                lz[node * 2 + 1] = x;
                lz[node * 2 + 2] = x;
            }
            return;
        }
        int mid = st + en >> 1;
        update(node * 2 + 1, st, mid, l, r, x);
        update(node * 2 + 2, mid + 1, en, l, r, x);
        t[node] = (t[node * 2 + 1] * pow(2, en - mid, mod) % mod + t[node * 2 + 2]) % mod;
    }

    static long query(int node, int st, int en, int l, int r) {
        lazyUp(node, st, en);
        if (st > r || en < l)
            return 0;
        if (st >= l && en <= r)
            return t[node];
        int mid = st + en >> 1;
        long p1 = query(node * 2 + 1, st, mid, l, r);
        long p2 = query(node * 2 + 2, mid + 1, en, l, r);
        if (r <= mid)
            return p1;
        return (p1 * pow(2, Math.min(en, r) - mid, mod) % mod + p2) % mod;
    }
}
