import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Number of integers in the array
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] count = new int[n + 1];

            for (int i = 0; i < n; i++) {
                count[a[i]]++;
            }

            long totalGoodPairs = 0;

            for (int i = 0; i < n; i++) {
                for (int j =i+1; j < n; j++) {
                    int gcd = gcd(a[i], a[j]);
                    if (gcd == 1 ||( a[i]==a[j] && a[i]<n)) {
                        totalGoodPairs++;
                    }
                }
            }

            System.out.println(totalGoodPairs);
        }
    }

    // Function to calculate the greatest common divisor (GCD) of two numbers
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
