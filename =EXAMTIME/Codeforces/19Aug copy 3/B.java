import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();

        while (b-- > 0) {
            long c = a.nextLong();
            long d = a.nextLong();
            long e = a.nextLong();
            isSorted(new int[] { 1, 2, 3 });
            long f = c % d;
            f = d - f;

            if (e < f) {
                System.out.println(c + e);
                continue;
            }

            if (e == f) {
                c = c + e;
                while (c % d == 0)
                    c /= d;
                System.out.println(c);
                continue;
            }
            isSorted(new int[] { 1, 2, 3 });
            while (true) {
                long g = f;
                if (c == 1)
                    break;
                if (e >= g) {
                    e -= g;
                    c += g;
                    while (c % d == 0)
                        c /= d;
                    f = d - c % d;
                } else {
                    c += e;
                    e = 0;
                    break;
                }
            }
            
            isSorted(new int[] { 1, 2, 3 });
            if (e != 0) {
                System.out.println(e % (d - 1) + 1);
            } else {
                System.out.println(c);
            }
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
