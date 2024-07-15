import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B {

    public static List<Integer> subsetA(List<Integer> arr) {
        // Sort the array in ascending order
        Collections.sort(arr);

        List<Integer> A = new ArrayList<>();
        int n = arr.size() - 1;
        long total = arr.stream().mapToLong(Integer::longValue).sum();
        long sumA = 0;

        for (int i = n; i > 0; i--) {
            if (sumA <= total - sumA) {
                A.add(arr.get(i));
                sumA += arr.get(i);
                arr.remove(i);

            } else {
                break;
            }
        }

        // Sort the final subset in ascending order
        Collections.sort(A);
        System.out.println(arr);

        return A;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,4,6,6,8,8,3);

        List<Integer> result = subsetA(new ArrayList<>(arr));

        System.out.println("Subset A: " + result);
    }
}
