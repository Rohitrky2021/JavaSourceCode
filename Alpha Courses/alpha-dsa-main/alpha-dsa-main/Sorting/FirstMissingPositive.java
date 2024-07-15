package Sorting;

public class FirstMissingPositive {
    public static void main(String args[]) {
        int[] arr = { 7, 8, 1, 5 };
        System.out.println(firstMissingPositive(arr));
    }

    static int firstMissingPositive(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            if (arr[i] > 0 && arr[i] <= arr.length) {
                int correct = arr[i] - 1;
                if (arr[correct] != arr[i]) {
                    swap(arr, i, correct);
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return index + 1;
            }
        }

        return -1;
    }

    static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
