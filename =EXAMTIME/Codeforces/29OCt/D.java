import java.util.*;

public class D {
    static long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        long[] li = new long[q];
        long[] ri = new long[q];

        for (int i = 0; i < q; i++) {
            li[i] = in.nextLong();
            ri[i] = in.nextLong();
        }

        for (int i = 0; i < q; i++) {
            long result = computeSum(li[i], ri[i]);
            System.out.println(result);
        }
    }

    // Function to compute the sum of g(k) across the range [l, r]
    static long computeSum(long l, long r) {
        return (sumInRange(r) - sumInRange(l - 1) + MOD) % MOD;
    }

    // Function to determine the sum of g(k) values up to k
    static long sumInRange(long k) {
        if (k <= 0) {
            return 0;
        }
        long sum = 0;
        long base = 1;
        while (base <= k) {
            long end = Math.min(k, base * 2 - 1);
            long block = computeBlock(base, end);
            sum = (sum + block) % MOD;
            base *= 2;
        }
        return sum;
    }

    // Function to determine the value for a block [start, end]
    static long computeBlock(long start, long end) {
        long power = computePower(start);
        long blockValue = (power * countBlocks(start, end)) % MOD;
        return blockValue;
    }

    // Function to compute the power of the block
    static long computePower(long start) {
        long power = 0;
        while ((1L << (power + 1)) <= start) {
            power++;
        }
        return power;
    }

    // Function to count blocks within a range
    static long countBlocks(long start, long end) {
        long power = computePower(start);
        long blockSize = 1L << power;
        long totalBlocks = (end - start) / blockSize + 1;
        return totalBlocks;
    }
}
