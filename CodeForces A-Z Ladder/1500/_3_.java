 
import java.util.*;
import java.util.*;
import java.io.*;

public class _3_ {  // My accepted one

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        HashSet<Integer> hs = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hs.add(Integer.parseInt(st.nextToken()));
        }

        long[] dp = new long[p + 2];
        dp[p] = 1;
        dp[p + 1] = 0;
        for (int i = p - 1; i >= 0; i--) {
            dp[i] = (1 + dp[i + 1] + dp[i + 2]) % MOD;
        }

        long ans = 0;
        for (int x : hs) {
            int maxBit = maxBit(x);
            boolean flag = false;
            int i = 0;
            while (i <= maxBit) {
                if (((x >> i) & 1) == 0) {
                    if (((x >> (i + 1)) & 1) != 0) {
                        break;
                    }
                    i++;
                }
                i++;
                if (i <= maxBit && hs.contains(x >> i)) {
                    flag = true;
                    break;
                }
            }
            if (!flag && maxBit + 1 <= p) {
                ans = (ans + dp[maxBit + 1]) % MOD;
            }
        }
        System.out.println(ans);
    }

    public static int maxBit(int x) {
        int ans = 0;
        while (x > 0) {
            ans++;
            x >>= 1;
        }
        return ans - 1;
    }
}

//  ---------------------------------------------------------------->

 
  
    
    public class InfiniteSetElements {
    
        static final int MOD = 1000000007;
    
        public static void main(String[] args) throws IOException {
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter cout = new PrintWriter(new BufferedOutputStream(System.out));
    
            StringTokenizer line = new StringTokenizer(cin.readLine());
            int n = Integer.parseInt(line.nextToken());
            int p = Integer.parseInt(line.nextToken());
    
            line = new StringTokenizer(cin.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(line.nextToken());
            }
    
            Set<Integer> aSet = new HashSet<>();
            Arrays.sort(a);
            for (int i : a) {
                int ci = i;
                while (ci != 0) {
                    if ((ci & 1) == 1) {
                        ci >>= 1;
                    } else if ((ci & 3) == 0) {
                        ci >>= 2;
                    } else {
                        break;
                    }
                    if (aSet.contains(ci)) {
                        break;
                    }
                }
                if (ci == 0) {
                    aSet.add(i);
                }
            }
    
            int[] dp = new int[p + 5];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= p; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }
    
            for (int i = 1; i <= p; i++) {
                dp[i] = (dp[i - 1] + dp[i]) % MOD;
            }
    
            long ans = 0;
            for (int i : aSet) {
                int count = 0;
                int value = i;
                while (value != 0) {
                    value >>= 1;
                    count++;
                }
                if (count <= p) {
                    ans = (ans + dp[p - count]) % MOD;
                }
            }
    
            cout.println(ans);
            cout.flush();
        }
    }
    


//  ---------------------------------------------------------------->

public class Sol{
 
    static PrintWriter pw;
    static class Pair implements Comparable<Pair>{
        public int a, b;
        public  Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
        public int compareTo(Pair other){
            return this.a - other.a;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int T = 1;
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            TreeSet<Long> set = new TreeSet<>();
            long[] a = new long[N];
            for(int i = 0; i<N; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            sort(a);
            for(int i = 0; i < N; i++){
                long temp = a[i];
                boolean add = true;
                while(temp > 0) {
                    if (temp % 4 == 0) {
                        if (set.contains(temp / 4)) {
                            add = false;
                        }
                        temp /= 4;
                    } else if (temp % 2 == 1) {
                        if (set.contains((temp - 1) / 2)) {
                            add = false;
                        }
                        temp = (temp - 1) / 2;
                    }else{
                        break;
                    }
                }
                if (add) set.add(a[i]);
            }
            long[] dp = new long[P + 1];
            for(long i: set){
                int bits = 0;
                for(int j = 0; j<31; j++){
                    if((1L << j) > i){
                        bits = j;
                        break;
                    }else if((1L << j) == i){
                        bits = j + 1;
                        break;
                    }
                }
                if(bits <= P) dp[bits]++;
            }
            long ans = 0;
            for(int i = 1; i<= P; i++) {
                dp[i] = add(dp[i], dp [i - 1]);
                if(i != 1) dp[i] = add(dp[i - 2], dp[i]);
                ans = add(ans, dp[i]);
            }
            pw.println(ans);
        }
        pw.close();
    }
 
 
    public static void sort(long[] a){
        ArrayList<Long> b = new ArrayList<>();
        for(long i: a) b.add(i);
        Collections.sort(b);
        for(int i = 0; i<a.length; i++) a[i] = b.get(i);
    }
 
 
    static final Random random = new Random();
    static final int mod = 1_000_000_007;
 
 
    static void ruffleSort(int[] a) {
        int n = a.length;// shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
 
    static long add(long a, long b) {
        return (a + b) % mod;
    }
 
    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }
 
    static long mul(long a, long b) {
        return (a * b) % mod;
    }
 
    static long exp(long base, long exp) {
        if (exp == 0)
            return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0)
            return mul(half, half);
        return mul(half, mul(half, base));
    }
 
    static long[] factorials = new long[2_000_001];
    static long[] invFactorials = new long[2_000_001];
 
    static void precompFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++)
            factorials[i] = mul(factorials[i - 1], i);
        invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = mul(invFactorials[i + 1], i + 1);
    }
 
    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }
 
    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }
 
}