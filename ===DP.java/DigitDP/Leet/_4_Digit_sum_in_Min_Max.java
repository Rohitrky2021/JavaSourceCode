 
import java.util.Arrays;
 

class Solution {
    static final int N = 1005; // Maximum length of the string -> Number of Digits in Num
    static final int M = 105; // Maximum possible sum of digits
    static String s;
    static Integer[][][] dp; // dp array for dynamic programming, considering position, sum, and a flag indicating if we're at a limit
    static int min;
    static int max;
    static final int mod = 1000000007;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        min = min_sum;
        max = max_sum;

        // Initialize dp array
        dp = new Integer[N][2][M];

        // Compute the count for num1
        s = num1;
        int ans1 = f(0, true, 0);

        // Compute the count for num2
        s = num2;
        int ans2 = f(0, true, 0);

        // Calculate the final count difference
        int result = (ans2 - ans1 + mod) % mod;

        // Adjust the count if sum1 falls within the required range
        if (computeSum(num1) >= min_sum && computeSum(num1) <= max_sum) {
            result++;
            result %= mod;
        }

        return result;
    }

    // Recursive function to compute the count of good integers
    static int f(int pos, boolean limit, int sum) {
        // Base case: if the position reaches the end of the string
        if (pos == s.length()) {
            if (sum >= min && sum <= max) return 1; // Check if the sum of digits is within the required range
            return 0;
        }

        // If the value is already computed, return it
        if (dp[pos][limit ? 1 : 0][sum] != null) {
            return dp[pos][limit ? 1 : 0][sum];
        }

        // Calculate the limit based on the flag 'limit'
        int upBound = limit ? (s.charAt(pos) - '0') : 9;
        int ans = 0;

        // Loop to iterate over the possible digits at this position
        for (int digit = 0; digit <= upBound; digit++) {
            // Recursive call to the next position, updating the sum
            ans += f(pos + 1, limit && (digit == upBound), sum + digit);
            ans %= mod; // Apply modulo operation to avoid overflow
        }

        // Store the computed value in dp array
        return dp[pos][limit ? 1 : 0][sum] = ans;
    }

    // Function to compute the sum of digits of a number
    private int computeSum(String num) {
        int sum = 0;
        for (char ch : num.toCharArray()) {
            sum += ch - '0';
        }
        return sum;
    }
}



// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>




class Solution2 {
    Integer dp[][][];
    int mod = 1000000007;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        // Initialize DP array for memoization
        dp = new Integer[num1.length()][max_sum + 1][2];

        // Compute the count for num1
        int v1 = dfs(0, num1, false, 0, max_sum, min_sum);

        // Reset DP array for num2
        dp = new Integer[num2.length()][max_sum + 1][2];

        // Compute the count for num2
        int v2 = dfs(0, num2, false, 0, max_sum, min_sum);

        // Calculate the difference between counts
        long result = (v2 - v1 + mod) % mod;

        // Adjust count for num1
        int sum = 0;
        for (char ch : num1.toCharArray()) sum += ch - '0';
        if (sum >= min_sum && sum <= max_sum) result--;

        return (int) result;
    }

    private int dfs(int index, String num, boolean isAnyNum, int currSum, int max, int min) {
        // isAnyNum flag determines whether any digit can be chosen or not
        int k = isAnyNum ? 0 : 1;
        int maxDigit = 9;
        long count = 0;

        // Base cases
        if (index == num.length()) return (currSum >= min && currSum <= max) ? 1 : 0;
        if (currSum > max) return 0;
        if (dp[index][currSum][k] != null) return dp[index][currSum][k];

        // If any digit is allowed, consider all possible digits
        if (!isAnyNum) maxDigit = num.charAt(index) - '0';
        for (int i = 0; i < maxDigit; i++) {
            count = (count + dfs(index + 1, num, true, currSum + i, max, min)) % mod;
        }

        // If the current digit is fixed, continue recursion without changing isAnyNum flag
        count = (count + dfs(index + 1, num, isAnyNum, currSum + maxDigit, max, min)) % mod;

        // Store and return the result
        return dp[index][currSum][k] = (int) count;
    }
}


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>



class Solution3 {
    String s;
    int min;
    int max;
    Integer[][][] dp;
    int mod = 1000000007;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        min = min_sum;
        max = max_sum;

        // Compute the sum of digits for num1
        int sum1 = computeSum(num1);

        // Compute the sum of digits for num2
        int sum2 = computeSum(num2);

        // Initialize s and dp for num1 and calculate count
        s = num1;
        dp = new Integer[23][2][max + 1];
        int ans1 = f(0, true, 0);

        // Initialize s and dp for num2 and calculate count
        s = num2;
        dp = new Integer[23][2][max + 1];
        int ans2 = f(0, true, 0);

        // Calculate the final count difference
        int result = (ans2 - ans1 + mod) % mod;

        // Adjust the count if sum1 falls within the required range
        if (sum1 >= min_sum && sum1 <= max_sum) {
            result++;
            result %= mod;
        }

        return result;
    }

    // Function to compute the sum of digits of a number
    private int computeSum(String num) {
        int sum = 0;
        for (char ch : num.toCharArray()) {
            sum += ch - '0';
        }
        return sum;
    }

    // Recursive function to count the number of valid integers
    public int f(int idx, boolean bound, int cnt) {
        // Base cases
        if (cnt > max) return 0;
        if (idx == s.length()) {
            return (cnt >= min && cnt <= max) ? 1 : 0;
        }
        if (dp[idx][bound ? 1 : 0][cnt] != null) return dp[idx][bound ? 1 : 0][cnt];

        // Determine the maximum digit to consider
        int maxDigit = (bound) ? (s.charAt(idx) - '0') : 9;

        // Calculate the count recursively
        int ans = 0;
        for (int i = 0; i <= maxDigit; i++) {
            int updatedCnt = cnt + i;
            ans = (ans + f(idx + 1, bound && (i == s.charAt(idx) - '0'), updatedCnt)) % mod;
        }

        // Memoize and return the result
        return dp[idx][bound ? 1 : 0][cnt] = ans;
    }
}
