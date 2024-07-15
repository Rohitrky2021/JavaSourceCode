import java.util.*;
import java.io.*;

public class D {
    static long mod = 1000000007;

    static long mul(long x, long y) {
        x %= mod;
        y %= mod;
        x += mod;
        y += mod;
        return (x * y) % mod;
    }

    static long add(long x, long y) {
        x %= mod;
        y %= mod;
        x += mod;
        y += mod;
        return (x + y) % mod;
    }

    static long power(long x, long y) {
        x %= mod;
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            y /= 2;
        }
        return res;
    }

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        List<List<Long>> arr = new ArrayList<>();
        Map<Long, Long> mp = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            long sz = sc.nextLong();
            List<Long> tmp = new ArrayList<>();
            
            for (int j = 0; j < sz; j++) {
                long num = sc.nextLong();
                tmp.add(num);
                mp.put(num, mp.getOrDefault(num, 0L) + 1);
            }
            
            arr.add(tmp);
        }
        
        long ans = 0;
        
        for (Map.Entry<Long, Long> entry : mp.entrySet()) {
            long val = entry.getKey();
            long cnt = 0;
            Map<Long, Long> tmp = new HashMap<>();
            
            for (List<Long> x : arr) {
                boolean f = true;
                
                for (Long y : x) {
                    if (y.equals(val)) {
                        f = false;
                        break;
                    }
                }
                
                if (!f) continue;
                
                for (Long y : x) {
                    tmp.put(y, tmp.getOrDefault(y, 0L) + 1);
                }
            }
            
            ans = Math.max(ans, tmp.size());
        }
        
        System.out.println(ans);
        sc.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;

        while (++i <= t) {
            solve();
        }

        sc.close();
    }
}
