import java.util.Stack;


import java.util.TreeMap;
import java.util.Map;

public class LongestSubsequence {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 8, 15};
        int threshold = 3;
        int result = longestSubsequence(arr, threshold);
        System.out.println("Length of the longest subsequence: " + result);
    }

    public static int longestSubsequence(int[] arr, int T) {
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Minimum subsequence length is 1 for each element
            for (int j = 0; j < i; j++) {
                if (Math.abs(arr[i] - arr[j]) <= T) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int len : dp) {
            maxLength = Math.max(maxLength, len);
        }

        return maxLength;
    }
}


public class ss {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 8, 15};
        int threshold = 3;
        int result = longestSubsequence(arr, threshold);
        System.out.println("Length of the longest subsequence: " + result);
    }

    public static int longestSubsequence(int[] arr, int T) {
        int n = arr.length;
        int[] dp = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Minimum subsequence length is 1 for each element

            // Find the next greater element in the stack
            while (!stack.isEmpty() && arr[i] - arr[stack.peek()] > T) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                dp[i] = stack.size() + 1;
            }

            // Update the stack
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            stack.push(i);
        }

        int maxLength = 0;
        for (int len : dp) {
            maxLength = Math.max(maxLength, len);
        }

        return maxLength;
    }
}



public class s {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 8, 15};
        int t = 3;
        int result = lengthOfLIS(nums, t);
        System.out.println("Length of the longest subsequence: " + result);
    }

    public static int lengthOfLIS(int[] nums, int t) {
        TreeMap<Integer, Integer> sequences = new TreeMap<>();

        for (int num : nums) {
            Map.Entry<Integer, Integer> entry = sequences.ceilingEntry(num - t);
            int currentLength = 1;

            if (entry != null) {
                currentLength = entry.getValue() + 1;
            }

            sequences.put(num, currentLength);

            // Remove entries that have a smaller difference in values
            Map.Entry<Integer, Integer> higherEntry = sequences.higherEntry(num);
            while (higherEntry != null && higherEntry.getValue() <= currentLength) {
                sequences.remove(higherEntry.getKey());
                higherEntry = sequences.higherEntry(num);
            }
        }

        return sequences.isEmpty() ? 0 : sequences.lastEntry().getValue();
    }
}
