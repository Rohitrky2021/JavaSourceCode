// WAP to search rotated sorted array in java
public class rotatedsortedarray {
    public static int search(int arr[], int tar, int si, int ei) {
        // base case
        if(si > ei) {
            return -1;
        }
        
        //working
        int mid = si + (ei-si) / 2;

        // case found
        if(arr[mid] == tar) {
            return mid;
        }

        // mid is on line 1
        if(arr[si] <= arr[mid]) {
            // case a: search on left
            if(arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid-1);
            } 
            else {
                // case b: search on right
                return search(arr, tar, mid+1, ei);
            }
        }

        // mid is on line 2
        else {
            // case c: search on right
            if(arr[mid] <= tar && tar<= arr[ei]) {
                return search(arr, tar, mid+1, ei);
            }
            else {
                // case d: search on left
                return search(arr, tar, si, mid-1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int taridx = search(arr, target, 0, arr.length-1);
        System.out.println(taridx);
    }
}
