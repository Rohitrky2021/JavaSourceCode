import java.util.*;

public class subarraymean {

    public static int countK(List<Integer> rank, int n, int k) {
        int res = 0, curSum = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            curSum += (rank.get(i) - k);
            if (curSum == 0)
                res++;

            if (mp.containsKey(curSum)) {
                res += mp.get(curSum);
            }
            mp.put(curSum, mp.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }

    public static List<Integer> getMeanRankCount(List<Integer> rank) {
        int n = rank.size();

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            ans.add(countK(rank, n, i));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> ranks = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
        List<Integer> meanRankCounts = getMeanRankCount(ranks);
        System.out.println(meanRankCounts);
    }
}
