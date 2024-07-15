package Sorting;

public class MissingNumber {
    public static void main(String args[]) {
        int[] arr = { 0, 3, 2, 4 };
        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int[] arr) {
        int i = 0; // initialize a variable to keep track of the current index
        while (i < arr.length) { // iterate over the array
            int correct = arr[i]; // set the correct index of the current element
            if (arr[i] < arr.length && arr[i] != arr[correct]) { // if the current element is not in its correct index
                swap(arr, i, correct); // swap the current element with its correct index
            } else {
                i++; // increment the index
            }
        }
        for (int index = 0; index < arr.length; index++) { // iterate over the array
            if (index != arr[index]) { // if the current index is not equal to the current element
                return index; // return the current index as the missing number
            }
        }
        return arr.length; // if no missing number is found, return the length of the array
    }

    static void swap(int[] arr, int f, int s) {
        int temp = arr[f]; // store the value of the first element in a temporary variable
        arr[f] = arr[s]; // set the value of the first element to the value of the second element
        arr[s] = temp; // set the value of the second element to the value of the temporary variable
    }
}
