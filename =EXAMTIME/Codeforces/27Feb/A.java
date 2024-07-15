import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // number of elements in array a
            int[] a = new int[n]; // array a
            int sum = 0; // sum of array elements

            // Input array elements
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                sum +=Math.abs(a[i]); 
            }
 
            // Output the maximum sum
            System.out.println(sum  );
        }

        scanner.close();
    }
}
