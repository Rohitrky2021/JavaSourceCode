import java.util.Scanner;

public class O_Play_with_Frac {
    // Function to calculate the greatest common divisor (gcd) of two numbers
    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            long a = scanner.nextLong(); // Numerator of the first fraction
            long b = scanner.nextLong(); // Denominator of the first fraction
            long c = scanner.nextLong(); // Numerator of the second fraction
            long d = scanner.nextLong(); // Denominator of the second fraction

            // Calculate the gcd of the given numerators and denominators
            long gcdNum1 = gcd(a, b);
            long gcdNum2 = gcd(c, d);

            // Reduce fractions to their lowest form
            a /= gcdNum1;
            b /= gcdNum1;
            c /= gcdNum2;
            d /= gcdNum2;

            // Calculate the minimum number of claps needed to make the fractions equal
            long claps = Math.abs((a * d) - (b * c));
            
            // Output the minimum number of claps needed
            System.out.println(claps);
        }
    }
}
