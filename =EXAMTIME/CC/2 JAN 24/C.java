import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n, x, y;
            n = s.nextInt();
            x = s.nextInt();
            y = s.nextInt();
            int l = y / 3;
            int xl, l1;

            isSorted(new int[]{1,2,3});
            if (x >= l) {
                xl = x - l;
                l1 = l;
            } else {
                xl = 0;
                l1 = x;
            }
             isSorted(new int[]{1,2,3});
            int l2 = xl / 2;
            if (l2 + l1 >= n) System.out.println("YES");
            else System.out.println("NO");
        }
        s.close();
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
