import java.util.*;

// class Solution {
    // Same Code As before 
    public class SameTemplateUsingPQ {

    public int findLongestChain(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> mergedQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int[] interval : intervals) {
            if (mergedQueue.isEmpty() || interval[0] > mergedQueue.peek()[1]) {
                mergedQueue.add(interval);
            } else {
                int[] top = mergedQueue.poll();
                top[1] = Math.min(top[1], interval[1]);
                mergedQueue.add(top);
            }
        }

        return mergedQueue.size();
    }
}
 

class Solution {

    public int findLongestChain(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        for (int[] interval : intervals) {
            minHeap.offer(interval);
        }

        List<int[]> merged = new ArrayList<>();
        int[] mergedInterval = minHeap.poll();
        System.out.println(mergedInterval[0] + " " + mergedInterval[1]);

        while (!minHeap.isEmpty()) {
            int[] interval = minHeap.poll();

            if (interval[0] <= mergedInterval[1]) {
                mergedInterval[1] = Math.min(mergedInterval[1], interval[1]);
            } else {
                merged.add(mergedInterval);
                mergedInterval = interval;
            }
        }

        merged.add(mergedInterval);

        return merged.size();
    }
}
 