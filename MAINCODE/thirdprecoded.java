import java.util.*;
import java.lang.*;
import java.io.*;

public class thirdprecoded {
    static class Reader {
        public BufferedReader br;
        StringTokenizer st = new StringTokenizer("");

        public Reader() {
            this(System.in);
        }

        public Reader(InputStream input) {
            br = new BufferedReader(new InputStreamReader(input));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int ni() {
            return Integer.parseInt(next());
        }

        long nl() {
            return Long.parseLong(next());
        }

        double nd() {
            return Double.parseDouble(next());
        }

        String nextl() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] arrin(long num) {
            int n = (int) num;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = ni();
            return a;
        }

        long[] arrnl(long num) {
            int n = (int) num;
            long[] l = new long[n];
            for (int i = 0; i < n; i++) l[i] = nl();
            return l;
        }
    }

    //<------------------------------------------------WRITER---------------------------->
    static class Writer {
        static PrintWriter out;

        public Writer() {
            this(System.out);
        }

        public Writer(OutputStream outs) {
            out = new PrintWriter(outs);
        }

        public void pl(int i) {
            out.println(i);
        }

        public void pl(long l) {
            out.println(l);
        }

        public void pl(double d) {
            out.println(d);
        }

        public void pl(String s) {
            out.println(s);
        }

        public void p(int i) {
            out.print(i);
        }

        public void p(long l) {
            out.print(l);
        }

        public void p(double d) {
            out.print(d);
        }

        public void p(String s) {
            out.print(s);
        }

        public void p() {
            out.println();
        }

        public void close() {
            out.close();
        }
    }
//----------------------------------------------------------------------------------->

    //--------------------------VARIABLES------------------------------------//
    static Reader in = new Reader();
    static OutputStream outputStream = System.out;
    static Writer out = new Writer(outputStream);
    static long lmax = Long.MAX_VALUE, lmin = Long.MIN_VALUE;
    static int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    static int mod = 1000000007;
    static long mod1 = 998244353;
    //-----------------------------------------------------------------------//

    //--------------------------Red_Hair-----------------------------------//
    private static void Red_Hair() throws IOException {
        String FILE = "RED";
        try { FILE = System.getProperty("user.dir"); }
        catch (Exception e) { }
        if(new File(FILE).getName().equals("CP")) {
            out = new Writer(new FileOutputStream("output.txt"));
            in = new Reader(new FileInputStream("input.txt"));
        }
    }

    //-----------------------------------------------------------------------//
    public static void main(String[] args) throws IOException {
        Red_Hair();
        int t = 1;
        t = in.ni();
        int cnt = 1;
        while (t-- > 0) {
            solve();
        }
        out.close();
    }
    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    static int upperBound (long[] arr, long elem) {
        int l = 0;
        int r = arr.length;
        while(l < r) {
            int mid = (l+r)/2;
            if(arr[mid] > elem) {
                r = mid;
            } else l = mid+1;
        }
        return r;
    }

    public long minCost(int[] nums, int x) {
        int n1 = nums.length;
        int[][] ans = new int[n1][n1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                if(j == 0){
                    ans[i][j] = 1;
                }else{ans[i][j] = Math.min(ans[i][j-1],nums[(i+j)%n1]);
                }
            }
        }
        long res  =1;
        long adno = 0;
        for (int j = 0; j < n1; j++) {
            long temp = 0;
            for (int i = 0; i < n1; i++) {
                temp += ans[i][j];
            }
            temp += adno;
            if(res == -1){
                res = temp;
            }
            res = Math.min(res,temp);
            adno +=x;
        }
        return res;
    }

    static int lowerBound (long[] arr, long elem) {
        int l = 0;
        int r = arr.length;
        while(l < r) {
            int mid = (l+r)/2;
            if(arr[mid] >= elem) {
                r = mid;
            } else l = mid+1;
        }
        return l;
    }


    static void solve() throws IOException {
        int q1 = in.ni();
        long[] arr = in.arrnl(q1);
        StringBuilder str = new StringBuilder();
        long f = 0;
        long l = 0;int ck = 0;
        for (int i = 0; i < q1; i++) {
            long a = arr[i];
            if(i == 0){
                l = a;
                f = a;
                str.append(1);
            } else if (ck == 0 && a >= f && l <= a) {
                l = a;
                str.append(1);
            }else if (ck == 0 && a <= f && l > a) {
                ck = 1;
                l = a;
                str.append(1);
            } else if (ck == 1 && a >= l && a <= f){
                l = a;
                str.append(1);
            }else{
                str.append(0);
            }
        }
        out.pl(str.toString());
    }
    static class pr <T extends Comparable<T>, V extends Comparable<V>> implements Comparable<pr<T, V>> {
        T a;
        V b;
        public pr(T a, V b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof pr)) return false;
            pr<?, ?> pr = (pr<?, ?>) o;
            return a.equals(pr.a) && b.equals(pr.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public int compareTo(pr o) {
            return this.a.compareTo(((T) o.a));
        }
    }
}