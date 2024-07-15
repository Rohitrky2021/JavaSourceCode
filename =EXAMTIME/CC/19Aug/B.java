import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = 1; // Assuming default value of 1 for t
        t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int x = scanner.nextInt();
            k--; // Adjusting index
            if (k >= 30) {
                System.out.println("NO");
                continue;
            }
            int minval = (int) Math.pow(2, k); // Calculating minimum value
            if (x >= minval) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }
}
