public class B {

    public static int getMaxSum(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i = 0, j = 0;
        int maxSum = 0;
        int currentSum = 0;

        while (i < len1 && j < len2) {
            if (arr1[i] < arr2[j]) {
                currentSum += arr1[i];
                i++;
            } else if (arr1[i] > arr2[j]) {
                currentSum += arr2[j];
                j++;
            } else { // Elements are equal
                maxSum += Math.max(currentSum + arr1[i], currentSum + arr2[j]);
                currentSum = 0;
                i++;
                j++;
            }
        }

        // Add remaining elements from arr1 if any
        while (i < len1) {
            currentSum += arr1[i];
            i++;
        }

        // Add remaining elements from arr2 if any
        while (j < len2) {
            currentSum += arr2[j];
            j++;
        }

        maxSum += currentSum;
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,2,3};
        int[] arr2 = {2, 2 ,2};

        int maxSum = getMaxSum(arr1, arr2);
        System.out.println("Maximum sum: " + maxSum);
    }
}
