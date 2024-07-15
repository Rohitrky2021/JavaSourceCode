// SLIDINGWINDOW

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeuTEMPLATE{
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0; // result index

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
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

            // Add the maximum element for the current window to the result array
            if (i >= k - 1) {
                result[ri++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}


// In this template, we use a Deque (implemented as ArrayDeque) to store indices
//  of elements in the current sliding window. The deque is used to efficiently keep
//   track of the maximum element in the current window.

// The maxSlidingWindow function takes an array nums and an integer k as inputs 
// and returns an array containing the maximum elements for each sliding window of size k
//  in the original array nums.

// The main idea is to maintain a decreasing deque where the maximum element is always
//  at the front (peekFirst). As we slide the window, we add and remove elements from 
//  the deque to keep it updated with the elements in the current window. The maximum 
//  element is always the first element in the deque.

// The result array stores the maximum elements for each window, and ri keeps track
//  of the index in the result array. When the window size becomes equal to k, we start 
//  filling the result array with the maximum element for each window.

// The time complexity of this approach is O(n) since each element is pushed and 
// popped from the deque at most once. Therefore, it is an efficient way to solve 
// sliding window problems that require finding maximum (or minimum) elements in a window.