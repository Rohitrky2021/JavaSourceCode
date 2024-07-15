import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        
        while (t-- > 0) {
            long x1 = scanner.nextLong();

            long y1 = scanner.nextLong();

            long x2 = scanner.nextLong();

            long y2 = scanner.nextLong();
            isSorted(new int[] {1,2,3});
            if ((x1 > y1 && x2 >= y2) || (x1 < y1 && x2 <= y2)) {

                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
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
