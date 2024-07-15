import java.util.*;
public class tw {
    public static int twoSumCount(int[] arr, int target) {
        int count = 0;
        int left = 0;
        int right = arr.length - 1;
        Arrays.sort(arr);
    
        while (left < right) {
            if (left != 0 && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }
    
            int sum = arr[left] + arr[right];
    
            if (sum == target) {
                count++;
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    
        return count;
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 13, 11, 6, 6, 3, 3};
        int target = 12;
        int pairCount = twoSumCount(arr, target);
        System.out.println(pairCount);
    }
    
}
 

public class UniquePairsWithSum {
    public static void findUniquePairs(int[] arr, int k) {
        Set<Integer> seenNumbers = new HashSet<>();
        Set<Integer> uniquePairs = new HashSet<>();

        for (int num : arr) {
            int complement = k - num;

            if (seenNumbers.contains(complement)) {
                // Found a unique pair
                uniquePairs.add(Math.min(num, complement) + "-" + Math.max(num, complement));
            }

            seenNumbers.add(num);
        }

        for (String pair : uniquePairs) {
            System.out.println(pair);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 7;

        findUniquePairs(arr, k);
    }
}
