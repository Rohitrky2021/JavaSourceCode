import java.util.*;
public class PermutaListBySwap {
    public List<int[]> listPermutations(int[] a) {
        ArrayList<int[]> results = new ArrayList<int[]>();
        listPermutations(a, 0, results);
        return results;
    }

    private void listPermutations(int[] a, int start, List<int[]> result) {
        if (start >= a.length) {
            result.add(a.clone());
        } else {
            for (int i = start; i < a.length; i++) {
                swap(a, start, i);
                listPermutations(a, start + 1, result);
                swap(a, start, i);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        PermutaListBySwap permGenerator = new PermutaListBySwap();

        // Test Case
        int[] inputArray = {1, 2, 3,4};
        List<int[]> permutations = permGenerator.listPermutations(inputArray);

        for (int[] permutation : permutations) {
            System.out.println(Arrays.toString(permutation));
        }
    }
}
