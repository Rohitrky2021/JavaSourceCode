
public class MaximumOfArray {
    
    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("The array is empty.");
        }

        int maxVal = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }

        return maxVal;
    }
}
