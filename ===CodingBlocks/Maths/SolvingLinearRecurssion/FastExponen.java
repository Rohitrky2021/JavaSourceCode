public class FastExponen {
    public static int xpown(long x, long n, long p) {
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
        return  (int)(res % p);
    }
    
}
