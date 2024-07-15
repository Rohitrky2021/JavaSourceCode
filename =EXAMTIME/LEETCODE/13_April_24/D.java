import java.util.Deque;
import java.util.LinkedList;

public class D {

    static long numberOfSubarrays(int[] nums, int K) {
        int N = nums.length;
        long count = 0;
        Deque<Integer> Qi = new LinkedList<Integer>();

        // Process first k (or first window) elements of array
        int i;
        for (i = 0; i < K; ++i) {
            while (!Qi.isEmpty() && nums[i] >= nums[Qi.peekLast()])
                Qi.removeLast();
            Qi.addLast(i);
        }

        // Process rest of the elements
        for (; i < N; ++i) {
            // Count subarrays where boundary elements are maximum
            if (nums[Qi.peek()] == nums[i - K] && nums[Qi.peek()] == nums[i])
                count += (K - 1);

            // Remove the elements which are out of this window
            while (!Qi.isEmpty() && Qi.peek() <= i - K)
                Qi.removeFirst();

            while (!Qi.isEmpty() && nums[i] >= nums[Qi.peekLast()])
                Qi.removeLast();

            Qi.addLast(i);
        }

        // Count subarrays where boundary elements are maximum for the last window
        if (!Qi.isEmpty() && nums[Qi.peek()] == nums[N - K] && nums[Qi.peek()] == nums[N - 1])
            count += (K - 1);

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 3, 2};
        int K = 3;
        System.out.println(numberOfSubarrays(arr, K)); // Output: 6
    }
}
