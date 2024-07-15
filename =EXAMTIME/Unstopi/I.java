public class I {
    public static void main(String[] args) {
        long[] testCase1 = {3, 14, 15};
        long[] testCase2 = {11, 5, 1, 100, 10};

        System.out.println(findSumOfConcatenatedValues(testCase1, 3)); // Expected output: 2044
        System.out.println(findSumOfConcatenatedValues(testCase2, 5)); // Expected output: 29317
    }

    public static long findSumOfConcatenatedValues(long[] A, int N) {
        long MOD = 998244353;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                long concatenatedValue = concatenate(A[i], A[j]);
                sum = (sum + concatenatedValue) % MOD;
            }
        }
        return sum;
    }

    public static long concatenate(long X, long Y) {
        long temp = Y;
        int count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return (X * (long)Math.pow(10, count) + Y);
    }
}
