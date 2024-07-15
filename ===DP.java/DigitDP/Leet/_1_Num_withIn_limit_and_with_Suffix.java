public class _1_Num_withIn_limit_and_with_Suffix {

}
// Limit 9 ka no need now as given i Q only its always Given Limit
// https://leetcode.com/problems/count-the-number-of-powerful-integers/description/?envType=list&envId=r8bvg0x3

public class Solution {
    public long helper(String a, String s, int limit) {
        if (a.length() < s.length())
            return 0L;
        if (a.length() == s.length()) {
            if (a.compareTo(s) >= 0)
                return 1;
            return 0;
        }
        long ans = 0;
        String sub = a.substring(a.length() - s.length());
        int len = a.length() - s.length();
        int i;
        for (i = 0; i < len; i++) {
            if (limit < (a.charAt(i) - '0')) {
                ans += (long) Math.pow(limit + 1, len - i);
                return ans;
            } else {
                ans += (long) (a.charAt(i) - '0') * (long) Math.pow(limit + 1, len - 1 - i);
            }
        }
        if (sub.compareTo(s) >= 0)
            ans++;
        return ans;
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String a = String.valueOf(start - 1);
        String b = String.valueOf(finish);
        return helper(b, s, limit) - helper(a, s, limit);
    }
}

class Solution {
    String s;
    int limit;

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.limit = limit;
        this.s = s;
        String finishS = Long.toString(finish);
        String startS = Long.toString(start - 1);
        while (startS.length() < finishS.length()) {
            startS = '0' + startS;
        }

        String startSuffix = startS.substring(startS.length() - s.length());
        String startPrefix = startS.substring(0, startS.length() - s.length());
        String finishSuffix = finishS.substring(finishS.length() - s.length());
        String finishPrefix = finishS.substring(0, finishS.length() - s.length());

        return count(finishPrefix, finishSuffix) - count(startPrefix, startSuffix);
    }

    long count(String prefix, String suffix) {
        if (prefix.isEmpty()) {
            return suffix.compareTo(s) >= 0 ? 1 : 0;
        }

        int digit = prefix.charAt(0) - '0';
        if (digit > limit) {
            return (long) Math.pow(limit + 1, prefix.length());
        }

        long countExceptLastDigit = digit * (long) Math.pow(limit + 1, prefix.length() - 1);
        return countExceptLastDigit + count(prefix.substring(1), suffix);
    }
}

class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {

        // char c[]=Long.toString(finish).toCharArray();
        int length = s.length();
        long dp[][] = new long[16][2];

        for (int i = 0; i < 16; i++) {
            Arrays.fill(dp[i], -1);
        }

        long val1 = solve(Long.toString(finish).toCharArray(), finish, limit, s, 0, 1, dp);
        for (int i = 0; i < 16; i++) {
            Arrays.fill(dp[i], -1);
        }
        long val2 = solve(Long.toString(start - 1).toCharArray(), start - 1, limit, s, 0, 1, dp);

        return val1 - val2;

        // return count(finish,limit,s);
    }

    public long solve(char c[], long num, int limit, String s, int i, int flag, long dp[][]) {

        long ans = 0;
        // System.out.println(flag+" "+i);
        if (flag == 1 && i >= c.length - s.length()) {
            if ((num % (Math.pow(10, s.length()))) >= Long.valueOf(s))
                return 1;
            else
                return 0;

        }

        if (flag == 0 && i >= c.length - s.length())
            return 1;

        if (dp[i][flag] != -1)
            return dp[i][flag];

        for (int j = 0; j <= limit; j++) {
            if (j == (c[i] - '0') && flag == 1) {
                ans += solve(c, num, limit, s, i + 1, 1, dp);
            } else if (j < (c[i] - '0')) {
                ans += solve(c, num, limit, s, i + 1, 0, dp);
            } else if ((j >= (c[i] - '0')) && flag == 0) {
                ans += solve(c, num, limit, s, i + 1, 0, dp);
            }
        }

        return dp[i][flag] = ans;

    }

}

