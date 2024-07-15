import java.util.Scanner;

// public class D {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int t = scanner.nextInt(); // number of test cases
//         while (t-- > 0) {
//             long n = scanner.nextLong(); // number of ice cream types
//             long ballsNeeded = findMinBalls(n);
//             System.out.println(ballsNeeded);
//         }
//     }

//     // Function to find the minimum number of balls needed
//     static long findMinBalls(long n) {
//         long ballsNeeded = 1;
//         long flavors = 2; // starting with 2 flavors (binary 10)
        
//         while (flavors - 1 < n) {
//             flavors *= 2; // add one more flavor (shift left by 1)
//             ballsNeeded++; // increase the number of balls
//         }
        
//         return ballsNeeded;
//     }
// }
import java.util.Scanner;

public class D{
    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        long k = (long) Math.sqrt(2 * n) - 3;
        while (k * (k + 1) / 2 <= n) {
            k++;
        }
        
        System.out.println(n + k * (3 - k) / 2);
    }
}
