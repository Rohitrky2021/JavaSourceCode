class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> hm = new HashMap<>();
        return dfs(root, 0, targetSum, hm);
    }

    private int dfs(TreeNode root, long prefixSum, int targetSum, HashMap<Long,Integer> hm) {
        if(root == null) 
            return 0;

        prefixSum += root.val;
        int count = hm.getOrDefault(prefixSum - targetSum, 0);

        if(prefixSum == targetSum) 
            count++;

        hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
        int totalCount = count + dfs(root.left, prefixSum, targetSum, hm) + dfs(root.right, prefixSum, targetSum, hm);
        hm.put(prefixSum, hm.get(prefixSum) - 1);
        return totalCount;
    }
}