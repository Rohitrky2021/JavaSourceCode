public class Sum1 {
    // https://leetcode.com/problems/combination-sum/description/
//     Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
    class Solution {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> list = new ArrayList<>();
            Arrays.sort(candidates);
            combination2(0, candidates, target, res, list);
            return res;
        }
    
        public void combination2(int index, int[] arr, int target, List<List<Integer>> res, List<Integer> list) {
            if (target == 0) {
                Collections.sort(list);
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = index; i < arr.length; i++) {
                if (i > index && arr[i] == arr[i - 1]) continue;
                if (target < arr[i]) break;
    
                list.add(arr[i]);
                combination2(i, arr, target - arr[i], res, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
}
