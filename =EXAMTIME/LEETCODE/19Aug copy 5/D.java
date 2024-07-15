import java.util.*;

class D {
    private HashMap<String, Integer> memo;

    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        memo = new HashMap<>();
        Arrays.sort(rewardValues);  // Sort the reward values
        return getMaxReward(rewardValues, 0, 0);
    }

    private int getMaxReward(int[] rewardValues, int index, int currentTotal) {
        if (index == rewardValues.length) {
            return currentTotal;
        }
        
        String key = index + "-" + currentTotal;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int skip = getMaxReward(rewardValues, index + 1, currentTotal);

        int take = 0;
        if (rewardValues[index] > currentTotal) {
            take = getMaxReward(rewardValues, index + 1, currentTotal + rewardValues[index]);
        }

        int maxReward = Math.max(skip, take);
        memo.put(key, maxReward);
        return maxReward;
    }

    public static void main(String[] args) {
        D solution = new D();

        int[] rewardValues1 = {1, 1, 3, 3};
        System.out.println("Maximum Total Reward for rewardValues1: " + solution.maxTotalReward(rewardValues1));

        int[] rewardValues2 = {1, 6, 4, 3, 2};
        System.out.println("Maximum Total Reward for rewardValues2: " + solution.maxTotalReward(rewardValues2));

        int[] rewardValues3 = {5, 1, 2, 10, 7};
        System.out.println("Maximum Total Reward for rewardValues3: " + solution.maxTotalReward(rewardValues3));
    }
}
