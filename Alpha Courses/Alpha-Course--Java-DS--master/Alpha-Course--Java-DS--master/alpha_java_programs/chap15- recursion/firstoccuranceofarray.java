//Write a function to find the first occurance of the first element in an array
public class firstoccuranceofarray {
    public static int firstoccur(int arr[], int i, int key) {
        if(i == arr.length) {
            return -1;
        }

        if(arr[i] == key) {
            return 1;
        }

        return firstoccur(arr, i+1, key);
    }

    public static void main(String[] args) {
        int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        System.out.println(firstoccur(arr, 0, 5));
    }
}
