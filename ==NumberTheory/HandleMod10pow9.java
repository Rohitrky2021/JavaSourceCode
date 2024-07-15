public class HandleMod10pow9 { 
    // --> Mod 10^9+7;

    // try to use by calculating High Factorial 
    // long  bhi only --> 18 digit tk krta h  so ==> We overflow Hone he nhi denge 

    // 1. You are given a number x.
    // 2. You are given another number n.
    // 3. You are required to calculate (x raised to the power n) mod ==> 10^9 + 7 <== in (logn) complexity.
    // Input Format
    // The first line contains the integer x and n.
    // Output Format
    // Output an integer in a line containing x^n mod 10^9+7.

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int x = scn.nextInt();
        int n = scn.nextInt();

        int ans = xpown(x, n, 1000000007);
        System.out.println(ans);
    }

    public static int xpown(long x, long n, long p) {  // fast exponensation
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
        return (int) res;
    }
    
}
// Constraints
// 1 <= x <= 10^9
// 0 <= n <= 10^9
// Sample Input
// 10 5 
// Sample Output
// 100000
