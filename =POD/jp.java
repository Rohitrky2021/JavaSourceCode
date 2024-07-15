import java.util.*;

public class jp {
    public static List<Integer> kthOccurrence(int X, List<Integer> arr, List<Integer> query_values) {
        List<Integer> result = new ArrayList<>();
        
        // Create a map to store the indices of each unique number in arr
        Map<Integer, List<Integer>> numIndicesMap = new HashMap<>();
        
        // Populate the map
        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            if (!numIndicesMap.containsKey(num)) {
                numIndicesMap.put(num, new ArrayList<>());
            }
            numIndicesMap.get(num).add(i + 1); // 1-based index
        }
        
        // Iterate through the query_values
        for (int num : query_values) {
            if (numIndicesMap.containsKey(X)) {
                List<Integer> indices = numIndicesMap.get(X);
                if (indices.size() >= num) {
                    result.add(indices.get(num-1)); // Get the k-th index
                } else {
                    result.add(-1); // Not enough occurrences
                }
            } else {
                result.add(-1); // Number not found in arr
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int X = 8;
        List<Integer> arr = Arrays.asList(1, 2, 20, 8, 8, 1, 2, 5, 8, 0);
        List<Integer> query_values = Arrays.asList(100, 4, 2);
        
        List<Integer> result = kthOccurrence(X, arr, query_values);
        
        for (int i : result) {
            System.out.println(i);
        }
    }
}
