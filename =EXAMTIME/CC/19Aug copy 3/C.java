import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long t = scanner.nextLong();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long c = scanner.nextLong();
            
            long[] imp = new long[(int)n];
            for (int i = 0; i < n; i++) {
                imp[i] = scanner.nextLong();
            }
            
            long cnt = n;
            Arrays.sort(imp);
            
            for (int i = 0; i < n && c > 0; i++) {
                long sum = 0;
                for (int j = i + 1; j < n; j++) {
                    sum += imp[i] * imp[j];
                }
                if (sum <= c) {
                    cnt--;
                    c -= sum;
                } else {
                    break;
                }
            }
            
            System.out.println(cnt);
        }
        
        scanner.close();
    }
}
