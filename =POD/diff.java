import java.util.Arrays;

public class diff {
    public static void findMinAbsoluteDifferencePairs(int[] arr) {
        if (arr.length < 2) {
            System.out.println("-1");
            return;
        }

        Arrays.sort(arr);

        int minAbsDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int currentAbsDiff = Math.abs(arr[i] - arr[i - 1]);
            if (currentAbsDiff < minAbsDiff) {
                minAbsDiff = currentAbsDiff;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            int currentAbsDiff = Math.abs(arr[i] - arr[i - 1]);
            if (currentAbsDiff == minAbsDiff) {
                System.out.println("(" + arr[i - 1] + ", " + arr[i] + ")");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,2,4,10};
        findMinAbsoluteDifferencePairs(arr);
    }
}
