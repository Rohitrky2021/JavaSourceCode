public class MinMergeInterval {
    // https://www.interviewbit.com/problems/disjoint-intervals/
    public class Solution {
        public int solve(ArrayList<ArrayList<Integer>> A) {
            
            int numRows = A.size();
    
            int[][] intervals = A.stream()
                    .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
                    .toArray(int[][]::new);
              if (intervals == null || intervals.length == 0) {
                    return 0;
                }
        
                Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
                List<int[]> merged = new ArrayList<>();
                int[] mergedInterval = intervals[0];
                // System.out.println(mergedInterval[0]+" "+mergedInterval[1] );
        
                for (int i = 1; i < intervals.length; i++) {
                    int[] interval = intervals[i];
                    
                    if (interval[0] <= mergedInterval[1]) {
                        mergedInterval[1] = Math.min(mergedInterval[1], interval[1]);// Not max used to Increase the Intervals
                    } else {
                        merged.add(mergedInterval);
                        mergedInterval = interval; 
                    }
                }
        
                merged.add(mergedInterval);
        
                return merged.size();         
                    
        }
    }
    
