// You are given an array of integers nums, there is a sliding window
//  of size k which is moving from the very left of the array to the very right.
//   You can only see the k numbers in the window. Each time the sliding window 
//   moves right by one position.

// Return the max sliding window.

 

// Example 1:

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
// }
import java.util.ArrayDeque;
import java.util.Deque;

// public class KthLargestInWindow {
    public class kthlargesWindusingDeque {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = kthLargestInWindow(nums, k);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] kthLargestInWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0; // result index

        Deque<Integer> deque = new ArrayDeque<>();

        // Pre-process the first k elements to form the initial window
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        for (int i = k; i < n; i++) {
            // Add the maximum element (kth largest) for the current window to the result array
            result[ri++] = nums[deque.peekFirst()];

            // Remove elements that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);
        }

        // Add the maximum element (kth largest) for the last window to the result array
        result[ri] = nums[deque.peekFirst()];

        return result;
    }
}
