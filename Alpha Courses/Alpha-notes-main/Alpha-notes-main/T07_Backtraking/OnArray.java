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
