public class code {
    public static void main(String[] args) {
        // Example array
        int[] arr = {4,3,2,3,2,5,4,3};

        // Count the number of elements not equal to arr[0] or arr[1]
        int count = countElementsNotEqual(arr, arr[0], arr[1]);

        // Print the result
        System.out.println("Count of elements not equal to arr[0] or arr[1]: " + count);
    }

    private static int countElementsNotEqual(int[] arr, int num1, int num2) {
        int count = 0;

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != num1 && arr[i] != num2) {
                count++;
            }
        }

        return count;
    }
}
