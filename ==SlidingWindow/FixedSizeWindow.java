public class FixedSizeWindow {
    
}
public class SlidingWindowSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 1, 2};
        int n = arr.length;

        int k = 3;
        int sum = 0;

        // Calculate the sum of the first k elements
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        System.out.println(sum);

        // Calculate the sum of all subarrays of size k
        for (int i = k; i < n; i++) {
            sum = sum + arr[i] - arr[i - k];
            System.out.println(sum);
        }
        
    }
}
