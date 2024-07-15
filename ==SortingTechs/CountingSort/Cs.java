// https://www.geeksforgeeks.org/counting-sort/

public class Cs {
    public static void countingSort(int[] arr) {
        // Find the maximum value in the array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create a counting array to store the count of each element
        int[] countArray = new int[max + 1];

        // Count the occurrences of each element in the input array
        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i]]++;
        }

        // Reconstruct the sorted array from the counting array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (countArray[i] > 0) {
                arr[index++] = i;
                countArray[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 8, 3, 3, 1 };
        countingSort(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

// The time
// complexity of
// the Counting
// Sort algorithm

// is ====>>>> O(n + k), where:

// n is the number of elements in the input array.
// k is the range of

// the input (the difference between the maximum and minimum values in the input array).
