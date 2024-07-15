public class C {

    public static int getMaxSum(int[] arr1, int[] arr2) {
        return getMaxSumRecursive(arr1, arr2, 0, 0, 0, 0);
    }

    public static int getMaxSumRecursive(int[] arr1, int[] arr2, int index1, int index2, int sum1, int sum2) {
        // Base case: If both arrays are exhausted, return the maximum sum
        if (index1 == arr1.length && index2 == arr2.length) {
            return Math.max(sum1, sum2);
        }

        // Find the first index where elements are not equal
        int i = index1;
        while (i < arr1.length && index2 < arr2.length && arr1[i] == arr2[index2]) {
            i++;
            index2++;
        }

        // Calculate the sum by considering two possibilities:
        // 1. Continue with arr1 and add arr1[i] to sum1
        // 2. Continue with arr2 and add arr2[index2] to sum2
        int sum1WithArr1 = sum1 + (i < arr1.length ? arr1[i] : 0);
        int sum2WithArr2 = sum2 + (index2 < arr2.length ? arr2[index2] : 0);

        // Recursively find the maximum sum by considering both possibilities
        return Math.max(
            getMaxSumRecursive(arr1, arr2, i + 1, index2, sum1WithArr1, sum2),
            getMaxSumRecursive(arr1, arr2, index1, index2 + 1, sum1, sum2WithArr2)
        );
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 3, 4, 5, 6};

        int maxSum = getMaxSum(arr1, arr2);
        System.out.println("Maximum sum: " + maxSum);
    }
}
