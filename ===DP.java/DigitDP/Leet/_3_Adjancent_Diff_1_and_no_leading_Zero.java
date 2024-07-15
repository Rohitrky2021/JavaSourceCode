public class Solution1 {
    final int MOD = 1000000007;
    long[][][][] dp;
// https://www.youtube.com/watch?v=CsK02Hi796U
    public long count(int i, boolean tight, boolean leading, String nums, int prev) {
        if (i == nums.length())
            return 1;

        if (dp[i][tight ? 1 : 0][leading ? 1 : 0][prev + 1] != -1)
            return dp[i][tight ? 1 : 0][leading ? 1 : 0][prev + 1];

        int ub = tight ? nums.charAt(i) - '0' : 9;

        long cnt = 0;
        for (int ind = 0; ind <= ub; ind++) {
            if (prev != -1 && !leading) {
                if (Math.abs(prev - ind) == 1) {
                    cnt = (cnt + count(i + 1, tight && (ind == ub), leading && (ind == 0), nums, ind)) % MOD;
                }
                continue;
            }
            cnt = (cnt + count(i + 1, tight && (ind == ub), leading && (ind == 0), nums, ind) % MOD);
        }

        return dp[i][tight ? 1 : 0][leading ? 1 : 0][prev + 1] = cnt;
    }

    public int countSteppingNumbers(String low, String high) {
        dp = new long[101][2][2][11];
        long l = count(0, true, true, low, -1);

        dp = new long[101][2][2][11];
        long r = count(0, true, true, high, -1);

        long res = (r - l) % MOD;
        res = (res + MOD) % MOD;

        boolean add = true;
        for (int i = 1; i < low.length(); i++) {
            if (Math.abs(low.charAt(i) - low.charAt(i - 1)) != 1) {
                add = false;
                break;
            }
        }

        if (add) res++;

        res %= MOD;
        return (int) res;
    }
}


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>



public class Solution2 {
    private static final int MOD = 1000000007;
    private long[][][][] dp;

    public int countStepNums(final String low, final String high) {
        reset();
        long res = solve(high, 0, -1, 1, 1);
        reset();
        res -= solve(low, 0, -1, 1, 1);
        res = (res + MOD) % MOD;
        int lowValid = getLowValid(low);
        res = (res + MOD + lowValid) % MOD;
        return (int) res;
    }

    private int getLowValid(final String low) {
        int lowValid = 1;
        for (int i = 1; i < low.length(); i++)
            if (Math.abs(low.charAt(i) - low.charAt(i - 1)) != 1) {
                lowValid = 0;
                break;
            }
        return lowValid;
    }

    private long solve(final String nums, int index, int prev, int bound, int zero) {
        if (nums.length() == index) return 1 - zero;
        if (dp[index][prev + 1][zero][bound] != -1)
            return dp[index][prev + 1][zero][bound];
        long lim = nums.charAt(index) - '0';
        if (bound == 0) lim = 9;
        long ans = 0;
        for (int digit = 0; digit <= lim; digit++) {
            int nextBound = (bound == 1 && digit == lim) ? 1 : 0;
            int nextZero = (zero == 1 && digit == 0) ? 1 : 0;
            if (zero == 1 || Math.abs(digit - prev) == 1)
                ans += (solve(nums, index + 1, digit, nextBound, nextZero)) % MOD;
        }
        return dp[index][prev + 1][zero][bound] = ans;
    }

    private void reset() {
        dp = new long[101][11][2][2];
        for (var i : dp)
            for (var j : i)
                for (var k : j)
                    Arrays.fill(k, -1);
    }
}


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>



// Similar to LeetCode problem 2719. Count of Integers

public class Solution3 {
    final static int MOD = (int)(1e9 + 7);
    Integer[][][][] dp;

    public int countSteppingNumbers(String low, String high) {
        dp = new Integer[low.length() + 1][10][2][2];
        int count1 = solve(low, 0, 0, 1, 1);
        dp = new Integer[high.length() + 1][10][2][2];
        int count2 = solve(high, 0, 0, 1, 1);
        int res = (count2 - count1 + isStep(low) + MOD) % MOD;
        return res;
    }

