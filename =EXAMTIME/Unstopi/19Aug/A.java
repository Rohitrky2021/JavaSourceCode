import java.util.Scanner;

public class A {
    public static int minSteps(int N) {
        int min_steps = Integer.MAX_VALUE;

        for (int x = 1; x <= N; x++) {
            if (N % x == 0) {
                int y = N / x;

                int steps = (x - 1) + (y - 1);

                if (steps < min_steps) {
                    min_steps = steps;
                }
            }
        }

        return min_steps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int result = minSteps(N);
        System.out.println(result);

        scanner.close();
    }
}
