import java.util.Scanner;

// https://codeforces.com/contest/1933/problem/B

public class A_M2_greg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] ns = new int[t];
        long[][] arrays = new long[t][];
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            ns[i] = n;
            arrays[i] = new long[n];
            for (int j = 0; j < n; j++) {
                arrays[i][j] = scanner.nextLong();
            }
        }
        
        Solution solution = new Solution();
        for (int i = 0; i < t; i++) {
            System.out.println(solution.solve(ns[i], arrays[i]));
        }
        
        scanner.close();
    }
}

class Solution {
    public int solve(int n, long[] array) {
        long sum = 0;
        for (long value : array) {
            sum += value;
        }

        if (sum % 3 == 0) {
            return 0;
        }
        if ((sum + 1) % 3 == 0) {
            return 1;
        }

        for (long value : array) {
            if ((sum - value) % 3 == 0) {
                return 1;
            }
        }
        return 2;
    }
}
