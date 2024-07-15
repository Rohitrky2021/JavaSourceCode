// Efficient approach is to use hashing
// Time complexity: O(log N) for single query.
// Auxiliary Space: O(N)

// int arr[] = {2, 8, 6, 9, 8, 6, 8, 2, 11}; // --> Given Sorted Array 
// map[2] = {1, 8}
// map[8] = {2, 5, 7}
// map[6] = {3, 6} 

// Java program to find total count of an element
import java.util.*;

public class rangeFrequency {
    // public class GFG {

    static HashMap<Integer, ArrayList<Integer>> store;

    static int lower_bound(ArrayList<Integer> a, int low, int high, int key) {
        if (low > high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if (key <= a.get(mid)) {

            return lower_bound(a, low, mid - 1, key);
        }
        return lower_bound(a, mid + 1, high, key);
    }
// -------> DOING HERE BINARYY SEACH ON ANS INDEX OF HASH MAP;
    static int upper_bound(ArrayList<Integer> a, int low, int high, int key) {
        if (low > high || low == a.size())
            return low;
        int mid = low + (high - low) / 2;
        if (key >= a.get(mid)) {
            return upper_bound(a, mid + 1, high, key);
        }
        return upper_bound(a, low, mid - 1, key);
    }

    // Returns frequency of element in arr[left-1..right-1]
    static int findFrequency(int arr[], int n, int left,
            int right, int element) {
        // Find the position of first occurrence of element
        int a = lower_bound(store.get(element), 0, store.get(element).size(), left);

        // Find the position of last occurrence of element
        int b = upper_bound(store.get(element), 0, store.get(element).size(), right);

        return b - a;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = { 2, 8, 6, 9, 8, 6, 8, 2, 11 };
        int n = arr.length;

        // Storing the indexes of an element in the map
        store = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (!store.containsKey(arr[i]))
                store.put(arr[i], new ArrayList<>());
            store.get(arr[i]).add(i + 1); // starting index from 1
        }

        // Print frequency of 2 from position 1 to 6
        System.out.println("Frequency of 2 from 1 to 6 = "+ findFrequency(arr, n, 1, 6, 2));

        // Print frequency of 8 from position 4 to 9
        System.out.println("Frequency of 8 from 4 to 9 = "+ findFrequency(arr, n, 4, 9, 8));
    }
}

// This code is contributed by Karandeep1234

// M2 --------------->>>>>>>>> BRUTE FORCE

// JAVA Code to find total count of an element
// in a range

class GFG {

    // Returns count of element in arr[left-1..right-1]
    public static int findFrequency(int arr[], int n,   int left, int right, int element) {
        int count = 0;
        for (int i = left - 1; i < right; ++i)
            if (arr[i] == element)
                ++count;
        return count;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        int arr[] = { 2, 8, 6, 9, 8, 6, 8, 2, 11 };
        int n = arr.length;

        // Print frequency of 2 from position 1 to 6
        System.out.println("Frequency of 2 from 1 to 6 = " +
                findFrequency(arr, n, 1, 6, 2));

        // Print frequency of 8 from position 4 to 9
        System.out.println("Frequency of 8 from 4 to 9 = " +
                findFrequency(arr, n, 4, 9, 8));

    }
}
// // This code is contributed by Arnav Kr. Mandal.
