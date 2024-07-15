import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        int count=0;

        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }

        while (q.peek()<k && q.size()>=2) {
            int x= q.poll();
            int y=q.poll();

            q.add(Math.min(x, y)*2+Math.max(x, y));
            count++;
        }
        return count;
        
    }

    public int op(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;

        for (int x : nums) {
            if (x >= k)
                break;

            count++;
        }

        return count;

    }
}