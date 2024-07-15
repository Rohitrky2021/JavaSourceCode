package T05_Recursion;

public class LastOccurrence {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 2, 1, 3, 5, 3, 5, 3, 4, 4 };
        System.out.println(firOccr(arr, 15, 0));

    }

    public static int firOccr(int arr[], int k, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[arr.length - 1 - i] == k) {
            return arr.length - 1 - i;
        }

        return firOccr(arr, k, i + 1);

    }
}
