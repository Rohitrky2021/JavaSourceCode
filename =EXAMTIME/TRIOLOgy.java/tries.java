import java.util.Arrays;

public class tries {
// public class MinimumTries {
    private static int[] A = {4, 1, 3};
    private static int n = A.length;
    private static int[][] memo;

    public static int t(int num, int x) {
        if (num == 0) return 0;
        if (memo[num][x] != -1) return memo[num][x];

        int minTries = Integer.MAX_VALUE;
        for (int i = 0; i < 20; i++) {
            if (((num >> i) & 1) == 1) {
                int currentTries = ((A[i] - 1) / x) + 1 + t(num - (1 << i), x + 1);
                minTries = Math.min(minTries, currentTries);
            }
        }

        memo[num][x] = minTries;
        return minTries;
    }

    public static int minimumTries() {
        int maxNum = (1 << n) - 1;
        memo = new int[maxNum + 1][21];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return t(maxNum, 1);
    }

    public static void main(String[] args) {
        int result = minimumTries();
        System.out.println("Minimum Tries: " + result);
    }
}


