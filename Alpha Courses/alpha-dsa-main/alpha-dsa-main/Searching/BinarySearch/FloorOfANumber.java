package BinarySearch;

public class FloorOfANumber {
    public static void main(String args[]) {
        int[] arr = {2, 4, 6, 8, 10};
        int target = 90;
        System.out.println(floorNumber(arr, target));
    }

    static int floorNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return end;
    }
}
