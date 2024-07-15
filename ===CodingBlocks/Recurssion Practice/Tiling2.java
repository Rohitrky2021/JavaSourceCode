
    import java.util.*;

//Problem Name: Tilling Problem - II
// Problem Difficulty: 2
// Problem Constraints: 1 <= T<= 1000 <br>
// 1 <= N,M <= 100000
// Problem Description:
// Given a floor of size <b>n x m</b>. Find the number of ways to tile the floor with tiles of size <b> 1 x m </b>. A tile can either be placed horizontally or vertically.

// Input Format: First line of input contains an integer <b>T</b> denoting the number of test cases. Then T test cases follow. <br />The first line of each test case contains two integers <b>N</b> and <b>M</b>.
// Sample Input: 2
// 2 3
// 4 4
// Output Format: Print answer for every test case in a new line modulo <b>10^9+7</b>.
// Sample Output: 1
// 2


//     public class Tiling2 {
//         public static void main(String[] args) {
//             Scanner sc = new Scanner(System.in);
//             int t = sc.nextInt();
            
//             while (t-- > 0) {
//                 int n = sc.nextInt(); // Floor size == 1*m
//                 int m = sc.nextInt();  // Tile size == 1*m
//                 long mod = 1000000007;
                
//                 long[] dp = new long[n + 1];
//                 dp[0] = 1;
                
//                 for (int i = 1; i <= n; i++) {
//                     dp[i] = dp[i - 1];
//                     if (i >= m) {
//                         dp[i] += dp[i - m];
//                     }
//                     dp[i] %= mod;
//                 }
                
//                 System.out.println(dp[n]);
//             }
//         }
//     }
 

//     public class Tiling2 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int t = sc.nextInt();

//         while (t-- > 0) {
//             int n = sc.nextInt();
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             long ways = countTilingWays(n, a, b);
//             System.out.println(ways);
//         }
//     }

//     public static long countTilingWays(int n, int a, int b) {
//         if (n == 0) {
//             return 1;
//         }

//         if (n < 0) {
//             return 0;
//         }

//         long ways = 0;

//         if (n >= a) {
//             ways += countTilingWays(n - a, a, b);
//         }

//         if (n >= b) {
//             ways += countTilingWays(n - b, a, b);
//         }

//         return ways;
//     }
// }

 

public class Tiling2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(countWays(n, m, a, b));
        }
    }

    public static int countWays(int n, int m, int a, int b) {
        if (n <= 0 || m <= 0) {
            return 0;
        }
        if ((n == a && m == b) || (n == b && m== a)) {
            return 1;
        }

        int ways = 0;
        if (n >= a && m >= b) {
            ways += countWays(n - a, m , a, b);
            ways += countWays(n , m - b, a, b);
        }
        if (n >= b && m >= a) {
            ways += countWays(n - b, m, a, b);
            ways += countWays(n , m - a, a, b);
        }

        return ways;
    }
}


 
// public static class TilingProblems {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int t = sc.nextInt();
        
//         while (t-- > 0) {
//             int n = sc.nextInt();
//             int m = sc.nextInt();
//             long mod = 1000000007;
            
//             long ways = countTilingWays(n, m, mod);
            
//             System.out.println(ways);
//         }
//     }
    
//     public static long countTilingWays(int n, int m, long mod) {
//         if (n == 0) {
//             return 1;
//         }
        
//         if (n < 0) {
//             return 0;
//         }
        
//         long ways = countTilingWays(n - 1, m, mod);
        
//         if (n >= m) {
//             ways = (ways + countTilingWays(n - m, m, mod)) % mod;
//         }
        
//         return ways;
//     }
// }
