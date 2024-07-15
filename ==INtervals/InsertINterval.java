public class InsertINterval {
    // https://leetcode.com/problems/insert-interval/description/
    // class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         List<int[]> merged = new ArrayList<>();
        
//         int i = 0;
//         while (i < intervals.length && intervals[i][1] < newInterval[0]) {
//             merged.add(intervals[i]);
//             i++;
//         }
        
//         while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
//             newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
//             newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
//             i++;
//         }
        
//         merged.add(newInterval);
        
//         while (i < intervals.length) {
//             merged.add(intervals[i]);
//             i++;
//         }
        
//         return merged.toArray(new int[merged.size()][]);
//     }
// }
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval}; // Return the newInterval as a single-element array
        }

        List<int[]> merged = new ArrayList<>();
        int[] mergedInterval = newInterval; // Initialize mergedInterval with newInterval

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (mergedInterval[1] < interval[0]) {
                // If mergedInterval ends before the current interval starts, add mergedInterval
                merged.add(mergedInterval);
                mergedInterval = interval; // Start a new mergedInterval
            } else if (interval[1] < mergedInterval[0]) {
                // If the current interval ends before mergedInterval starts, add the current interval
                merged.add(interval);
            } else {
                // Overlapping intervals, update mergedInterval
                mergedInterval[0] = Math.min(mergedInterval[0], interval[0]);
                mergedInterval[1] = Math.max(mergedInterval[1], interval[1]);
            }
        }

        merged.add(mergedInterval);

        return merged.toArray(new int[merged.size()][]);
    }
}


}
