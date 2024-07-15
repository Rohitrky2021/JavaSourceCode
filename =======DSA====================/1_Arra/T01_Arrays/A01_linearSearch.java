package T01_Arrays;

public class A01_linearSearch {

    static int linearSearch(int arr[], int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return i;
            }
        }
        return -1;
    }
}
