import java.util.Arrays;
// You are in your kingdom with no troops but your barracks train X troops every day,
//  initially X=1.
// There are N neighbour kingdom each of which has A[i] amount of troops guarding it.
//  To take over a kingdom you need to attack it with at least A[i] troops. Once you capture
//   as a consequence of war, all of your troops dies even if you attacked with more than A[i]
//  troops
//    and X increases by 1 ( only when you take down a kingdom). Assuming attacking and capturing
//     takes no time, find minimum days needed to take down the entire globe.

// Constraints:

// -------------->  TRIES

// Input:
// Array of Size A

// Example :
// A=[4,1,3]
// Output: 4
// Explanation:
// 1st day, we attack 2nd kingdom with 1 troop, X is now 2
// 2nd and 3rd, day total troops become 4 and we attack 1st kingdom, X is now 3
// 4th day, we attack 3rd kingdom with 3 troops
// so answer is 4.

public class troops {
// public class MinimumTries {
    private static int[] A = {4, 1, 3};
    private static int n = A.length;
    private static int[][] memo;

    public static int t(int num, int x) {
        if (num == 0) return 0;
        if (memo[num][x] != -1) return memo[num][x];

        int minTries = Integer.MAX_VALUE;
        for (int i = 0; i < 20; i++) {
            if (((num >> i) & 1) == 1) {
                int currentTries = ((A[i] - 1) / x) + 1 + t(num - (1 << i), x + 1);
                minTries = Math.min(minTries, currentTries);
            }
        }

        memo[num][x] = minTries;
        return minTries;
    }

    public static int minimumTries() {
        int maxNum = (1 << n) - 1;
        memo = new int[maxNum + 1][21];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return t(maxNum, 1);
    }

    public static void main(String[] args) {
        int result = minimumTries();
        System.out.println("Minimum Tries: " + result);
    }
}

// }
