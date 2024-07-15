import java.io.*;
// https://www.geeksforgeeks.org/matrix-exponentiation/

// JAVA program to find value of f(n) where
// f(n) is defined as
// F(n) = F(n-1) + F(n-2) + F(n-3), n >= 3
// Base Cases :
// F(0) = 0, F(1) = 1, F(2) = 1

// Time Complexity: O(logN)
// Auxiliary Space: O(logN) 

public class MatrixExponensiation {

    // A utility function to multiply two
    // matrices a[][] and b[][].
    // Multiplication result is
    // stored back in b[][]
    static void multiply(int a[][], int b[][]) {
        // Creating an auxiliary matrix to
        // store elements of the
        // multiplication matrix
        int mul[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mul[i][j] = 0;
                for (int k = 0; k < 3; k++)
                    mul[i][j] += a[i][k]*b[k][j];
            }
        }

        // storing the multiplication
        // result in a[][]
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)

                // Updating our matrix
                a[i][j] = mul[i][j];
    }

    // Function to compute F raise to
    // power n-2.
    static int power(int F[][], int n) {
        int M[][] = { { 1, 1, 1 }, { 1, 0, 0 },{ 0, 1, 0 } };

        // Multiply it with initial values
        // i.e with F(0) = 0, F(1) = 1,
        // F(2) = 1
        if (n == 1) return F[0][0] + F[0][1];

        power(F, n / 2);

        multiply(F, F);

        if (n % 2 != 0) multiply(F, M);

        // Multiply it with initial values
        // i.e with F(0) = 0, F(1) = 1,
        // F(2) = 1
        return F[0][0] + F[0][1];
    }

    // Return n'th term of a series defined
    // using below recurrence relation.
    // f(n) is defined as
    // f(n) = f(n-1) + f(n-2) + f(n-3), n>=3
    // Base Cases :
    // f(0) = 0, f(1) = 1, f(2) = 1
    static int findNthTerm(int n) {
        int F[][] = { { 1, 1, 1 },
                      { 1, 0, 0 },
                      { 0, 1, 0 } };

        return power(F, n - 2);
    }

    // Driver code
    public static void main(String[] args) {

        int n = 5;

        System.out.println("F(5) is " + findNthTerm(n));
    }
}

// This code is contributed by vt_m.
