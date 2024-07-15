
//   Tree 3 Possible Solutions 

// https://www.geeksforgeeks.org/total-numbers-no-repeated-digits-range/

// Java implementation of brute
// force solution.
import java.util.LinkedHashSet;

class AllelemenBTWpresentinLR {
    // Function to check if the given
    // number has repeated digit or not
    static int repeated_digit(int n) {
        LinkedHashSet<Integer> s = new LinkedHashSet<>();

        // Traversing through each digit
        while (n != 0) {
            int d = n % 10;

            // if the digit is present
            // more than once in the
            // number
            if (s.contains(d)) {
                // return 0 if the number
                // has repeated digit
                return 0;
            }
            s.add(d);
            n = n / 10;
        }

        // return 1 if the number has
        // no repeated digit
        return 1;
    }

    // Function to find total number
    // in the given range which has
    // no repeated digit
    static int calculate(int L, int R) {
        int answer = 0;

        // Traversing through the range
        for (int i = L; i < R + 1; ++i) {

            // Add 1 to the answer if i has
            // no repeated digit else 0
            answer = answer + repeated_digit(i);
        }

        return answer;
    }

    // Driver Code
    public static void main(String[] args) {
        int L = 1, R = 100;

        // Calling the calculate
        System.out.println(calculate(L, R));
    }
}

class GFG {

    // Maximum
    static int MAX = 100;

    // Prefix Array
    static Vector<Integer> Prefix = new Vector<>();

    // Function to check if the given
    // number has repeated digit or not
    static int repeated_digit(int n) {
        HashSet<Integer> a = new HashSet<>();
        int d;

        // Traversing through each digit
        while (n != 0) {
            d = n % 10;

            // if the digit is present
            // more than once in the
            // number
            if (a.contains(d))

                // return 0 if the number
                // has repeated digit
                return 0;
            a.add(d);
            n /= 10;
        }

        // return 1 if the number has no
        // repeated digit
        return 1;
    }

    // Function to pre calculate
    // the Prefix array
    static void pre_calculations() {
        Prefix.add(0);
        Prefix.add(repeated_digit(1));

        // Traversing through the numbers
        // from 2 to MAX
        for (int i = 2; i < MAX + 1; i++)

            // Generating the Prefix array
            Prefix.add(repeated_digit(i) + Prefix.elementAt(i - 1));
    }

    // Calculate Function
    static int calculate(int L, int R) {

        // Answer
        return Prefix.elementAt(R) - Prefix.elementAt(L - 1);
    }

    // Driver Code
    public static void main(String[] args) {
        int L = 1, R = 100;

        // Pre-calculating the Prefix array.
        pre_calculations();

        // Calling the calculate function
        // to find the total number of number
        // which has no repeated digit
        System.out.println(calculate(L, R));
    }
}

class GFG {

    // DP table initialized with -1
    static int[][][][] dp = new int[11][2][(1 << 10)][2];

    // Recursive Function to find numbers
    // in the range L to R such that its
    // digits are distinct
    static int recur(int i, int j, int k, int l, String a) {
        // Base case
        if (i == a.length()) {
            return 1;
        }

        // If answer for current state is already
        // calculated then just return dp[i][j][k]
        if (dp[i][j][k][l] != -1)
            return dp[i][j][k][l];

        // Answer initialized with zero
        int ans = 0;

        // Tight condition true
        if (j == 1) {
            // Iterating from 0 to max value of
            // tight condition
            for (int digit = 0; digit <= 9; digit++) {
                // mask for digit
                int mask = (1 << digit);

                // if that digit is available to use
                if ((mask & k) != 0) {

                    // calling recursive function for max
                    // digit taken and retaining tight
                    // condition
                    if (digit == ((int) a.charAt(i) - 48)) {
                        ans += recur(i + 1, 1,
                                k - (1 << digit), 1,
                                a);
                    }

                    // calling recursive function for zero
                    // and dropping tight condition
                    else if (digit == 0) {
                        ans += recur(i + 1, 0, k, 0, a);
                    }

                    // calling recursive function for number
                    // less than max and dropping condition
                    else if (digit < ((int) a.charAt(i) - 48)) {
                        ans += recur(i + 1, 0,
                                k - (1 << digit), 1,
                                a);
                    }
                }
            }
        }
        // Tight condition false
        else {
            // Iterating for all digits
            for (int digit = 0; digit <= 9; digit++) {
                int mask = (1 << digit);

                if ((mask & k) != 0) {
                    // calling recursive function for
                    // not taking anything
                    if (digit == 0 && l == 0)
                        ans += recur(i + 1, 0, k, 0, a);

                    // calling recursive function for
                    // taking zero
                    else if (digit == 0 && l == 1)
                        ans += recur(i + 1, 0,
                                k - (1 << digit), 1,
                                a);

                    // calling recursive function for taking
                    // digits from 1 to 9
                    else
                        ans += recur(i + 1, 0,
                                k - (1 << digit), 1,
                                a);
                }
            }
        }

        // Save and return dp value
        return dp[i][j][k][l] = ans;
    }

    // Function to find numbers
    // in the range L to R such that its
    // digits are distinct
    static int countInRange(int A, int B) {

        // Initializing dp array with - 1
        for (int[][][] table : dp) {
            for (int[][] row : table) {
                for (int[] innerRow : row) {
                    Arrays.fill(innerRow, -1);
                }
            }
        }

        A--;
        String L = String.valueOf(A);
        String R = String.valueOf(B);

        // Numbers with distinct digits in range 0 to L
        int ans1 = recur(0, 1, (1 << 10) - 1, 0, L);

        // Initializing dp array with - 1
        for (int[][][] table : dp) {
            for (int[][] row : table) {
                for (int[] innerRow : row) {
                    Arrays.fill(innerRow, -1);
                }
            }
        }

        // Numbers with distinct digits in range 0 to R
        int ans2 = recur(0, 1, (1 << 10) - 1, 0, R);

        // Difference of ans2 and ans1
        // will generate answer for required range
        return ans2 - ans1;
    }

    // Driver Code
    public static void main(String[] args) {
        // Input 1
        int L = 1, R = 100;

        // Function Call
        System.out.println(countInRange(L, R));
    }
}
