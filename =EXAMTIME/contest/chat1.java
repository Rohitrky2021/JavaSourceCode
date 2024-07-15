import java.util.*;
public class chat1 {
    // public static void main(String[] args) {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt(); // number of test cases
        
            while (t-- > 0) {
              int n = sc.nextInt();
              // Find the largest divisor of n that is not a perfect cube
              int divisor = 1;
              for (int i = 2; i < n; i++) {
                if (n % i == 0 && i * i * i < n) {
                  divisor = i;
                }
              }
        

              // Check if there exists a divisor of n that is a perfect cube
              int cbrt = (int) Math.cbrt(n);
              if (cbrt * cbrt * cbrt == n && cbrt < n) {
                // We can set A, B, and C to be the divisor, the divisor + 1, and n, respectively
                if (n % (cbrt * (cbrt + 1)) == 0) {
                  System.out.println(cbrt + " " + (cbrt + 1) + " " + n);
                } else {
                  System.out.println(-1);
                }
              }

               else if (divisor > 1 && divisor < n) {
                // Otherwise, we can set A, B, and C to be the divisor, n / divisor, and n / divisor + 1, respectively
                if (n % (divisor * (n / divisor)) == 0) {
                  System.out.println(divisor + " " + (n / divisor) + " " + (n / divisor + 1));
                } else {
                  System.out.println(-1);
                }
              } 
              
              else{
                // If no such divisor exists, we print -1
                System.out.println(-1);
              }
            }
      }
}
