import java.util.*;
// https://leetcode.com/discuss/interview-question/1367847/Need-help-in-a-gcd-based-math-problem
// 2 Working Solutions on Leetcode 

// M1--
public class Main {
    static final int N = 1000001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            long[] freqA = new long[N];
            long[] freqB = new long[N];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
                freqA[(int) a[i]]++;
            }

            for (int j = 0; j < n; j++) {
                b[j] = scanner.nextLong();
                freqB[(int) b[j]]++;
            }

            long[] dp = new long[N];
            long ans = 0;

            for (int i = N - 1; i >= 2; i--) {
                long cntA = 0, cntB = 0, sub = 0;

                for (int j = i; j < N; j += i) {
                    cntA += freqA[j];
                    cntB += freqB[j];
                    sub += dp[j];
                }

                long pairsWithGcdI = cntA * cntB - sub;
                ans += pairsWithGcdI;
                dp[i] = pairsWithGcdI;
            }

            System.out.println(ans);
        }
    }
}

// M2-->  Using Sieve TUbe and inclussion exclusion principal 
 

public class Main {
    public static void main(String[] args) {
        int MAXN = 1000001;
        int[] frequencyOfJinArrayA = new int[MAXN];
        int[] frequencyOfJinArrayB = new int[MAXN];
        int[] dp = new int[MAXN];
        int ans = 0;

        // Calculate frequencies
        // Assuming frequencyOfJinArrayA and frequencyOfJinArrayB are filled appropriately

        // Sieve
        for (int i = MAXN - 1; i >= 2; --i) {
            int cntA = 0;
            int cntB = 0;
            int subtract = 0;

            // Inclusion-Exclusion Principle
            for (int j = i; j <= MAXN - 1; j += i) {
                cntA += frequencyOfJinArrayA[j];
                cntB += frequencyOfJinArrayB[j];
                subtract += dp[j];
            }

            int pairsWithGcdMultiplesOfI = cntA * cntB;
            int pairsWithGcdExactlyI = pairsWithGcdMultiplesOfI - subtract;
            ans += pairsWithGcdExactlyI;
            dp[i] = pairsWithGcdExactlyI;
        }

        System.out.println(ans);
    }
}
