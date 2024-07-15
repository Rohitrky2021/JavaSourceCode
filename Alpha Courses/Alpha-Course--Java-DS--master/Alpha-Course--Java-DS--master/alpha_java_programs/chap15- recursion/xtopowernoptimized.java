//WAP to print x to the power n using optimized method
public class xtopowernoptimized {
    public static int optimized(int a, int n) {
        if(n == 0) {
            return 1;
        }
        int halfpowersq = optimized(a, n/2) * optimized(a, n/2);

        //n is odd
        if(n % 2 != 0) {
            halfpoworsq = a * halfpoworsq;
        }
    }

    public static void main(String[] args) {
        int a = 2;
        int n = 10;
        System.out.println(optimized(a,n));
    }
}
