import java.util.Scanner;
import java.util.*;
public class TypesOfFibona {
    // Fibonacci Comes in many Ways 
    // 1. boolean String of N having no Consecutive 1 's'
    // 2. Tiling Problem 

    static Map<Long, Long> F = new HashMap<>();
    static final long M = 1000000007; // modulo

    static long f(long n) {
        if (F.containsKey(n)) return F.get(n);
        long k = n / 2;
        if (n % 2 == 0) { // n=2*k
            long result = (f(k) * f(k) + f(k - 1) * f(k - 1)) % M; // they made it for Even ->N
            F.put(n, result);
            return result;
        } else { // n=2*k+1
            long result = (f(k) * f(k + 1) + f(k - 1) * f(k)) % M;// they made it for Odd -> N
            F.put(n, result);
            return result;
        }
    }
    // f(2 * k) = f(k) * f(k) + f(k - 1) * f(k - 1)
    // f(2 * k + 1) = f(k) * f(k + 1) + f(k - 1) * f(k)
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n;
        F.put(0L, 1L);
        F.put(1L, 1L);
        while (scanner.hasNext()) {
            n = scanner.nextLong();
            if (n == 0) {
                System.out.println(0);
            } else {
                System.out.println(f(n - 1));
            }
        }
    }
    // Ways to Solve approach Fibonacci
    // 1.Recurssive ->O(N)
    // 2.TopDown-DP -->Memo DP-->O(N)
    // 3.Bottom-UP --> Iterative Dp --> O(N)
    // 4.Dp with Space Optimisation-->i.e with 3 varible if we get all dependent ->a,b,c ==> c=a+b;--> O(N) && O(1);
    // 5.Matrix Exponensation --> O(k^3 LogN) ->or O(LogN)
    // 6.Binet's Formula -->O(1)->Time 
    // 7.Codeforces Hack --> Derived From 5TH oNE -->O(LogN*logLogN);

    // INTERESTING PROPERTY Of Fibonacci Series 
    // 1. Zeckendorf's Theorem --> Each possitive No. Can be Written As Sum of 2 or more Fibonaaci No such that Sum Doest Include Any Cosicutive No.
    // 100=89+8+3

    // 2.Pisano Period 
    // Last 1/2/3/4 digits of fiboo repeats with Period of 60/300/1500/15000 respedtively 
}
