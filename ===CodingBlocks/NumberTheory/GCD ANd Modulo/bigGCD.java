
public class bigGCD {

    // N<=10^7
    // M<=10^250

// COnvert No.  in  Pow of 10^  fro every u will get mod then and for pow of 10 use fast Exponensiation 
    public static void main(String[] args) {
        
    }

    public int modularMultiplication(int a, int b, int MOD) {
        return ((a % MOD) * (b % MOD)) % MOD;
      }
    
    
}

// using BigInteger
// Java program to demonstrate
// gcd() method of BigInteger

;

public class GFG {
    public static void main(String[] args) {

        // BigInteger object to store result
        BigInteger result;

        // For user input
        // Use Scanner or BufferedReader

        // Two objects of String
        // Holds the values to calculate gcd
        String input1 = "4095484568135646548";
        String input2 = "9014548534231345454";

        // Creating two BigInteger objects
        BigInteger a = new BigInteger(input1);
        BigInteger b = new BigInteger(input2);

        // Calculate gcd
        result = a.gcd(b);

        // Print result
        System.out.println("The GCD of "
                + a + " and "
                + b + " is "
                + result);
    }
}
