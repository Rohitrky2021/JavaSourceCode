public class EraseNonOverlappingInterval {
    // https://leetcode.com/problems/non-overlapping-intervals/editorial/
}
// M1--my SOln
class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = 0;
        
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (end > intervals[i][0]) {
                count++;
                end = Math.min(intervals[i][1], end);
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}

// M2-- LeetCode Editorial 
// Time complexity: O(n⋅log⁡n)
// Space Complexity: O(log⁡n) or O(n)O(n)O(n)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int k = Integer.MIN_VALUE;
        
        for (int i = 0; i < intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];
            
            if (x >= k) {
                // Case 1
                k = y;
            } else {
                // Case 2
                ans++;
            }
        }
        
        return ans;
    }
}