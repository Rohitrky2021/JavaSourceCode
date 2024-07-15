import java.util.*;

class J {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        for (int p : nums) {
            hm.merge(p, 1, Integer::sum);
        }

        return helper(nums, n, hm.firstKey() , hm);
    }
    TreeMap<Integer, Integer> dp = new TreeMap<>();


    public int helper(int[] nums, int n, Integer i, TreeMap<Integer, Integer> hm) {
        if (i == null) {
            return 0;
        }

        if(dp.containsKey(i)){
            return dp.get(i);
        }

        int take = i * hm.get(i) + helper(nums, n,   hm.ceilingKey(i+2), hm);
        int leave = helper(nums, n, hm.ceilingKey(i+1), hm);
        int ans = Math.max(take, leave);
        dp.put(i, ans);
        return ans;
    }

    public static void main(String[] args) {
        J i = new J();

        // Example input
        int[] nums = {2,2,3,3,3,4};
        int k = 2;

        long result = i.deleteAndEarn(nums);
        System.out.println("Number of subarrays with at least " + k + " occurrences of element 3: " + result);
    }
}
