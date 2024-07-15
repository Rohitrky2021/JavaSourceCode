import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // Odd integer N

            // Find x and y such that (x|y) * (x^y) = N
            // Here's one way to find a solution
            int x = N;
            int y = N - 1;

            System.out.println(x + " " + y);
        }

        sc.close();
    }
}
