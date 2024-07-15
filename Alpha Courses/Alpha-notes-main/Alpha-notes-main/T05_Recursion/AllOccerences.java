package T05_Recursion;

public class AllOccerences {
    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        int t = 2;
        occer(arr, t, 0);
    }

    public static void occer(int arr[], int t, int i) {
        if (i >= arr.length) {
            System.out.println();
            return;
        }
        if (arr[i] == t) {
            System.out.print(i + " ");
        }
        occer(arr, t, i + 1);
    }
}
