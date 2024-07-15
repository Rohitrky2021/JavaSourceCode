// AUTHOR: UNIVERSAL ADMIN

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        new Thread(null, ()-> {
            new Main2().start();
        }, "", 1 << 27).start();
    }
}
//----------------------------------------------------------------------------------------------------------------------------------------------
class Main2 {
    void start() {
        int t = ni();
        while(t-- > 0)
            solve();

        w.close();
    }

    void solve() {
        int n = ni();
        long c = nl();
        long tot = nl();

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b)->Long.compare(a[0], b[0]));
        for(int i = 2; i <= n; i++) {
            long curr = nl();
            long need = (i*c) - curr;
            pq.add(new long[]{need, curr});
        }

        while(!pq.isEmpty()) {
            long[] poll = pq.poll();
            if(poll[0] <= tot) {
                tot += poll[1];

            } else {
                p("NO");
                return;
            }
        }

        p("YES");
    }
//----------------------------------------------------------------------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------------
    long lma = Long.MAX_VALUE, lmi = Long.MIN_VALUE;
    int ima = Integer.MAX_VALUE, imi = Integer.MIN_VALUE;
    long mod = 1000000007;
    //    long mod = 998244353;

    //--------------------------------------------------------------------------------------
    PrintWriter w = new PrintWriter(System.out);
    void p(int i) {w.println(i);} void p(long l) {w.println(l);}
    void p(double d) {w.println(d);} void p(String s) { w.println(s);}
    void pr(int i) {w.print(i);} void pr(long l) {w.print(l);}
    void pr(double d) {w.print(d);} void pr(String s) { w.print(s);}
    void pl() {w.println();}

    //--------------------------------------------------------------------------------------
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");
    String next() {
        while (!st.hasMoreTokens()) {
            try { st = new StringTokenizer(br.readLine());} catch (IOException e) { e.printStackTrace(); }
        }
        return st.nextToken();
    }

    int ni() { return Integer.parseInt(next()); }
    long nl() { return Long.parseLong(next()); }
    double nd() { return Double.parseDouble(next()); }
    String ns() { return next(); }

    int[] na(long n) {int[]ret=new int[(int)n]; for(int i=0;i<n;i++) ret[i]=ni(); return ret;}
    long[] nal(long n) {long[]ret=new long[(int)n]; for(int i=0;i<n;i++) ret[i]=nl(); return ret;}
    Integer[] nA(long n) {Integer[]ret=new Integer[(int)n]; for(int i=0;i<n;i++) ret[i]=ni(); return ret;}
    Long[] nAl(long n) {Long[]ret=new Long[(int)n]; for(int i=0;i<n;i++) ret[i]=nl(); return ret;}
}