class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long sVal = Long.parseLong(s);

        long mul = 1;

        while (mul <= sVal) {
            mul *= 10;
        }

        long result = solve(finish, sVal, mul, limit);
        result -= solve(start - 1, sVal, mul, limit);

        return result;
    }

    private double convertBase(long val, long base) {

        double result = 0;

        List<Integer> results = new ArrayList<>();

        int mod;

        while (val != 0) {
            mod = (int) (val % base);
            results.add(mod);
            val /= base;
        }

        Collections.reverse(results);

        for (int num : results) {
            result *= 10;
            result += num;
        }

        return result;
    }

    private long solve(long val, long s, long mul, int limit) {

        long max = 1;

        while (max * mul <= val) {
            max *= 10;
        }

        long min = -1;

        long mid;

        double mVal;

        while (max - min > 1) {
            mid = (max + min) / 2;

            mVal = convertBase(mid, limit + 1) * mul + s;

            // System.out.println(max + " " + min + " " + mVal + " " + val);

            if (mVal <= val) {
                min = mid;
            } else {
                max = mid;
            }
        }

        // System.out.println(max);
        return max;
    }}

    string str;
    int limit = 3;

    // This function calculates the count of numbers of length == len(str)
    // where each digit is less than or equal to 3
    int getCount(int idx, bool Restriction) {
        // Base case: If the current idx reaches the end of the string
        if (idx == str.length()) {
            return 1;
        }

        // Initialization of loop variables
        // st is set to 1 if it's the first index; otherwise, it's set to 0
        // The first idx can't be zero nor will alter the number length
        int st = (idx == 0) ? 1 : 0;

        // ed will take the minimum of limit and either of two values below
        // 1. 9 if there is no restriction
        // 2. str[idx]-'0' if there is a restriction
        // Restriction here specifies if the idx-1 values chosen are less than the
        // original.
        // If yes, then we can take any values ranging from 0 to min(9, limit) for the
        // current idx and so on.
        int ed = min(limit, Restriction == 1 ? 9 : str[idx] - '0');

        int ans = 0;

        // Loop over possible values for the current digit
        for (int i = st; i <= ed; i++) {
            bool currRestriction = Restriction || (i < str[idx] - '0');

            // Uncomment the below line to visualize the recursive call
            // cout << "Calling getCount(" << idx + 1 << ", " << currRestriction << ")" << "
            // for " << i << endl;

            ans += getCount(idx + 1, currRestriction);
        }

        // Uncomment the below two lines to visualize the recursive call
        // cout << "Returning from getCount(" << idx << ", " << isRestriction << ") with
        // result: " << ans << endl;
        // cout << endl;

        return ans;
    }

int main() {
    int start=5;
    int finish = 231;
    str = to_string(finish);

    // Uncomment these two lines below to visualize the Recursion Tree
    // cout << "Recursion Tree:" << endl;
    // cout << "Calling getCount(0, 0)" << endl;

    cout << "Result: " << getCount(0, 0) << endl;
    
    return 0;
}

    #include<bits/stdc++.h>

using namespace std;

    string str;
    int limit = 3;

    int dp[2][16];

    int getCount(int idx, bool Restriction) {
        if (idx == str.length()) {
            return 1;
        }
        if (dp[Restriction][idx] != -1) {
            return dp[Restriction][idx];
        }

        int st = (idx == 0) ? 1 : 0;

        int ed = min(limit, Restriction == 1 ? 9 : str[idx] - '0');

        int ans = 0;

        for (int i = st; i <= ed; i++) {
            bool currRestriction = Restriction || (i < str[idx] - '0');

            ans += getCount(idx + 1, currRestriction);
        }
        dp[Restriction][idx] = ans;
        return ans;
    }

int main() {
    int start=5;
    int finish = 231;
    str = to_string(finish);
    memset(dp,-1,sizeof(dp));
    cout << "Result: " << getCount(0, 0) << endl;
    }return 0;
}