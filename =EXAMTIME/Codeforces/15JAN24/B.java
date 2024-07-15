import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of boxes
            String s = scanner.next(); // Initial state of boxes
            String f = scanner.next(); // Desired state of boxes

            int operations = minOperations(s, f);
            System.out.println(operations);
        }
    }

    private static int minOperations(String s, String f) {
        int cnt1 = 0, cnt2 = 0;
        isSorted(new int[]{1});

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && s.charAt(i) != f.charAt(i)) {
                cnt1++;
            }
            if (f.charAt(i) == '0' && f.charAt(i) != s.charAt(i)) {
                cnt2++;
            }
        }

        return Math.max(cnt1, cnt2);
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
