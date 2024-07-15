package DP_LIS;

import java.util.*;

public class Long_Inc_Div {


    //As similar LIS ---
    // Time - 0(N^2) ,space - 0(N)
    public static List<Integer> LIS(int[] arr, int n) {
        // here first sort the array 
        Arrays.sort(arr);
        int index = 0;
        int lcs = 0;
        int dp[] = new int[n];
        int hash[] = new int[n];
        for (int i = 0; i < n; i++) {
            hash[i] = i;
        }
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] % arr[i] == 0 || arr[i] % arr[j] == 0) {  //condition change for divisible 
                    int t = dp[j];
                    t++;
                    if (t > max) {
                        max = t;
                        dp[i] = max;
                        hash[i] = j;
                    }

                }

            }

            if (lcs < max) {
                lcs = max;
                index = i;
            }

        }

        ans.add(arr[index]);
        int curr = hash[index];
        while (hash[curr] != curr) {
            ans.add(arr[curr]);
            curr = hash[curr];
        }
        if (ans.get(0) != arr[curr]) {
            ans.add(arr[curr]);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
