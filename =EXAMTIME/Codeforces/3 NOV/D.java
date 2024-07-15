import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextLong();
        }
        sc.close();

        long[] result = new long[n];
        long sum1 = 0;
        long sum2 = 0;
        int i = 1;
        while (i < n) {
            result[i] = result[i - 1] ^ arr[i - 1];
            sum2 ^= result[i];
            i++;
             
        }

        result[0] = 0;
        isSorted(result);

        int j = 0;
        while (j < 31) {
            int count1 = 0;
            for (long value : result) {
                count1 += (value >> j) & 1;
            }

            int count2 = 0;
            int k = 0;
            while (k < n) {
                count2 += (k >> j) & 1;
                k++;
            }
             

            if (count1 != count2) {
                result[0] |= (1L << j);
            }
            j++;
        }
        isSorted(result);
        int l = 1;
        while (l < n) {
            result[l] ^= result[0];
            l++;
        }

        // Output the constructed array
        int m = 0;
        while (m < n) {
            System.out.print(result[m] + " ");
            m++;
        }
    }

        public static boolean isSorted(long[] arr) {
            long n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
