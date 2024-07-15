 
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Max_distinct_element {
    public static int findMaxDistinctItems(int n, int k, int[] arr) {

        int m=arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        Set<Integer> distinctItems = new HashSet<>();

        for (int item : arr) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
            distinctItems.add(item);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!freqMap.containsKey(i)) {
                if (k >= 1) {
                    cnt++;
                    k -= i;
                }
            }
        }

        return cnt + distinctItems.size();
    }

    public static void main(String[] args) {
        // Test the method with sample input
        int n = 10;
        int k = 3;
        int[] arr = {1,3,8};
        System.out.println(findMaxDistinctItems(n, k, arr)); // Output will depend on the input parameters
    }
}


// Try this

// from collections import Counter

// def find_max_distinct_items(n, k, arr):
//     freq_map = Counter(arr)
//     distinct_items = set(arr)
//     cnt = 0  
//     for i in range(1, n + 1):
//         if freq_map.get(i, 0) == 0:
//             if k >= 1:
//                 cnt += 1
//                 k -= i              
//     return cnt + len(distinct_items)