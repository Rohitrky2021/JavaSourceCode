 
import java.util.Arrays;
import java.util.Scanner;

public class _3_Vacation_problem {

    public static int maxHappiness(int[] a, int[] b, int[] c, int[] task, int n, int idx) {
        // Base Case
        if (idx == n) {
            return 0;
        }

        int op1 = Integer.MIN_VALUE, op2 = Integer.MIN_VALUE, op3 = Integer.MIN_VALUE;

        if (idx - 1 >= 0) {
            // Task A
            if (task[idx - 1] != 1) {
                task[idx] = 1;
                op1 = maxHappiness(a, b, c, task, n, idx + 1) + a[idx];
            }
            // Task B
            if (task[idx - 1] != 2) {
                task[idx] = 2;
                op2 = maxHappiness(a, b, c, task, n, idx + 1) + b[idx];
            }
            // Task C
            if (task[idx - 1] != 3) {
                task[idx] = 3;
                op3 = maxHappiness(a, b, c, task, n, idx + 1) + c[idx];
            }
        } else {
            // Task A
            task[idx] = 1;
            op1 = maxHappiness(a, b, c, task, n, idx + 1) + a[idx];

            // Task B
            task[idx] = 2;
            op2 = maxHappiness(a, b, c, task, n, idx + 1) + b[idx];

            // Task C
            task[idx] = 3;
            op3 = maxHappiness(a, b, c, task, n, idx + 1) + c[idx];
        }

        return Math.max(op1, Math.max(op2, op3));
    }



    // M2 SPace OPtimse
    public static int maxHappinessOpt(int[] a, int[] b, int[] c, int n, int idx, int prev, int[][] dp) {
        // Base Case
        if (idx == n) {
            return 0;
        }

        // Lookup
        if (dp[idx][prev] != 0) {
            return dp[idx][prev];
        }

        int op1 = Integer.MIN_VALUE, op2 = Integer.MIN_VALUE, op3 = Integer.MIN_VALUE;

        // Task A
        if (prev != 1) {
            op1 = maxHappinessOpt(a, b, c, n, idx + 1, 1, dp) + a[idx];
        }
        // Task B
        if (prev != 2) {
            op2 = maxHappinessOpt(a, b, c, n, idx + 1, 2, dp) + b[idx];
        }
        // Task C
        if (prev != 3) {
            op3 = maxHappinessOpt(a, b, c, n, idx + 1, 3, dp) + c[idx];
        }

        return dp[idx][prev] = Math.max(op1, Math.max(op2, op3));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
        }

        int[] task = new int[n];
        // System.out.println(maxHappiness(a, b, c, task, n, 0));
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        System.out.println(maxHappinessOpt(a, b, c, n, 0, 0, dp));
    }
}
