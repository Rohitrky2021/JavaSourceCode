import java.util.PriorityQueue;

public class I {

    public long countSubarrays(int[] nums, int k) {
        long ans =0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int freq[] = new int[max + 1];

        PriorityQueue<Integer> q = new PriorityQueue<Integer>(
                (a, b) -> b - a);

        int head = 0;
        int tail = 0;

        int n = nums.length; // Define n here

        for (head = 0; head < n; head++) {
            q.add(nums[head]);
            freq[nums[head]]++;

            if (freq[q.peek()] == k) {
                freq[q.peek()]--;
                q.poll();
                int c = head - tail + 1;
                tail++;
                ans ++; // Cast to long to avoid integer overflow
            }
        }

        return (long) n * (n + 1) / 2 - ans; // Correct formula for total subarrays
    }

    public static void main(String[] args) {
        I i = new I();

        // Example input
        int[] nums = {1, 3, 2, 3, 3};
        int k = 2;

        long result = i.countSubarrays(nums, k);
        System.out.println("Number of subarrays with at least " + k + " occurrences of element 3: " + result);
    }
}
