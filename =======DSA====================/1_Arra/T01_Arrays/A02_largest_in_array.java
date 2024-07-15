package T01_Arrays;

public class A02_largest_in_array {
    static int largestNum(int arr[]) {
        int max = arr[0]; // it can be Integer.MIN_VALUE
        for (int i = 1; i < arr.length; i++) {
            max = max < arr[i] ? arr[i] : max;
        }
        return max;
    }
}
