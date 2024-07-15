import java.*;

public class sumequalk {

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] sortedArray = { 1, 2, 3, 4, 5 }; // Example sorted array
        int k = 2; // Example k
        int x = 4; // Example x

        List<int[]> subarrays = findSubarraysWithSumK(sortedArray, k, x);

        // Print the result
        for (int[] subarray : subarrays) {
            System.out.println("Start Index: " + subarray[0] + ", End Index: " + subarray[1]);
        }
    }

    // M2--------->

    public int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {}; // No two numbers found
    }
    

}

 

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        mp.put(a[0], 0);

        int ans = 0;

        for (int i = 1; i < n; i++) {
            a[i] += a[i - 1];

            if (a[i] == k) {
                ans = Math.max(ans, i + 1);
            }

            if (mp.containsKey(a[i] - k)) { // esle pehle ka koi prefix sum 
                ans = Math.max(ans, i - mp.get(a[i] - k));
            }

            if (!mp.containsKey(a[i] - k)) {
                mp.put(a[i], i);
            }
        }

        System.out.println(ans);
    }
}
