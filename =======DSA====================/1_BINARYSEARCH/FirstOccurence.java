public class FirstOccurence {
    // https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1

    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 4, 5, 6, 6};
        int target = 4;
        
        int firstOccurrence = findFirstOccurrence(arr, target);
        int lastOccurrence = findLastOccurrence(arr, target);
        
        System.out.println("First Occurrence: " + firstOccurrence);
        System.out.println("Last Occurrence: " + lastOccurrence);
    }
    
    private static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;  // Look in the left half for the first occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;  // Look in the right half for the last occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}
