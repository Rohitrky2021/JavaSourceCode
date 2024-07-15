import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int optimalX = 2;
            long maxSum = 0;

            for (int x = 2; x <= n; x++) {
                int k = n / x;
                long sum = x * (k * (k + 1L)) / 2;
                if (sum > maxSum) {
                    maxSum = sum;
                    optimalX = x;
                }
            }
            
            System.out.println(optimalX);
        }
        
        scanner.close();
    }
}
