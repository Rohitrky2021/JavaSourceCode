package Recursion.SubsetSubsequenceStringQuestions;

import java.util.ArrayList;
import java.util.List;

public class SubsetsWithDuplicateElements {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 2 };
        System.out.println(subsetsWithDuplicates(arr));
    }

    static List<List<Integer>> subsetsWithDuplicates(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        int s = 0;
        int e = 0;
        for (int i = 0; i < arr.length; i++) {
            s = 0;
            if (i > 0 && arr[i] == arr[i - 1]) {
                s = e + 1;
            }
            e = outer.size() - 1;
            int n = outer.size();
            for (int j = s; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
