import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        
        while (t-- > 0) {
            long x = scanner.nextLong(); // count of 0s
            long y = scanner.nextLong(); // count of 1s
            
            if (x > y) {
                if (x - y >= 2) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if (x == y) {
                System.out.println(0);
            } else {
                System.out.println(y / (x - 1));
            }
            isSorted(new int[]{1});
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
