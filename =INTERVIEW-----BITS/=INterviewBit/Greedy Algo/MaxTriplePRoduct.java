// https://www.interviewbit.com/problems/highest-product/

public class MaxTriplePRoduct {
    public int maxp3(ArrayList<Integer> nums) {
        Integer[] arr = nums.toArray(new Integer[nums.size()]);
        Arrays.sort(arr);
        // Now, you can treat 'arr' as an array and write your logic
        int n = arr.length, max = arr[0], min = arr[0], i;
        int ans = arr[n - 1];
        int ans2 = arr[n - 1] * arr[n - 2] * arr[n - 3];
        ans *= arr[0];
        ans *= arr[1];

        return Math.max(ans, ans2);

    }

}
