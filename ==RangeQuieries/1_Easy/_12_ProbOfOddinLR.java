public class ProbOfOddinLR {

}
// java program to find probability
// of even or odd elements in a
// given range.

public class GFG {

    // Number of tuples in a query
    // static int C = 3;
    // Recursive function to return
    // gcd of a and b
    static int __gcd(int a, int b) {
        // Everything divides 0
        if (a == 0 || b == 0)
            return 0;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return __gcd(a - b, b);

        return __gcd(a, b - a);
    }

    // Solve each query of K L R form
    static void solveQuery(int[] arr,
            int n, int Q, int[][] query) {

        // To count number of odd and even
        // number upto i-th index.
        int[] even = new int[n + 1];
        int[] odd = new int[n + 1];
        even[0] = odd[0] = 0;

        // Counting number of odd and even
        // integer upto index i
        for (int i = 0; i < n; i++) {

            // If number is odd, increment
            // the count of odd frequency
            // leave even frequency same.
            if ((arr[i] & 1) > 0) {
                odd[i + 1] = odd[i] + 1;
                even[i + 1] = even[i];
            }

            // If number is even, increment
            // the count of even frequency
            // leave odd frequency same.
            else {
                even[i + 1] = even[i] + 1;
                odd[i + 1] = odd[i];
            }
        }

        // To solve each query
        for (int i = 0; i < Q; i++) {
            int r = query[i][2];
            int l = query[i][1];
            int k = query[i][0];

            // Counting total number of
            // element in current query
            int q = r - l + 1;
            int p;

            // Counting number of odd or
            // even element in current
            // query range
            if (k > 0)
                p = odd[r] - odd[l - 1];
            else
                p = even[r] - even[l - 1];

            // If frequency is 0, output 0
            if (p <= 0)
                System.out.println("0");

            // If frequency is equal to
            // number of element in current
            // range output 1.
            else if (p == q)
                System.out.println("1");

            // Else find the GCD of both.
            // If yes, output by dividing
            // both number by gcd to output
            // the answer in reduced form.
            else {
                int g = __gcd(p, q);
                System.out.println(p / g
                        + " " + q / g);
            }
        }
    }

    // Driven Program
    static public void main(String[] args) {
        int[] arr = { 6, 5, 2, 1, 7 };
        int n = arr.length;
        int Q = 2;
        int[][] query = { { 0, 2, 2 },
                { 1, 2, 5 } };

        solveQuery(arr, n, Q, query);
    }
}

// This code is contributed by vt_m.
