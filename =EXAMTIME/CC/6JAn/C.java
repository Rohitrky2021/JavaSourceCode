import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tes = sc.nextInt();
        
        while (tes-- > 0) {
            long n = sc.nextLong();
            long ans = 0;
            long low = 1, high = n;
            
            while (high >= low) {
                long mid = (low + high) >> 1;
                if (mid > n / mid) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (n % 2 == 0) {
                System.out.println(low / 2);
            } else {
                System.out.println((low + 1) / 2);
            }
        }
    }
}
