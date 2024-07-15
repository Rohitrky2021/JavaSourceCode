public class WilsonsTheorem {
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

                       