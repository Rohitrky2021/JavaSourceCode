
    import java.util.*;
    
        public class indexsort {
            public int[] customSortArray(int[] arr, int[] order) {
                // Create a map to store the indices of elements in the 'order' array
                Map<Integer, Integer> orderMap = new HashMap<>();
                for (int i = 0; i < order.length; i++) {
                    orderMap.put(order[i], i);
                }
        
                // Sort the 'arr' array using a custom comparator
                Arrays.sort(arr, (a, b) -> {
                    int indexA = orderMap.getOrDefault(a, Integer.MAX_VALUE);
                    int indexB = orderMap.getOrDefault(b, Integer.MAX_VALUE);
                    return indexA - indexB;
                });
        
                return arr;
            }
        
            public static void main(String[] args) {
                indexsort customSort = new indexsort();
                int[] arr = {2, 1, 3, 4, 2, 5};
                int[] order = {2, 3, 1};
        
                int[] sortedArr = customSort.customSortArray(arr, order);
                System.out.println(Arrays.toString(sortedArr));
            }
        }
        