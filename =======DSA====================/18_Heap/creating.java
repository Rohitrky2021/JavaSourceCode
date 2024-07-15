import java.util.*;
public class creating {
    public static void main (String args[]){
        
        int[] arr = {5, 2, 8, 1, 6};
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }
        
        // Clear the heap and add elements using the heapify function
        minHeap.clear();
        minHeap.addAll(Arrays.asList(arr));
        
        // Alternatively, use the Collections class to heapify the array
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.heapify(list);
        
        // Now the heap contains the same elements as the array
        int minElement = minHeap.peek();
    }
}
