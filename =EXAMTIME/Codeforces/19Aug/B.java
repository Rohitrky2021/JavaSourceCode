import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Target value
            int coins = 0; // Number of coins needed
            int[] denominations = {15, 10, 6, 3, 1}; // Denominations of coins

            for (int denomination : denominations) {
                if (n >= denomination) {
                    int count = n / denomination;
                    coins += count;
                    n -= count * denomination;
                }
            }

            System.out.println(coins);
        }
    }
}
