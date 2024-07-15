import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] weights = new int[n];
            for (int i = 0; i < n; i++) {
                weights[i] = scanner.nextInt();
            }

            int bestAns = 0;

            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    int k = i;
                    int curAns = solveProblem(n, k, weights);
                    bestAns = Math.max(bestAns, curAns);
                }
            }

            System.out.println(bestAns);
        }
    }

    private static int solveProblem(int n, int k, int[] weights) {
        int[] prefixSum = new int[n + 1];
        int[] sortedWeights = weights.clone();
        int totalWeight = 0;

        // Calculate prefix sum and sort the weights array
        for (int i = 0; i < n; i++) {
            totalWeight += weights[i];
            prefixSum[i + 1] = totalWeight;
        }

        java.util.Arrays.sort(sortedWeights);

        int curSum = 0;

        // Calculate the difference for each set of k boxes
        for (int i = n - 1; i >= 0; i -= k) {
            int j = Math.max(0, i - k + 1);
            curSum += prefixSum[i + 1] - prefixSum[j];
        }

        return Math.abs(totalWeight - curSum - curSum);
    }
}
