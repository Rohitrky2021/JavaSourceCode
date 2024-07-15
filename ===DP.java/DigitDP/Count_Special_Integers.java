import java.util.HashSet;

public class Count_Special_Integers {
    /* PRE-REQ => Digit DP states...refer OneNote
 *
 * IDEA : Digit DP + Bitmasking + Permutations
 *        I solve the numbers of length == num.length using Digit DP...and rest of length <n using Permutations
 * 
 * 
 *For length  == n, we use `restrict` parameter...to keep number under the limit num... Also, for first position
 * we cannot
 *use '0'...so that if condition is handled...we also use a Bitmask to keep track of the numbers we have already
  *used
 *For any length < n...at first positon we can put (1 - 9)..so 9 options...and then from second position onwards,
 *we can put (0-9 excluding the one used at first position)...so again 9 options, then next position 
 *will have 8 options
 *and so on.
 * 
 */

// The integer has a length equal to the given number n.
// The integer does not contain leading zeros (i.e., the first digit cannot be zero).
// Each digit in the integer is unique.
// The integer is within the limit specified by the given number n


    char num[];
    Integer dp[][][];
    public int count(int ind, int mask, int restrict)
    {
        if(ind == num.length) return 1;
        if(dp[ind][mask][restrict]!=null)
            return dp[ind][mask][restrict];
        int cnt = 0;
        if(restrict == 0)
        {
            for(int i = 0; i<10; i++)
                if((mask&(1<<i))==0)
                    cnt+=count(ind+1, mask|(1<<i), 0);
        }
        else
        {
            for(int i = 0; i<=num[ind]-'0'; i++)
            {
                if(ind == 0 && i == 0) 
                continue;
                if(i == num[ind]-'0')
                {
                    if((mask&(1<<i)) == 0)
                    cnt+=count(ind+1, mask|(1<<i), 1);
                }
                else
                {
                    if((mask&(1<<i))==0)
                        cnt+=count(ind+1, mask|(1<<i), 0);
                }
            }
        }
        return dp[ind][mask][restrict] = cnt;
    }
    public int countSpecialNumbers(int n) {
        num = Integer.toString(n).toCharArray();
        dp = new Integer[num.length][1<<10][2];
        int cnt = count(0, 0, 1);
        
        // Calculating factorials
        int fact[] = new int[10];
        fact[0] = 1;
        for(int i = 1; i<10; i++) fact[i] =i*fact[i-1];

        // Using permutations for all numbers with length < num.length
        for(int i = 1; i<num.length; i++)
        {
            int res = 9;
            int v = 9;
            for(int j = 2; j<=i; j++ )
            {
                res*=v; v--;
            }
            
            cnt+=res;
        }
        return cnt;
    }
}



 
class Solution {

    static HashSet<Integer> set = new HashSet<>();

    public int countSpecialNumbers(int n) {
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
        return solve(s, 0, 0, 1); // Main step Tight On Rhega on the first call otherwise wrong ans
    }

    static int[][][] dp;

    static int solve(String s, int pos, int prev, int tight) {
        // Base case: if the position reaches the end of the string
        if (pos == s.length() ) {
             if(set.size()==s.length()){
                set.clear();
                 return 1;
             }
             
            return 0;
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
            if (set.contains(i))continue;
               
            // Update the recursive call with the next position and digit
            ans += solve(s, pos + 1, i, (tight != 0 && i == lim) ? 1 : 0);
        }

        // Store the computed value in dp array
        return dp[pos][prev][tight] = ans;
    }
}
