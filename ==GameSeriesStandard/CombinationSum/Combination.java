// https://leetcode.com/problems/combinations/

// Example 1:
// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
// Explanation: There are 4 choose 2 = 6 total combinations.
// Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
// Example 2:

// Input: n = 1, k = 1
// Output: [[1]]
// Explanation: There is 1 choose 1 = 1 total combination.

// class Solution {
    public class Combination {

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();

        combineHelper(n, k, 1, l, ans, hs);
        return ans;
    }

    private void combineHelper(int n, int k, int start, List<Integer> current, List<List<Integer>> ans, HashSet<List<Integer>> hs) {
        if (current.size() == k) {
            List<Integer> combination = new ArrayList<>(current); // Create a copy of the current list
            // if (!hs.contains(combination)) {
                // hs.add(combination);
                ans.add(combination);
            // }
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            combineHelper(n, k, i + 1, current, ans, hs); // Recursively generate combinations
            current.remove(current.size() - 1); // Backtrack by removing the last element
        }
    }
}

