package DP_Partition;

public class Palindrome_pattion {

    // Expected Time Complexity: O(n*n) [n is the length of the string str]
    // Expected Auxiliary Space: O(n*n)

    public static boolean isPali(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int rec(int i, String str, int dp[]) {
        if (i == str.length()) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        String s = "";
        int min = Integer.MAX_VALUE;
        for (int ind = i; ind < str.length(); ind++) {
            s = s + str.charAt(ind);
            int temp = Integer.MAX_VALUE;
            if (isPali(s)) {
                temp = rec(ind + 1, str, dp);
                if (temp != Integer.MAX_VALUE) {
                    temp = temp + 1;
                }

            }
            // else{
            // temp = rec(ind+1,str);
            // }

            min = Math.min(temp, min);
            // System.out.println(min);

        }

        dp[i] = min;

        return min;
    }

    public static void main(String[] args) {

    }
}
