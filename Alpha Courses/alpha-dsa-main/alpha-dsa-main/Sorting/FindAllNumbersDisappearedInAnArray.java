package Sorting;

import java.util.ArrayList;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 8, 7, 2, 3, 1 };
        System.out.println(findDisappearedNumbers(arr));
    }

    /**
     * Finds all the missing numbers in an input array of integers.
     * 
     * @param arr the input array of integers
     * @return an ArrayList of the missing numbers
     */
    static ArrayList<Integer> findDisappearedNumbers(int[] arr) {
        int i = 0; // initialize a variable to keep track of the current index
        while (i < arr.length) { // iterate over the array
            int correct = arr[i] - 1; // set the correct index of the current element
            if (arr[correct] != arr[i]) { // if the current element is not in its correct index
                swap(arr, i, correct); // swap the current element with its correct index
            } else {
                i++; // increment the index
            }
        }
        ArrayList<Integer> list = new ArrayList<>(); // create a new ArrayList to store the missing numbers
        for (int j = 0; j < arr.length; j++) { // iterate over the array
            if (arr[j] != (j + 1)) { // if the current element is not equal to its index plus one
                list.add(j + 1); // add the missing number to the ArrayList
            }
        }
        return list; // return the ArrayList of missing numbers
    }

    static void swap(int[] arr, int f, int s) {
        int temp = arr[f]; // store the value of the first element in a temporary variable
        arr[f] = arr[s]; // set the value of the first element to the value of the second element
        arr[s] = temp; // set the value of the second element to the value of the temporary variable
    }

}