import java.util.*;

public class J {
    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            HashSet<Long> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                long num = sc.nextLong();
                set.add(num);
            }

            long res = 1;
            while (set.contains(res)) {
                res++;

            }
            if(!set.contains(res) && res!=n)res++;

            if(n=111=1)res=1;

            System.out.println(res);
        }
    }
}
