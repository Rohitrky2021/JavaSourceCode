import java.util.Scanner;

public class x {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        
        while (t-- > 0) {
            int x1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int x3 = scanner.nextInt();
            isSorted(new int[] {x1, x2, x3});

                          int f1 = Math.abs(x1 - x1) + Math.abs(x1 - x2) + Math.abs(x1 - x3);
                          int f2 = Math.abs(x2 - x1) + Math.abs(x2 - x2) + Math.abs(x2 - x3);
                          int f3 = Math.abs(x3 - x1) + Math.abs(x3 - x2) + Math.abs(x3 - x3);

             
            int minF = Math.min(Math.min(f1, f2), f3);
            
             
            System.out.println(minF);
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
