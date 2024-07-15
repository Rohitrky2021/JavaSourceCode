public class NonOverlapingIntervals {

    // https://leetcode.com/problems/merge-intervals/


    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return new int[0][];
            }
    
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    
            List<int[]> merged = new ArrayList<>();
            int[] mergedInterval = intervals[0];
            System.out.println(mergedInterval[0]+" "+mergedInterval[1] );
    
            for (int i = 1; i < intervals.length; i++) {
                int[] interval = intervals[i];
                
                if (interval[0] <= mergedInterval[1]) {
                    mergedInterval[1] = Math.max(mergedInterval[1], interval[1]);
                } else {
                    merged.add(mergedInterval);
                    mergedInterval = interval; 
                }
            }
    
            merged.add(mergedInterval);
    
            return merged.toArray(new int[merged.size()][]);        
        }
    }
}
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
//  and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
