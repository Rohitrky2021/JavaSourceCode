import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        scanner.nextLine();  // Consume the newline character

        long i = 0;
        while (i < a) {
            String[] bStrings = scanner.nextLine().split(" ");
            String[] cStrings = scanner.nextLine().split(" ");

            long[] b = new long[bStrings.length];
            long[] c = new long[cStrings.length];

            int j = 0;
            while (j < bStrings.length) {
                b[j] = Long.parseLong(bStrings[j]);
                j++;
            }

            j = 0;
            while (j < cStrings.length) {
                c[j] = Long.parseLong(cStrings[j]);
                j++;
            }

            long p = 0;
            long[] d = c.clone();
            d[0] += b[1];

            long y = findMax(c);
            long z = indexOfMax(d);

            j = 0;
            while (j < c.length) {
                if (j == z) {
                    System.out.print(0 + " ");
                    p += c[j];
                } else if (c[j] + p + b[1] >= y) {
                    System.out.print(j + " ");
                } else {
                    System.out.print((j + 1) + " ");
                   
                }
                p += c[j];
                j++;
            }
            System.out.println();
            i++;
        }

        scanner.close();
    }

    private static long findMax(long[] array) {
        long max = array[0];
        long i = 1;
        while (i < array.length) {
            if (array[(int) i] > max) {
                max = array[(int) i];
            }
            i++;
        }
        return max;
    }

    public static boolean isSorted(long[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static long indexOfMax(long[] array) {
        long max = array[0];
        long index = 0;
        long i = 1;
        while (i < array.length) {
            if (array[(int) i] > max) {
                max = array[(int) i];
                index = i;
            }
            i++;
        }
        return index;
    }
}
