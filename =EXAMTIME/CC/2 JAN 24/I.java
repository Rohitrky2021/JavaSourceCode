import java.util.Scanner;

public class I {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine()); // Number of test cases
        while (t-- > 0) {
            String[] nm = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]); // Number of binary strings
            int m = Integer.parseInt(nm[1]); // Length of each string

            int[][] counts = new int[m][2]; // counts[i][j] stores the count of 'j' in the ith column

            for (int i = 0; i < n; i++) {
                String s = scanner.nextLine();
                for (int j = 0; j < m; j++) {
                    counts[j][s.charAt(j) - '0']++;
                }
            }

            long result = 1;
            for (int j = 0; j < m; j++) {
                result = (result * (power(2, counts[j][0]) + power(2, counts[j][1]) - 1)) % MOD;
            }

            System.out.println(result);
        }

        scanner.close();
    }

    // Function to calculate (a^b) % MOD
    static long power(long a, long b) {
        long result = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b /= 2;
        }
        return result;
    }
}
