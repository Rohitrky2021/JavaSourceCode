import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class union {

    public static List<Integer> subsetA(int[] arr) {
        // Sort the array in descending order
        Arrays.sort(arr);
        reverseArray(arr);

        List<Integer> subsetA = new ArrayList<>();
        List<Integer> subsetB = new ArrayList<>();

        int sumA = 0;
        int sumB = 0;
        sumA+=arr[1];
        subsetA.add(arr[1]);

      for (int i = 2; i < arr.length; i++) {
        
          if (sumA -arr[i] <=sumB || subsetB.contains(arr[i])) {
              subsetA.add(arr[i]);
              sumA += arr[i];
          } else {
              subsetB.add(arr[i]);
              sumB += arr[i];
          }
      
      }

        return subsetA;
    }

    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 5, 6, 2};
        List<Integer> result = subsetA(arr);

        System.out.println("Subset A: " + result);
    }
}
