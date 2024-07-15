package T07_Backtraking;

public class OnArray {

    public static void main(String[] args) {
        int arr[] = new int[10];
        backtraking(arr, 0, 1);
        printArr(arr);
    }

    public static void backtraking(int arr[], int i, int value) {
        if (arr.length == i) {
            printArr(arr);
            return;
        }
        arr[i] = value;
        backtraking(arr, i + 1, value + 1);
        arr[i] = i - 2;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
 
public class OnArray {

    // Main method where the program starts execution
    public static void main(String[] args) {
        // Create an integer array of size 10
        int arr[] = new int[10];
        
        // Call the backtraking method with the array, starting index 0, and starting value 1
        backtraking(arr, 0, 1);
        
        // Print the array after the backtraking method has finished
        printArr(arr);
    }

    // Backtraking method that fills the array with values
    public static void backtraking(int arr[], int i, int value) {
        // Base case: if the current index is equal to the length of the array, print the array
        if (arr.length == i) {
            printArr(arr);
            return;
        }
        
        // Set the current index of the array to the current value
        arr[i] = value;
        
        // Recursively call the backtraking method with the next index and the next value
        backtraking(arr, i + 1, value + 1);
        
        // After the recursive call, set the current index of the array to i - 2 (backtracking)
        arr[i] = i - 2;
    }

    // Method to print the array
    public static void printArr(int arr[]) {
        // Loop through the array and print each element
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // Print a newline after printing the array
        System.out.println();
    }
}