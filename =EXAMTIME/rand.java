public class rand {

    public static int countBalancedSubarrays(int[] arr) {
        int count = 0;
        int prefixSum = 0;
        int sum = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum == sum) {
                count++;
            }

            sum += num;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 3, 3, 9};
        int result = countBalancedSubarrays(arr);
        System.out.println("Number of balanced subarrays: " + result);
    }
}
