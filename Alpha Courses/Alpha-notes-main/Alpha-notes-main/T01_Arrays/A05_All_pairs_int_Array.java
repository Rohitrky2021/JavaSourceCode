package T01_Arrays;

public class A05_All_pairs_int_Array {
    static void printPairs(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + ", " + arr[j] + ") ");
            }
            System.out.println();
        }
        System.out.println("total number of pair is: " + arr.length * (arr.length - 1) / 2);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        printPairs(arr);
    }
}
