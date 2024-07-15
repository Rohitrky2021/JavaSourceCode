import java.util.Arrays;

// good USED in coind change problem also by just Slight Modification 
// https://leetcode.com/problems/coin-change-ii/description/

public class dividesumEqualK {
// public class SubsetCount {

    static int[][] tmp = new int[100][100];

    public static int subsetCount(int[] arr, int sum, int n) {
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;
        if (tmp[n][sum] != -1)
            return tmp[n][sum];
        else {
            if (arr[n - 1] > sum)
                return tmp[n][sum] = subsetCount(arr, sum, n - 1);
            else {
                return tmp[n][sum] = subsetCount(arr, sum, n - 1) + subsetCount(arr, sum - arr[n - 1], n - 1);
            }
        }
    }

    public static void main(String[] args) {
        for (int[] row : tmp) {
            Arrays.fill(row, -1);
        }

        int[] arr = {1,2,5,7,17,17};
        int n = arr.length;
        
        int sum = 41;
        
        System.out.println(subsetCount(arr, sum, n));
        // for (int i = 0; i < tmp.length; i++) {
        //     for (int j = 0; j < tmp[0].length; j++) {
        //         System.out.print( tmp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
    }
}


