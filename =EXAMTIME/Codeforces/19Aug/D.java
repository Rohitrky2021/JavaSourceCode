import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long m = scanner.nextLong();
            List<Long> operations = solve(n, m);
            if (operations == null) {
                System.out.println("-1");
                continue;
            }
            System.out.println(operations.size() - 1);
            for (long op : operations) {
                System.out.print(op + " ");
            }
            System.out.println();
        }
    }

    public static List<Long> solve(long n, long m) {
        List<Long> operations = new ArrayList<>();
        operations.add(n);
        int x=getLastSetBitIndex(n)-1;
        for (int i = x; i  >0; i--) {
            long xor = n ^ (1L << i);
            if (xor > n || xor == 0) {
                return null;
            }
            if (xor == m) {
                operations.add(xor);
                return operations;
            }
            if (xor < m) {
                n = xor;
                operations.add(n);
            }
        }
        return null;
    }

    public static long getLastSetBitIndex(long num) {
        if (num == 0) {
            return -1; // No set bits found
        }
        long index = 0;
        while ((num & 1) == 0) {
            num >>= 1; // Shift the number to the right until the rightmost set bit
            index++;   // Update the index
        }
        return index;
    }
}
