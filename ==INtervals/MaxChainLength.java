// https://leetcode.com/problems/maximum-length-of-pair-chain/description/

public class MaxChainLength {
    
}

class Solution {

    public int findLongestChain(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] mergedInterval = intervals[0];
        System.out.println(mergedInterval[0] + " " + mergedInterval[1]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

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

// --->M1.2 SAME using PQ;

 
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



M2---------------->

class Solution {
    public int findLongestChain(int[][] pairs) {
        /*
         * so we have pairs like (1 2) and (3 4)
         *
         *   1. (1 2) would not "lead to" (2 3) because 2 = 2
         *
         *   2. (1 2) would "lead to" (3 4) because 2 < 3
         *
         * so given that you can form chains of 2, 3, or more pairs,
         * what is the longest length of any valid chain of pairs?
         *
         *
         * can I just greedily search for the single longest?
         *
         *
         * I can sort pairs by forming longs
         *
         *      ( end ) ( start )
         */
        final var N = pairs.length;

        final var P = new long[N];
        for (int i = 0; i < N; i++) {
            final long hi = ((long) pairs[i][1]) << 32;
            final long lo = 0xffff_ffffL & pairs[i][0];
            P[i] = hi | lo;
        }

        Arrays.sort(P);

        var size = 0;
        var lastEnd = Integer.MIN_VALUE;

        for (final var pair : P) {
            final var start = (int) pair;

            if (start > lastEnd) {
                size++;
                lastEnd = (int) (pair >>> 32);
            }
        }

        return size;
    }
}
