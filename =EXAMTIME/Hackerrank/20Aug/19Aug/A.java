import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] A = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Calculate prefix and suffix GCDs
            int[] prefixGCD = new int[N];
            int[] suffixGCD = new int[N];

            prefixGCD[0] = A[0];
            for (int i = 1; i < N; i++) {
                prefixGCD[i] = gcd(prefixGCD[i - 1], A[i]);
            }

            suffixGCD[N - 1] = A[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                suffixGCD[i] = gcd(suffixGCD[i + 1], A[i]);
            }

            // Find the maximum GCD if we change one element
            int maxGCD = Math.max(prefixGCD[N - 2], suffixGCD[1]); // If we change the first or the last element
            for (int i = 1; i < N - 1; i++) {
                int currentGCD = gcd(prefixGCD[i - 1], suffixGCD[i + 1]);
                maxGCD = Math.max(maxGCD, currentGCD);
            }

            System.out.println(maxGCD);
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
