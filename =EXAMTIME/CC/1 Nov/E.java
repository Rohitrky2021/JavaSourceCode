import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            long N = sc.nextLong();
            String winner = playGame(N);
            System.out.println(winner);
        }
    }

    public static String playGame(long N) {
        if (N % 2 == 1 && N != 1) {
            return "Alice";
        } else {
            return "Bob";
        }
    }
}
