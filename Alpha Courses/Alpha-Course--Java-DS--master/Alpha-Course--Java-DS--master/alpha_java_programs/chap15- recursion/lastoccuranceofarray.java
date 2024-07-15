//Write a function to find the first occurance of the first element in an array
public class lastoccuranceofarray {
    public static int lastoccur(int arr[], int i, int key) {
        if(i == arr.length) {
            return -1;
        }
        
        int isFound = lastoccur(arr, i+1, key);
        if(isFound != -1) {
            return isFound;
        }

        //check with self if the above condition is false
        if(arr[i] == key) {
            return i;
        }

        return isFound;
    }

    public static void main(String[] args) {
        int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        System.out.println(lastoccur(arr, 0, 5));
    }
}