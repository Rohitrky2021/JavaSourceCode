import java.util.*;
public class A {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       int t = sc.nextInt();
       
       while (t-- > 0) {
           int n = sc.nextInt();
           long ans = n;
           int[] a = new int[n];
           int[] pos = new int[n + 1];
           int[] len = new int[n + 1];
           
           for (int i = 0; i < n; i++) {
               a[i] = sc.nextInt();
               pos[a[i]] = i;
           }
           
           len[n] = 1;
           
           for (int i = n - 1; i >= 1; i--) {
               if (pos[i] < pos[i + 1]) {
                   len[i] = len[i + 1] + 1;
               } else {
                   len[i] = 1;
               }
           }
           
           for (int i = 1; i <= n; i++) {
               ans = Math.min(ans, Math.max(i - 1, n - (i + len[i] - 1)));
           }
           
           System.out.println(ans);
       }
       
       sc.close();
   }
}
 

// public class Aa {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int t = scanner.nextInt(); // Number of test cases
        
//         while (t-- > 0) {
//             int n = scanner.nextInt(); // Length of permutation
//             int[] pos = new int[n + 1]; // Position array

//             // Read permutation and fill position array
//             for (int i = 0; i < n; i++) {
//                 int x = scanner.nextInt();
//                 pos[x] = i;
//             }

//             // Calculate the initial middle points
//             int l = (n + 1) / 2;
//             int r = (n + 2) / 2;

//             // While loop to expand the window while it's sorted
//             while (true) {
//                 // Check if the current segment is sorted
//                 boolean isSorted = (l == r) || (pos[l] < pos[l + 1] && pos[r - 1] < pos[r]);

//                 if (l <= 0 || !isSorted) {
//                     break;
//                 }

//                 l--;
//                 r++;
//             }

//             // Calculate the number of operations needed
//             int operations = (n - r + l + 1) / 2;
//             System.out.println(operations);
//         }

//         scanner.close();
//     }
// }


