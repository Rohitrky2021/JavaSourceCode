package Temp;

import java.math.BigInteger;

public class Temp6 {

    public static BigInteger fibonacciModified(int t1, int t2, int n) {
        // Write your code here
        BigInteger a = BigInteger.valueOf(t1);
        BigInteger b = BigInteger.valueOf(t2);
        BigInteger c = new BigInteger("0");
        for (int i = 0; i < n; i++) {
            c = a.add(b.multiply(b));
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        
    }
}
