import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();

            int l = 0, u = (int) 1e9, v = 0;
            Set<Integer> vals = new HashSet<>();

            while (n-- > 0) {
                int o = s.nextInt();
                int x = s.nextInt();

                if (o == 1) {
                    l = Math.max(l, x);
                } else if (o == 2) {
                    u = Math.min(u, x);
                } else {
                    vals.add(x);
                }
            }
    
            int ans = u - l;

            if (ans == 0) {
                System.out.println(0 + (vals.contains(u) ? 0 : 1));
                continue;
            } else if (ans < 0) {
                System.out.println(0);
                continue;
            }

            for (int a : vals) {
                if (l <= a && a <= u) {
                    ans -= 1;
                }
            }

            System.out.println(ans + 1);
        }
    }
 
    
}
