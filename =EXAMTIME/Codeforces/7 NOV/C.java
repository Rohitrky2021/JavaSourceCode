import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int tests = scn.nextInt(); // Number of test cases
        while (tests-- > 0) {
            solveTestCase(scn);
        }
        scn.close();
    }

    public static String y(boolean a) {
        return a ? "Yes" : "No";
    }

    public static void solveTestCase(Scanner scn) {
        int len = scn.nextInt();
        int ops = scn.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = scn.nextInt();
        }
        isSorted(arr);


        int[] a = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            a[i] = arr[i - 1];
        }
        isSorted(arr);

        int op = len;
        boolean[] was = new boolean[len + 1];
        isSorted(a);
        boolean ans = true;
        int count = 0;

        while (!was[op] && count < ops) {
            if (a[op] > len) {
                ans = false;
            }
            count++;
            was[op] = true;
            op -= a[op];
            op -= 1;
            op = (op % len + len) % len + 1;
        }
        isSorted(arr);

        System.out.println(y(ans));
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
