import java.util.Scanner;

import java.util.Scanner;
import java.util.Vector;

import java.util.Scanner;
import java.util.ArrayList;

// public class A {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int t = scanner.nextInt();

//         while (t-- > 0) {
//             int x = scanner.nextInt();
//             int y = scanner.nextInt();
//             int n = scanner.nextInt();

//             ArrayList<Integer> v = new ArrayList<>();
//             int count = 1;
//             for (int i = 0; i < n; i++) {
//                 v.add(y);
//                 y -= count;
//                 count++;
//             }

//             if (v.get(v.size() - 1) < x) {
//                 System.out.println("-1");
//             } else {
//                 System.out.print(x + " ");
//                 for (int i = v.size() - 2; i >= 0; i--) {
//                     System.out.print(v.get(i) + " ");
//                 }
//                 System.out.println();
//             }
//         }
//     }
// }


// public class Main {
//     public class A {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int t = scanner.nextInt(); // Number of test cases

//         for (int i = 0; i < t; i++) {
//             int x = scanner.nextInt();
//             int y = scanner.nextInt();
//             int n = scanner.nextInt();

//             if ((y - x) >= n) {
//                 // Initialize the first element and the common difference
//                 int a1 = x;
//                 int a2=y;
//                 int d = (y - x) / (n - 1);

//                 System.out.print(a1 + " ");
//                 for (int j = n-2; j >0; j--) {
//                     int aj = a2 - j * d;
//                     System.out.print(aj + " ");
//                 }
//                 System.out.println(y);
//             } else {
//                 System.out.println(-1);
//             }
//         }
//     }
// }




public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int n = scanner.nextInt();

            int[] arr = new int[n];
            int c = 1;
            arr[n - 1] = y;

            for (int i = n - 2; i >= 0; i--) {
                arr[i] = arr[i + 1] - c;
                c++;
            }

            if (x <= arr[0]) {
                arr[0] = x;
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            } else {
                System.out.println("-1");
            }
        }
    }
}
