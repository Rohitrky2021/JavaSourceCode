// input: nums = [4,5,6,7,0,1,2] , target = 0;
// output: 4 (index of 0)
package T01_Arrays;

public class AQ02_search_in_rotetedArray {

//     static int findPivot(int arr[]) { // O(log(n))
//         int s = 0;
//         int e = arr.length - 1;
//         while (s < e) {
//             int mid = s + (e - s) / 2;
//             if (mid > arr[0]) {
//                 s = mid + 1;
//             } else {
//                 e = mid - 1;
//             }
//         }
//         return s;
//     }
    static int findPivot(int arr[]) { // O(log(n))
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            
            if (mid > 0 && arr[mid] < arr[mid-1]){ 
                return mid;
            } else if(arr[s] < arr[mid] && arr[mid] > arr[e]){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return s;
    }

    static int search(int arr[], int k) {  // O(log(n))
        int pivot = findPivot(arr);
        if (k >= arr[pivot] && k <= arr[arr.length - 1]) {
            return binarySearch(arr, pivot, arr.length, k);
        } else {
            return binarySearch(arr, 0, pivot, k);
        }
    }

    static int binarySearch(int arr[], int s, int e, int k) { // only for sorted Array or list

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1; // not found
    }

}
