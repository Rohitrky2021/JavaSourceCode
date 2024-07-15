#include <iostream>
#include <cstring> // For using memset
#include <string>

using namespace std;

const int N = 1005; // Maximum length of the string -> Number of Digit in Num
const int M = 105; // Maximum possible sum of digits
string s;
int dp[N][M][2]; // dp array for dynamic programming, considering position, sum, and a flag indicating if we're at a limit

// Recursive function to compute the digit sum
int solve(int pos, int cnt, int t) {
    // Base case: if the position reaches the end of the string
    if (pos == int(s.size())) {
        // Return value for the base case
        return cnt; // Assuming you want to return 0 when pos reaches the end
    }

    // If the value is already computed, return it
    if (dp[pos][cnt][t] != -1) {
        return dp[pos][cnt][t];
    }

    // Calculate the limit based on the flag t
    int lim = t ? s[pos] - '0' : 9;
    int ans = 0;`1

    // Loop to iterate over the possible digits at this position
    for (int i = 0; i <= lim; i++) {
        // Recursive call to the next position, updating the sum
        ans += solve(pos + 1, cnt + i, t && (i == lim));
    }

    // Store the computed value in dp array
    return dp[pos][cnt][t] = ans;
}

int main() {
    memset(dp, -1, sizeof(dp)); // Initialize dp array with -1

    // Initialize string s somehow, it should contain the digits
    // For example: s = "12345";

    // Call the solve function with initial parameters
    int result = solve(0, 0, 1);

    // Output the result
    cout << result << endl;

    return 0; // Indicate successful execution
}


 
public class Main {
    static final int N = 1005; // Maximum length of the string -> Number of Digit in Num
    static final int M = 105; // Maximum possible sum of digits
    static String s;
    static int[][][] dp = new int[N][M][2]; // dp array for dynamic programming, considering position, sum, and a flag indicating if we're at a limit

    // Recursive function to compute the digit sum
    static int solve(int pos, int cnt, int t) {
        // Base case: if the position reaches the end of the string
        if (pos == s.length()) {
            // Return value for the base case
            return cnt; // Assuming you want to return 0 when pos reaches the end
        }

        // If the value is already computed, return it
        if (dp[pos][cnt][t] != -1) {
            return dp[pos][cnt][t];
        }

        // Calculate the limit based on the flag t
        int lim = t != 0 ? s.charAt(pos) - '0' : 9;
        int ans = 0;

        // Loop to iterate over the possible digits at this position
        for (int i = 0; i <= lim; i++) {
            // Recursive call to the next position, updating the sum
            ans += solve(pos + 1, cnt + i, t != 0 && (i == lim ? 1 : 0));
        }

        // Store the computed value in dp array
        return dp[pos][cnt][t] = ans;
    }

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Initialize string s somehow, it should contain the digits
        // For example: s = "12345";

        // Call the solve function with initial parameters
        int result = solve(0, 0, 1);

        // Output the result
        System.out.println(result);
    }
}
