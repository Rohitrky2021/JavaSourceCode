import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_H1 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] ns = new int[t];
        int[][] arrays = new int[t][];

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            ns[i] = n;
            arrays[i] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arrays[i][j] = Integer.parseInt(st.nextToken()) + j + 1;
            }
        }

        Solution solution = new Solution();
        for (int i = 0; i < t; i++) {
            int[] result = solution.solve(ns[i], arrays[i]);
            for (int j = result.length - 1; j >= 0; j--) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public int[] solve(int n, int[] nums) {
        Arrays.sort(nums);
        Set<Integer> ans = new HashSet<>();
        ans.add(nums[n - 1]);
        
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) {
                nums[i] = nums[i + 1] - 1;
            }
            ans.add(nums[i]);
        }
        
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            result[i] = nums[i];
        }
        
        return result;
    }
}
