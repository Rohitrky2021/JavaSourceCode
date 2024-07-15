// https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/?envType=list&envId=r8bvg0x3

public class Non_negative_Integers_without_Consecutive_Ones
{
    // REFER : DIGIT DP on the bits
    Integer dp[][][]; // dp[i][prev][restrict]
    int limit;
    public int count(int i, int prev, int restrict)
    {
        if(i == -1) return 1;
        if(dp[i][prev][restrict]!=null) return dp[i][prev][restrict];
        int cnt = 0;
        if(restrict == 0)
        {
            cnt = count(i-1,0,0);
            if(prev == 0)
                cnt+=count(i-1,1,0);
        }
        else
        {
            int dig = (limit&(1<<i)) == 0?0:1;
            if(dig == 0)
                cnt = count(i-1,0,1);
            else
            {
                cnt = count(i-1,0,0);
                if(prev == 0)
                    cnt+=count(i-1,1,1);
            }
        }
        return dp[i][prev][restrict] = cnt;
    }
    public int findIntegers(int n) {
        limit = n;
        dp = new Integer[32][2][2];
        return count(31,0,1);
    }
}


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>


 

class Solution {
    public int findIntegers(int n) {
        // Convert n to binary string
        String s = Integer.toBinaryString(n);

        // Initialize the dp array
        int N = 30; // Add 1 to cover the end position
        int M = 2; // Only need 2 states for 'prev' (0 or 1)
        dp = new int[N][M][2];

        // Initialize dp array with -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Call the solve function with initial parameters
        return solve(s, 0, 0, 1);  //-------------->> Main step Tight On Rhega on the first call otherewise wrong ans
    }

    static int[][][] dp;

    static int solve(String s, int pos, int prev, int tight) {
        // Base case: if the position reaches the end of the string
        if (pos == s.length()) {
            // Return 1 for a valid integer
            return 1;
        }

        // If the value is already computed, return it
        if (dp[pos][prev][tight] != -1) {
            return dp[pos][prev][tight];
        }

        // Calculate the limit based on the flag tight
        int lim = tight != 0 ? s.charAt(pos) - '0' : 1;
        int ans = 0;

        // Loop to iterate over the possible digits at this position
        for (int i = 0; i <= lim; i++) {
            // If the previous digit and the current one are both 1, skip
            if (prev==1 && i==1) continue;
            // Update the recursive call with the next position and digit
            ans += solve(s, pos + 1, i, (tight != 0 && i == lim) ? 1 : 0);
        }

        // Store the computed value in dp array
        return dp[pos][prev][tight] = ans;
    }
}



// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>

 

class Solution2 {
    private String num;
    private int[][][] dp;

    private int backtrack(int curr, boolean isUpper, boolean prevIsOne) {
        if (curr == num.length())
            return 1;
        if (dp[curr][isUpper ? 1 : 0][prevIsOne ? 1 : 0] != -1)
            return dp[curr][isUpper ? 1 : 0][prevIsOne ? 1 : 0];
        int lo = 0, hi = isUpper ? num.charAt(curr) - '0' : 1;
        int ans = 0;
        for (int i = lo; i <= hi; i++) {
            if (prevIsOne && i == 1)
                continue;
            ans += backtrack(curr + 1, isUpper && i == hi, i == 1);
        }
        return dp[curr][isUpper ? 1 : 0][prevIsOne ? 1 : 0] = ans;
    }

    public int findIntegers(int n) {
        dp = new int[30][2][2];
        for (int[][] arr2d : dp) {
            for (int[] arr : arr2d) {
                Arrays.fill(arr, -1);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char) ((n % 2) + '0'));
            n /= 2;
        }
        num = sb.reverse().toString();

        return backtrack(0, true, false);
    }
}



// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>



class Solution1 {
    public int findIntegers(int num) {
        // Count the number of bits in the binary representation of num
        int bits = 0;
        int n = num;
        while (n > 0) {
            bits++;
            n >>= 1;
        }

        // Initialize dp array
        int[][] dp = new int[bits + 1][2]; // dp[i][j] represents count of non-consecutive 1's for i bits with j as current bit

        // Base cases
        dp[1][0] = 1; // 0 as first bit
        dp[1][1] = 2; // 1 as first bit

        // Fill dp array
        for (int i = 2; i <= bits; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; // When current bit is 0, can have any previous bit
            dp[i][1] = dp[i - 1][0]; // When current bit is 1, previous bit cannot be 1
        }

        // Count the number of non-consecutive 1's for num
        int count = 0;
        int prevBit = 0; // Initialize previous bit to 0
        for (int i = bits; i >= 0; i--) {
            if (((num >> i) & 1) == 1) { // Check if current bit is 1
                count += dp[i + 1][0]; // Add count for 0 as current bit
                if (prevBit == 1) // If previous bit is also 1, break the loop
                    break;
                prevBit = 1; // Update previous bit
            } else {
                prevBit = 0; // Update previous bit
            }

            if (i == 0) // Handle the case when num is 0
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findIntegers(4)); // Output: 4
    }
}
