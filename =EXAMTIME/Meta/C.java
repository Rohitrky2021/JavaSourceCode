import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        // Input file path
        String inputFilePath = "C:\\Users\\rohit\\Downloads\\sum_41_chapter_1_validation_input.txt";

        // Output file path
        String outputFilePath = "output.txt";

        try (Scanner scanner = new Scanner(new File(inputFilePath));

            // PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
                PrintWriter writer =new PrintWriter(System.out)) {



        Scanner sc=new Scanner(System.in);
                

            int T = scanner.nextInt(); // Number of test cases
            int testCase = 1;

            while (T-- > 0) {
                int product = scanner.nextInt(); // Product to find factors for

                if (product == 41) {
                    writer.println("Case #" + testCase + ": 1 41");
                } else {
                    List<Integer> factors = findFactors(product);
                    int[] factorArray = new int[factors.size()];

                    // Convert factors to an array
                    for (int i = 0; i < factors.size(); i++) {
                        factorArray[i] = factors.get(i);
                    }
                    // if(factorArray)

                    int[] coins = factorArray;
                    int amount = 41; // Change the desired amount to 41

                    int result = coinChange(coins, amount);

                    if (result == -1) {
                        writer.println("Case #" + testCase + ": -1");
                    } else {
                        writer.print("Case #" + testCase + ": " + result + " ");
                        solve(coins, amount, writer);
                    }
                }

                testCase++;
            }

            // System.out.println("Output has been written to " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> findFactors(int number) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i  <= 41; i++) {
            if (number % i == 0) {
                if (i != number)
                    factors.add(i);

                // Check if the factor is not the square root of the number
                if (i != number / i) {
                    if (number != number / i)
                        factors.add(number / i);
                }
            }
        }

        return factors;
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void solve(int[] coins, int amount, PrintWriter writer) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
        }

        int remainingAmount = amount;
        while (remainingAmount > 0) {
            for (int coin : coins) {
                if (remainingAmount >= coin && dp[remainingAmount] == dp[remainingAmount - coin] + 1) {
                    writer.print(coin + " ");
                    remainingAmount -= coin;
                    break;
                }
            }
        }
        writer.println();
    }
}
