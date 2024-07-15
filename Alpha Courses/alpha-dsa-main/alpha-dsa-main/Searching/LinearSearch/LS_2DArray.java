package LinearSearch;

import java.util.Arrays;
import java.util.ArrayList;

public class LS_2DArray {
    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        list.add(new ArrayList<>(Arrays.asList(4, 5, 6)));

        int target = 5;
        System.out.println(target);

        // int[] index = linearSearch(list, target);

    }

    //for 2D arrays
    static int[] linearSearch(int[][] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    static int findMax(int[][] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    static int findMin(int[][] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max > arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
}
