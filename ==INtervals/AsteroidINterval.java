public class AsteroidINterval {
    public int[][] inter(int[][] f1, int[][] s2) {
        // Check if either of the input arrays is null or empty
        if (f1 == null || f1.length == 0 || s2 == null || s2.length == 0) {
            return new int[0][];
        }
    
        // Sort the input arrays by the start of each interval
        Arrays.sort(f1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(s2, (a, b) -> Integer.compare(a[0], b[0]));
    
        List<int[]> merged = new ArrayList<>();
        int i = 0, j = 0;
    
        while (i < f1.length && j < s2.length) {
            int[] interval1 = f1[i];
            int[] interval2 = s2[j];
    
            // Calculate the intersection of the two intervals
            int start = Math.max(interval1[0], interval2[0]);
            int end = Math.min(interval1[1], interval2[1]);
    
            // If there is an intersection (start <= end), add it to the result
            if (start <= end) {
                merged.add(new int[]{start, end});
            }
    
            // Move to the next interval in one of the arrays
            if (interval1[1] < interval2[1]) {
                i++;
            } else {
                j++;
            }
        }
    
        // Convert the List of merged intervals to a 2D array
        int[][] result = new int[merged.size()][2];
        for (int k = 0; k < merged.size(); k++) {
            result[k] = merged.get(k);
        }
    
        return result.length;
    }
    