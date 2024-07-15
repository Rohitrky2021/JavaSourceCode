// https://codeforces.com/problemset/problem/1426/D
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A_M1_Max {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        int result = solution.findPrefixSumSubarrays(n, array);
        System.out.println(result);

        scanner.close();
    }
}

class Solution {
    public int findPrefixSumSubarrays(int n, int[] array) {
        long prefixSum = 0;
        Set<Long> set = new HashSet<>();
        set.add(0L);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += array[i];
            if (set.contains(prefixSum)) { //Now we get the zero after this operataion it will not be same we can start new 
                ans++;
                set.clear();
                set.add(0L);
                set.add((long) array[i]);
                prefixSum = array[i];
            } else {
                set.add(prefixSum);
            }
        }

        return ans;
    }
}
