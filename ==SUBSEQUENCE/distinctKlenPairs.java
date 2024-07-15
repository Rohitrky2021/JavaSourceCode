
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class distinctKlenPairs {

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

// M2 Same throught iteration 
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || n == 0 || k > n) return Collections.emptyList();
        List<List<Integer>> combs = new ArrayList<>();
        for (int i = 1; i <= n; i++) combs.add(Arrays.asList(i));
        for (int i = 2; i <= k; i++) {
            List<List<Integer>> newCombs = new ArrayList<>();
            for (int j = i; j <= n; j++) {
                for (List<Integer> comb : combs) {
                    if (comb.get(comb.size()-1) < j) {
                        List<Integer> newComb = new ArrayList<>(comb);
                        newComb.add(j);
                        newCombs.add(newComb);
                    }
                }
            }
            combs = newCombs;
        }
        return combs;
    }
}