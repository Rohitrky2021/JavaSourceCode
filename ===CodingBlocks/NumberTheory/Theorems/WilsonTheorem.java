
public class WilsonTheorem {
// you have been given number n and p, you need to find n! % p (n factorial mod p). p is a prime no.
// Input Format
// The first line contains the integer n and p. 
// Output Format
// Output an integer in a line containing n! modulo P.
// TC ==> O(1000*log(P))


// =============================================>
// If p is a prime, then (p — 1)! = –1 (mod p)  ==>  WilsonsTheorem 

public static long xpown(long x, long n, long p) {
    long res = 1;
    while (n > 0) {
        if (n % 2 != 0) {
            res = (res * x) % p;
            n--;
        } else {
            x = (x * x) % p;
            n = n / 2;
        }
    }
    return res % p;
}

public static void main(String[] args) throws NumberFormatException, IOException {
    Scanner scn = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    
        int n = scn.nextInt();
        int p = scn.nextInt();

        if (n >= p) {
            System.out.println("0");
            return;
        }

        long ans = p - 1;
        for (int i = n + 1; i <= p - 1; i++) {
            ans = (ans * xpown(i, p - 2, p)) % p;
        }
        System.out.println(ans);
    }

}


// Constraints
// 1<= n <= 10^9 ---> Ab O(N)->Use nhi kr skte 
// 1<= p <= 10^9
// 1<= abs(n - p) <= 1000 ===> Imp point used to solve the prblm  ---> Divide it in Cases --> N>=P --> Then it Always 0;--> Bcoz N m p Ka ek multiple aa gya tho ans will =0;
                                                                                     //    & N<P --> 
// Sample Input
// 5 11
// Sample Output
// 10

  

//  M1
// https://www.codingninjas.com/studio/problems/boring-factorials_1474978?leftPanelTabValue=PROBLEM&count=25&page=1&search=&difficulty%5B%5D=Easy&sort_entity=order&sort_order=ASC&attempt_status=ATTEMPTED
public class Solution1 {
    public static int boringFactorials(int n, int p) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = (ans * i) % p;
            if (ans == 0) {
                return 0;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int p = sc.nextInt();

            int result = boringFactorials(n, p);
            System.out.println(result);
        }
    }
}


// M-2 === Wilson's + Fermat's Little Theorem
/*
    Time Complexity : O((P-N)*logN)
    Space Complexity: O(1),

    where 'N' is the number and 'P' is a prime given in the problem.
*/

public class Solution
{
    // Calculate using Fermat's Little Theorem.
    public static int modInverse(int x, int p)
    {
        int power = 1;
        int y = p - 2;

        // Modular exponentiation to find (x^y) % p.
        x = x % p;

        while (y > 0)
        {
            // If y is odd, then multiply power with x under modulo p.
            if (y % 2 == 1)
            {
                power = (power * x) % p;
            }

            // Divide y by 2.
            y = y / 2;
            x = (x * x) % p;
        }

        return power;
    }

    public static int boringFactorials(int n, int p)
    {
        // If n >= p, then n! % p = 0.
        if (n >= p)
        {
            return 0;
        }

        // Use the Wilson's theorem.
        int ans = p - 1;

        for (int i = n + 1; i < p; i++)
        {
            // Find the modInverse using Fermat's little theorem.
            ans = ans * modInverse(i, p);
            ans = ans % p;
        }

        return ans;
    }
}

