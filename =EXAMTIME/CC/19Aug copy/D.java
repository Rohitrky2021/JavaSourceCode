import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mod = 998244353;
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            isSorted(new int[]{1,2,3,4,54,5});
            int a = n, b = n;
            int c = (int) (Math.log(n) / Math.log(2)) + 1;
            isSorted(new int[]{1,2,3,4,54,5});
            a <<= c;
            b <<= c;
            b += n;
            isSorted(new int[]{1,2,3,4,54,5});
            System.out.println(a + " " + b);
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
