package LinearSearch;

// import java.util.Scanner;
// import java.util.Arrays;
// import java.util.ArrayList;

public class LinearSearch {
    public static void main(String args[]) {

    }

    static int linearSearch(int[] arr, int a) {
        if (arr.length == 0) {
            return -1;
        }

        for (int n = 0; n < arr.length; n++) {
            if (arr[n] == a) {
                return n;
            }
        }

        return -1;
    }

    static boolean searchInString(String str, char target) {
        if (str.length() == 0) {
            return false;
        }

        for (int n = 0; n < str.length(); n++) {
            if (str.charAt(n) == target) {
                return true;
            }
        }

        return false;
    }

    static boolean search2(String str, char target) {
        if (str.length() == 0) {
            return false;
        }

        for (char ch : str.toCharArray()) {
            if (ch == target) {
                return true;
            }
        }

        return false;
    }

    static int findMin(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    static int findMax(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
