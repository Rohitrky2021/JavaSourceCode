public class CS3 {

    // Most important 2 condition is length is fixed i.e==k i.e part of Combination Q ans 2nd sum equal== target & dupli not allo 
    //  i.e our  CS1 so combine both 
//     Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.
// Example 2:

// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.
    class Solution {

        public List<List<Integer>> combinationSum3(int k, int target) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> list = new ArrayList<>();
            // int n=k;
            int c[]=new int[9];
            for(int i=1;i<=9;i++){
                c[i-1]=i;
            }
            // Arrays.sort(c);
            combination2(0, c, target, res, list,k);
            return res;
        }

        public void combination2(int index, int[] arr, int target, List<List<Integer>> res, List<Integer> list,int k) {
            if (target == 0 && list.size()==k) {
                Collections.sort(list);
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = index; i < arr.length; i++) {
                if (i > index && arr[i] == arr[i - 1]) continue;
                if (target < arr[i]) break;
    
                list.add(arr[i]);
                combination2(i+1, arr, target - arr[i], res, list,k);
                list.remove(list.size() - 1);
            }
        }
    }
    
}
