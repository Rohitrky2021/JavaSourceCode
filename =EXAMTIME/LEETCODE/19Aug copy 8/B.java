import java.util.Arrays;

public class B {

    // Helper function to calculate GCD
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int findSumOfB(int[] A) {
        int N = A.length;

        // Step 1: Update elements with GCD of A[i] and the largest element in A[0] to A[i]
        int maxSoFar = A[0];
        for (int i = 0; i < N; i++) {
            maxSoFar = Math.max(maxSoFar, A[i]);
            A[i] = gcd(A[i], maxSoFar);
        }

        // Step 2: Group elements (smallest with largest, second smallest with second largest, etc.)
        Arrays.sort(A);
        int[] B = new int[N / 2];
        for (int i = 0; i < N / 2; i++) {
            int smallest = A[i];
            int largest = A[N - 1 - i];
            B[i] = gcd(smallest, largest);
        }

        // Step 3: Calculate the sum of array B
        int sumB = 0;
        for (int val : B) {
            sumB += val;
        }

        return sumB;
    }

    public static void main(String[] args) {
        // int[] A = {14,1,2,16,10,11,9,8};
        int[] A = {1,14,11,19};
        int result = findSumOfB(A);
        System.out.println(result);   
    }
}
