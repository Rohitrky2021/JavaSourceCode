import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class dup {
    static int N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
         N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int minOperations = findMinOperations(arr);
        System.out.println(minOperations);
    }

    static int findMinOperations(int[] arr) {
        // Sort the array to make it easier to find gaps
        Arrays.sort(arr);

        // Use a set to track unique elements
        Set<Integer> uniqueElements = new HashSet<>();

        // Initialize the set with the first element
        uniqueElements.add(arr[0]);

        // Iterate through the array and add unique elements to the set
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                uniqueElements.add(arr[i]);
            }
        }

        // Find the maximum number of continuous elements in the sorted array
        int maxContinuous = 0;
        int currentContinuous = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                currentContinuous++;
            } else {
                maxContinuous = Math.max(maxContinuous, currentContinuous);
                currentContinuous = 1;
            }
        }

        maxContinuous = Math.max(maxContinuous, currentContinuous);

        // Calculate the minimum number of operations needed
        int minOperations = N - maxContinuous;

        return minOperations;
    }
}
