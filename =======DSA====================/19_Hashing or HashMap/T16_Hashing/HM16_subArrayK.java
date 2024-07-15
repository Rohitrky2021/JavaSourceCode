
// package T16_Hashing;

import java.util.HashMap;

public class HM16_subArrayK {
    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        System.out.println(SubArraySum(arr, 12));
    }

    public static int SubArraySum(int arr[], int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return ans;
    }
}
