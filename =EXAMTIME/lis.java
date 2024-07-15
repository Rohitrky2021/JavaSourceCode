import java.util.*;

public class lis {

    public static int countPairsWithDifference(int[] arr, int k) {
         HashMap<Integer, Integer> elementCountMap = new HashMap<>();
        //  List<Pair<Double, Integer>> wageToQualityRatioList = new ArrayList<>();


         for (int num : arr) {
            elementCountMap.put(num, elementCountMap.getOrDefault(num, 0) + 1);
        }

         int pairCount = 0;

        for (int num : arr) {
             if (elementCountMap.containsKey(num - k) ) {
                pairCount++;
            }
            if (( elementCountMap.containsKey(num + k)) ) {
                pairCount++;
            }
        }

        return pairCount;
    }

    public static void main(String[] args) {
         int[] arr = {7,10,13,11};
        int k = 3;

        int result = countPairsWithDifference(arr, k);
        System.out.println("Number of pairs with difference " + k + ": " + result);
    }
}
