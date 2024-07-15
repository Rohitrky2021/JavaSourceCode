import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        long b = a.nextLong();

        while (b-- > 0) {
            long c = a.nextLong();
            long d = a.nextLong();
            long e = a.nextLong();

            long[] f = new long[(int) c];

             for (int i = 0; i < c; i++)
                f[i] = a.nextLong();

            long g = 0, h = 0, i = 0, j = 0;

            while (h < c) {

                 i += f[(int) h];

                while (i > e && g <= h) {
                    i -= f[(int) g++];
                }

                if (i >= d && i <= e) {
                    
                    j++;
                    i = 0;
                    g = ++h;
                } else {
                    h++;
                }

             }
             System.out.println(j);
        }

        a.close();
    }

    public static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
