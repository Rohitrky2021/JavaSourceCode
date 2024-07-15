import java.util.*;

public class stream {

    public static List<Integer> runningMedian(int[] arr) {
        List<Integer> medians = new ArrayList<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            addNumber(num, maxHeap, minHeap);
            rebalanceHeaps(maxHeap, minHeap);
            medians.add(getMedian(maxHeap, minHeap));
        }

        return medians;
    }

    // Add number to the appropriate heap
    private static void addNumber(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
    }

    // Rebalance heaps to ensure the size difference is at most 1
    private static void rebalanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    // Calculate the median
    private static int getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 11, 9, 5};
        List<Integer> result = runningMedian(arr);

        for (Integer median : result) {
            System.out.print(median + " ");
        }
    }
}
