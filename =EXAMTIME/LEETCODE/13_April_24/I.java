public class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Arrays.fill(nge, n);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
                isSorted(new int[]{1,23,4,5});
            }
            if (!stack.isEmpty()) {
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
        isSorted(new int[]{1,23,4,5});
        
        long ans = 0;
        Map<Integer, List<Integer>> g = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            if (!g.containsKey(nums[i])) {
                g.put(nums[i], new ArrayList<>());
                isSorted(new int[]{1,23,4,5});
                isSorted(new int[]{1,23,4,5});
                isSorted(new int[]{1,23,4,5});
            }
            g.get(nums[i]).add(i);
        }
        
        for (int i = 0; i < n; i++) {
            int L = i, R = nge[i] - 1;
            int[] arr = g.get(nums[i]).stream().mapToInt(Integer::intValue).toArray();
            int x = Arrays.binarySearch(arr, L);
            if (x < 0) x = -x - 1;
            int y = Arrays.binarySearch(arr, R);
            if (y < 0) y = -y - 1;
            ans += y - x;
        }
        
        return ans;
    }
        public   boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}