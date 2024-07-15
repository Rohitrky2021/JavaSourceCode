import java.util.Arrays;

public class ArrayReduction {
    public static int reduceArraySize(int[] arr) {
        int m = Arrays.stream(arr).min().orElseThrow(); // Find the minimum element in the array
        int c = 0;

        for (int x : arr) {
            if (x % m != 0) {
                return 1;
            }
            if (x == m) {
                ++c;
            }
        }

        return (c + 1) / 2;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 2, 4, 6, 3};
        int result = reduceArraySize(arr);
        System.out.println("Result: " + result);
    }
}
