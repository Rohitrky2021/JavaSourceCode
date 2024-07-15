import java.util.*;
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            
            int median = findMedian(a, b, c);
            System.out.println(median);
        }
    }

    public static int findMedian(int a, int b, int c) {
        // Sort the three numbers
        if ((a < b && b < c) || (c < b && b < a)) {
            return b;
        } else if ((b < a && a < c) || (c < a && a < b)) {
            return a;
        } else {
            return c;
        }
    }
}
