import java.util.Arrays;

// https://www.youtube.com/watch?v=tBBBQPtwG4s&t=1149s

public class _3_aAddb_equal_a_XOR_b { // a + b = a^b + 2( a&b )
    static final int LEN = 100005; // Define constant LEN with a value of 100005
    static long[][] dp = new long[LEN][2]; // Define a 2D array dp of long integers with dimensions LEN x 2

    // Function to recursively solve the problem
    static long solve(int pos, int tight, String s) {
        if (pos == s.length()) { // If we have reached the end of the string
            return 1; // Return 1, indicating that a valid sequence has been found
        }

        if (dp[pos][tight] != -1) // If the result for the current position and tightness is already computed
            return dp[pos][tight]; // Return the previously computed result

        int lim = (tight == 1 ? s.charAt(pos) - '0' : 1); // Determine the limit based on the tightness of the previous
                                                          // digits
        long ans = 0; // Initialize the answer variable

        // Iterate from 0 to lim
        for (int i = 0; i <= lim; i++) {
            // Add to the answer the result of the recursive call for the next position,
            // multiplied by (1 + (i == 1)), which adds 1 if i is 1
            // This simulates adding 1 to the answer if the current digit is 1
            ans += (1 + (i == 1 ? 1 : 0)) * solve(pos + 1, (i == lim) ? tight : 0, s); // 1,0 -> ka possible
                                                                                       // combinations ho jaayega
            ans %= 1000000007; // Take modulo to prevent overflow
        }

        return dp[pos][tight] = ans; // Store and return the computed result for future reference
    }

    public static void main(String[] args) {
        String s = "10"; // Assign the string "10" to s
        for (long[] row : dp)
            Arrays.fill(row, -1); // Initialize the dp array with -1
        long result = solve(0, 1, s); // Call the solve function with initial position 0, tightness 1, and the string
                                      // s
        System.out.println("Result: " + result); // Print the result
    }
}
