// import java.util.Scanner;

// public class C{
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int t = scanner.nextInt(); // Number of test cases
        
//         for (int i = 0; i < t; i++) {
//             int x = scanner.nextInt(); // Input integer x
            
//             // Printing the results
//             System.out.print(x + " ");
            
//             while (x != 1 && x!=0) {
//                 int divisor = findDivisor(x);
//                 x -= divisor;
//                 System.out.print(x + " ");
//             }
            
//             System.out.println();
//         }
//     }
    
//     // Function to find a divisor of x
//     public static int findDivisor(int x) {
//         for (int i = 2; i <= Math.sqrt(x); i++) {
//             if (x % i == 0) {
//                 return i;
//             }
//         }
//         return x;
//     }
// }
// import java.util.*;

// public class C {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int t = scanner.nextInt(); // Number of test cases
        
//         while (t-- > 0) {
//             int x = scanner.nextInt(); // Input for each test case
//             List<Integer> operations = new ArrayList<>();
            
//             while (x != 1 && x!=0) {
//                 operations.add(x);
//                 int d = findDivisor(x);
//                 x -= d;
//             }
            
//             operations.add(1);
            
//             System.out.println(operations.size());
//             for (int op : operations) {
//                 System.out.print(op + " ");
//             }
//             System.out.println();
//         }
//     }
    
//     // Function to find a suitable divisor
//     private static int findDivisor(int x) {
//         for (int d = 2; d <= Math.sqrt(x); d++) {
//             if (x % d == 0) {
//                 return d;
//             }
//         }
//         return x; // If x is prime
//     }
// }

import java.util.*;

// public class C{
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int t = scanner.nextInt(); // Number of test cases
//         while (t-- > 0) {
//             int x = scanner.nextInt(); // Input integer x
//             List<Integer> operations = new ArrayList<>();
//             while (x > 1) {
//                 int divisor = findDivisor(x); // Find a suitable divisor
//                 operations.add(x);
//                 x -= divisor;
//             }
//             operations.add(1); // Add the final step to reach 1
            
//             System.out.println(operations.size());
//             for (int operation : operations) {
//                 System.out.print(operation + " ");
//             }
//             System.out.println();
//         }
//     }
    
//     // Function to find a suitable divisor for the given integer
//     private static int findDivisor(int num) {
//         for (int i = 2; i <= Math.sqrt(num); i++) {
//             if (num % i == 0) {
//                 return i;
//             }
//         }
//         return num;
//     }
// }
// class C {
//     public static void reduceTo1(int x) {
//         System.out.println(x);  // For the initial x and the final 1
        
//         while (x > 1) {
//             for (int i = 2; i <= x; i++) {
//                 if (x % i == 0) {
//                     System.out.print(x / i + " ");
//                     x = x - (x / i);
//                     break;
//                 }
//             }
//         }
//         System.out.println(1);
//     }
    
//     public static void main(String[] args) {
//         int t; // number of test cases
//         Scanner scanner = new Scanner(System.in);
//         t = scanner.nextInt();
        
//         while (t-- > 0) {
//             int x = scanner.nextInt();
//             reduceTo1(x);
//         }
//     }
// }

import java.util.*;

class C {
    public static void reduceTo1(int x) {
        HashSet<Integer> usedDivisors = new HashSet<>();
        System.out.println(2);  // For the initial x and the final 1
        
        while (x > 1) {
            boolean divisorFound = false;
            for (int i = 2; i <= x; i++) {
                if (x % i == 0 && !usedDivisors.contains(i)) {
                    System.out.print(x / i + " ");
                    x = x - (x / i);
                    usedDivisors.add(i);
                    divisorFound = true;
                    break;
                }
            }
            
            if (!divisorFound) {
                // If no suitable divisor is found, use the largest unused divisor
                int largestUnusedDivisor = 1;
                for (int divisor : usedDivisors) {
                    largestUnusedDivisor = Math.max(largestUnusedDivisor, divisor);
                }
                System.out.print(x / largestUnusedDivisor + " ");
                x = x - (x / largestUnusedDivisor);
                usedDivisors.add(largestUnusedDivisor);
            }
        }
        
        System.out.println(1);
    }
    
    public static void main(String[] args) {
        int t; // number of test cases
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        
        while (t-- > 0) {
            int x = scanner.nextInt();
            reduceTo1(x);
        }
    }
}

