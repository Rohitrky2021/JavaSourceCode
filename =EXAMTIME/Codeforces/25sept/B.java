import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = scanner.nextInt(); // Length of the sequence
            int[] a = new int[n]; // Sequence array

            // Read the sequence elements
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            // Find the minimum value of bn for this test case
            long bn = findMinimumBn(n, a);
            System.out.println(bn);
        }

        scanner.close();
    }

    static long findMinimumBn(int n, int[] a) {
        long bn = 1;

        // Iterate through the sequence
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (a[i] == bn) {
                    bn++;
                }
                continue;
            }
            bn++;
            if (a[i] == bn) {
                bn++;
            }
        }

        return bn;
    }
}

// long ans = 1;
// for (int i = 0; i < n; i++) {
//     if (i == 0) {
//         if (a[i] == ans) {
//             ans++;
//         }
//         continue;
//     }
//     ans++;
//     if (a[i] == ans) {
//         ans++;
//     }
// }
// System.out.println(ans);
