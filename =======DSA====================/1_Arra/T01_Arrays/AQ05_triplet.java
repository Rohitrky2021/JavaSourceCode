package T01_Arrays;

import java.util.*;

public class AQ05_triplet {
    static List<List<Integer>> threeSum(int arr[]) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(arr[i]);
                        triplet.add(arr[j]);
                        triplet.add(arr[k]);
                        Collections.sort(triplet);
                        if (!result.contains(triplet)) {
                            result.add(triplet);
                        }

                    }
                }
            }
        }
        return result;
    }
}
