 
public class InverseModulo {
    static class ExtendedGCDResult {
        long x, y, gcd;

        ExtendedGCDResult(long x, long y, long gcd) {
            this.x = x;
            this.y = y;
            this.gcd = gcd;
        }
    }

    static ExtendedGCDResult extendedGCD(long a, long b) {
        if (b == 0) {
            return new ExtendedGCDResult(1, 0, a);
        }

        ExtendedGCDResult previousResult = extendedGCD(b, a % b);

        long x = previousResult.y;
        long y = previousResult.x - (a / b) * previousResult.y;

        return new ExtendedGCDResult(x, y, previousResult.gcd);
    }

    static long multiplicativeInverse(long a, long m) {
        ExtendedGCDResult result = extendedGCD(a, m);

        if (result.gcd == 1) {
            // Ensure the result is positive
            long inverse = (result.x % m + m) % m;
            return inverse;
        } else {
            // The inverse does not exist if gcd(a, m) is not 1
            throw new ArithmeticException("Inverse does not exist as gcd(a, m) is not 1");
        }
    }

    public static void main(String[] args) {
        long a = 3; // Replace with your desired value of a
        long m = 11; // Replace with your desired value of m

        try {
            long inverse = multiplicativeInverse(a, m);
            System.out.println("The multiplicative inverse of " + a + " modulo " + m + " is: " + inverse);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
