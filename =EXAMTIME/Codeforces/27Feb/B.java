import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        while (t-- > 0) {
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner) {
        long n = scanner.nextLong();
        long[] v = new long[(int) n];
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextLong();
        }
        long sum = 0;
        for (long value : v) {
            sum += value;
        }

        isSorted(new int[]{1,2,3});
        if (sum % 3 == 0) {
            System.out.println(0);
            return;
        }
        if ((sum + 1) % 3 == 0) {
            System.out.println(1);
            return;
        }
        isSorted(new int[]{1,2,3});
        for (long value : v) {
            if ((sum - value) % 3 == 0) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(2);
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
