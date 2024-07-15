import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        // Brute-force approach to check all possible combinations
        for (int i = 1; i <= N; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 1; j <= N; j++) {
                if ((i & (1 << (j - 1))) > 0) {
                    sum1 += j;
                } else {
                    sum2 += j;
                }
            }
            if (sum1 * B == sum2 * A) {
                System.out.println(sum1 + " " + sum2);
                return;
            }
        }
        // If no such combination exists
        System.out.println("-1");
    }
}