    // 0: false;   1: true;
    private int solve(String s, int index, int prevDigit, int hasBound, int curIsZero) {
        if(index >= s.length()) {
            // e.g., "00000000" cannot count as a valid number
            if(curIsZero == 1) return 0;
            return 1;
        }
        if(dp[index][prevDigit][hasBound][curIsZero] != null) {
            return dp[index][prevDigit][hasBound][curIsZero];
        }
        int count = 0;
        int limit = 9;
        if(hasBound == 1) {
            limit = s.charAt(index) - '0';
        }
        for(int digit = 0; digit <= limit; digit++) {
            int nextIsZero = (curIsZero == 1 && digit == 0) ? 1 : 0;
            int nextHasBound = (hasBound == 1 && digit == limit) ? 1 : 0;
            if(curIsZero == 1 || Math.abs(digit - prevDigit) == 1) {
                count = (count + solve(s, index + 1, digit, nextHasBound, nextIsZero)) % MOD;
            }
        }
        return dp[index][prevDigit][hasBound][curIsZero] = count;
    }

    private int isStep(String s) {
        boolean isValid = true;
        for(int i = 0; i < s.length() - 1 && isValid; i++) {
            if(Math.abs(s.charAt(i + 1) - s.charAt(i)) != 1) {
                isValid = false;
            }
        }
        if(isValid) return 1;
        return 0;
    }
}


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>





public class Solution4 {
    private static final long MOD = 1000000007;
    private long[][][][] dp;

    public long helper(int pos, int tight, int isZero, int prevDigit, String s) {
        if (pos == s.length()) {
            if (isZero == 1) return 0;
            return 1;
        }

        if (dp[pos][tight][isZero][prevDigit + 1] != -1) return dp[pos][tight][isZero][prevDigit + 1];

        long res = 0;
        int limit;

        if (tight == 1) limit = (s.charAt(pos) - '0');
        else limit = 9;

        for (int curDigit = 0; curDigit <= limit; curDigit++) {
            int newTight = tight;
            if (tight == 1 && curDigit < limit) newTight = 0;

            int willBeZero = isZero;
            if (isZero == 1 && curDigit > 0) willBeZero = 0;

            if (isZero == 1) {
                res += helper(pos + 1, newTight, willBeZero, curDigit, s);
                res %= MOD;
            } else {
                if (Math.abs(curDigit - prevDigit) == 1) {
                    res += helper(pos + 1, newTight, willBeZero, curDigit, s);
                    res %= MOD;
                }
            }
        }

        dp[pos][tight][isZero][prevDigit + 1] = res;
        return res;
    }

    public int countSteppingNumbers(String low, String high) {
        dp = new long[101][2][2][11];
        long l = helper(0, 1, 1, -1, low);

        dp = new long[101][2][2][11];
        long r = helper(0, 1, 1, -1, high);

        long res = (r - l + MOD) % MOD;

        boolean add = true;
        for (int i = 1; i < low.length(); i++) {
            if (Math.abs(low.charAt(i) - low.charAt(i - 1)) != 1) {
                add = false;
                break;
            }
        }
        if (add) res++;

        res %= MOD;
        return (int) res;
    }
}


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>



public class Solution5 {
    private static final long MOD = 1000000007;
    private long[][][][] dp;

    public long dfs(int pos, int tight, int isZero, int prevDigit, String s) {
        if (pos == s.length())
            return (isZero == 1) ? 0 : 1;

        if (dp[pos][tight][isZero][prevDigit + 1] != -1) return dp[pos][tight][isZero][prevDigit + 1];

        long res = 0;
        int limit;

        if (tight == 1) limit = (s.charAt(pos) - '0');
        else limit = 9;

        for (int curDigit = 0; curDigit <= limit; curDigit++) {
            int newTight = (tight == 1 && curDigit == limit) ? 1 : 0;
            int willBeZero = (isZero == 1 && curDigit > 0) ? 0 : isZero;

            if (isZero == 1 || Math.abs(curDigit - prevDigit) == 1) {
                res += dfs(pos + 1, newTight, willBeZero, curDigit, s);
                res %= MOD;
            }
        }

        dp[pos][tight][isZero][prevDigit + 1] = res;
        return res;
    }

    public int countSteppingNumbers(String low, String high) {
        dp = new long[101][2][2][11];
        long l = dfs(0, 1, 1, -1, low);

        dp = new long[101][2][2][11];
        long r = dfs(0, 1, 1, -1, high);

        boolean add = true;
        for (int i = 1; i < low.length(); i++)
            if (Math.abs(low.charAt(i) - low.charAt(i - 1)) != 1) add = false;

        long res;
        if (add) res = (r - l + 1 + MOD) % MOD;
        else res = (r - l + MOD) % MOD;

        return (int) res;
    }
}


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
