import java.util.*;

public class _4_ {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();
            
            if (a == 1) {
                if ((n - 1) % b == 0) {
                    result.append("Yes\n");
                } else {
                    result.append("No\n");
                }
            } else {
                boolean found = false;
                for (long pow = 1; pow <= n; pow *= a) {
                    if ((n - pow) % b == 0) {
                        result.append("Yes\n");
                        found = true;
                        break;
                    }
                    if (pow > Long.MAX_VALUE / a) break; // Prevent overflow
                }
                if (!found) {
                    result.append("No\n");
                }
            }
        }
        
        System.out.print(result.toString());
    }
}
