package BinarySearch;

public class CeilingOfANumber {
    public static void main(String args[]) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 19;
        int ceiling = ceilingNumber(arr, target);
        System.out.println(arr[ceiling]);
    }

    static int ceilingNumber(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (num < arr[mid]){
                end = mid-1;
            } else if (num > arr[mid]){
                start = mid+1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
