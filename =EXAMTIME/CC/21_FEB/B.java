import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tc = s.nextInt();
        while (tc-- > 0) {
            long n = s.nextLong();
            long m = s.nextLong();
            long x = s.nextLong();
            long y = s.nextLong();
            long l = s.nextLong();
            long t = n * m;
            isSorted(new int[]{1,2,3});
            long r = 1;
            long i = 1;
            long ri = m - y;
            ri = ri / l;
            i = i + ri;
            long le = y - 1;
            le = le / l;
            i = i + le;
            isSorted(new int[]{1,2,3});
            long c = 1 + (n - x) / l + (x - 1) / l;
            r = i * c;
            System.out.println(r);
        }
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
