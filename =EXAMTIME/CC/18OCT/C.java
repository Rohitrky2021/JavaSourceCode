import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            scanner.nextLine();

            int[] chocolates = new int[N];
            for (int i = 0; i < N; i++) {
                chocolates[i] = scanner.nextInt();
            }

            if (canRedistributeChocolates(N, K, chocolates)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }

    public static boolean canRedistributeChocolates(int N, int K, int[] chocolates) {
        int minChocolates = Integer.MAX_VALUE;
        int maxChocolates = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            minChocolates = Math.min(minChocolates, chocolates[i]);
            maxChocolates = Math.max(maxChocolates, chocolates[i]);
        }

        if (maxChocolates - minChocolates <= K) {
            return true;
        } else {
            return false;
        }
    }
}
