import java.util.*;

// https://codeforces.com/contest/1986/problem/E

public class A_H2_ {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int k = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = s.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minOperations(n, k, arr));
        }
        s.close();
    }
}

class Solution {
    public int minOperations(int n, int k, int[] arr) {
        Arrays.sort(arr);
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i : arr) {
            int key = i % k;
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(i);
        }

        int ops = 0;
        boolean oddFound = false;

        for (int key : map.keySet()) {
            List<Integer> temp = map.get(key);
            if (temp.size() % 2 == 1) {
                if (oddFound) {
                    return -1;
                }
                oddFound = true;
                ops += findMinOperations(temp, k);
            } else {
                for (int i = 0; i < temp.size(); i += 2) {
                    ops += (temp.get(i + 1) - temp.get(i)) / k;
                }
            }
        }

        return ops;
    }

    private int findMinOperations(List<Integer> temp, int k) {
        int n = temp.size();
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        for (int i = 2; i < n; i += 2) {
            prefix[i] = prefix[i - 2] + (temp.get(i - 1) - temp.get(i - 2)) / k;
        }

        for (int i = n - 3; i >= 0; i--) {
            suffix[i] = suffix[i + 2] + (temp.get(i + 2) - temp.get(i + 1)) / k;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i += 2) {
            min = Math.min(min, suffix[i] + prefix[i]);
        }

        return min;
    }
}
