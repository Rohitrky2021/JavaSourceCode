
// longest Increasing Subsequence
package T19_Dynamic_Programming;

import java.util.*;

public class DP11_LCSincreasing {

    static void LIC(int arr1[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        int arr2[] = new int[set.size()];
        int k = 0;
        for (int i : set) {
            arr2[k] = i;
            k++;
        }
        Arrays.sort(arr2);
        // return LCS(arr1, arr2);
        LCS(arr1, arr2);
    }

    static void LCS(int arr1[], int arr2[]) {

        int dp[][] = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        // return dp[arr1.length][arr2.length];
        printDP(dp);
    }

    static void printDP(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = { 50, 3, 10, 7, 40, 80 };
        LIC(arr);
    }
}
