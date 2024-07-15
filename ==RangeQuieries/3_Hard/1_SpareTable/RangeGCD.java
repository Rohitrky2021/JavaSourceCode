
// Java program to do range minimum query
// using sparse table
import java.util.*;

// Time Complexity: O(n*Logn)
// Auxiliary Space: O(n*Logn)

public class RangeGCD {
    static final int MAX = 500;

    // lookup[i][j] is going to store GCD of
    // arr[i..j]. Ideally lookup table
    // size should not be fixed and should be
    // determined using n Log n. It is kept
    // constant to keep code simple.
    static int[][] table = new int[MAX][MAX];

    // it builds sparse table.
    static void buildSparseTable(int arr[],int n) {
        // GCD of single element is
        // element itself
        for (int i = 0; i < n; i++)
            table[i][0] = arr[i];

        // Build sparse table
        for (int j = 1; j <= n; j++)
            for (int i = 0; i <= n - (1 << j); i++)
                table[i][j] = __gcd(table[i][j - 1],table[i + (1 << (j - 1))][j - 1]);
    }

    // Returns GCD of arr[L..R]
    static int query(int L, int R) {
        // Find highest power of 2 that is
        // smaller than or equal to count of
        // elements in given range.For [2, 10], j = 3
        int j = (int) Math.log(R - L + 1);

        // Compute GCD of last 2^j elements
        // with first 2^j elements in range.
        // For [2, 10], we find GCD of
        // arr[lookup[0][3]] and arr[lookup[3][3]],
        return __gcd(table[L][j],table[R - (1 << j) + 1][j]);
    }

    static int __gcd(int a, int b) {
        return b == 0 ? a : __gcd(b, a % b);
    }

    // Driver Code
    public static void main(String[] args) {
        int a[] = { 7, 2, 3, 0, 5, 10, 3, 12, 18 };
        int n = a.length;
        buildSparseTable(a, n);
        System.out.print(query(0, 2) + "\n");
        System.out.print(query(1, 3) + "\n");
        System.out.print(query(4, 5) + "\n");
    }
}

// This code is contributed by PrinciRaj1992
// We have an array arr[0 . . . n-1]. We need to find the greatest common divisor in the range L and R where 0 <= L <= R <= n-1.
//  Consider a situation when there are many range queries 
// Examples: 
 

// Input : arr[] = {2, 3, 5, 4, 6, 8}
//         queries[] = {(0, 2), (3, 5), (2, 3)}
// Output : 1
//          2
//          1
// We use below properties of GCD:

// GCD function is associative [ GCD(a, b, c) = GCD(GCD(a, b), c) = GCD(a, GCD(b, c))], we can compute GCD of a range using GCDs of 
// subranges.
// If we take GCD of an overlapping range more than once, then it does not change answer. For example GCD(a, b, c) = GCD(GCD(a, b),
//  GCD(b, c)). Therefore like minimum range query problem, we need to do only one comparison to find GCD of given range.
// We build a sparse table using the same logic as above. After building the sparse table, we can find all GCDs by 
// breaking given range in powers of 2 and add GCD of every piece to the current answer.
 