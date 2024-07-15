/*
 * For a given integer array of size N. You have to find all the occurences
 * of a given and print them. Use a recursive function to solve this problem
 */
public class exercise1 {
    public static void occurences(int arr[], int key, int i) {
        if(i == arr.length) {
            return;
        }

        if(arr[i] == key) {
            System.out.println(i + " ");
        }
        occurences(arr, key, i+1);
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 6, 7, 2, 9, 1};
        int key = 2;
        occurences(arr, key, 0);
        System.out.println();
    }
}
