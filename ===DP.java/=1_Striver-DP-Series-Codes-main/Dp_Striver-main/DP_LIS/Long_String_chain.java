package DP_LIS;

import java.util.*;

public class Long_String_chain {

    public boolean check(String s1, String s2) {
        int i = 0;
        int j = 0;
       
        while (j < s2.length()) {
            if (i < s1.length() && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        return false;

    }

    public int longestStrChain(String[] nums) {
        int n = nums.length;

        Comparator<String> comparator = (a, b) -> Integer.compare(a.length(), b.length());

        // Sort the array using the comparator
        Arrays.sort(nums, comparator);

        int dp[][] = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = -1; j < i; j++) {
                int take = 0;
                if (j == -1 || nums[i].length() == nums[j].length() + 1) {
                    if (j == -1 || check(nums[j], nums[i])) {
                        take = 1 + dp[i + 1][i + 1];
                    }
                }

                int non = dp[i + 1][j + 1];
                dp[i][j + 1] = Math.max(take, non);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {

    }
}
