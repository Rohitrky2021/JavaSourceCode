public class MeetingroomIntArrSolution {

}

// https://www.youtube.com/watch?v=NKf1OJhEZj0

public class Solution {

    TreeMap<Integer, Integer> map = new TreeMap();

    public int solve(int[][] A) {
        if (A.length == 0)
            return 0;
        for (int i = 0; i < A.length; i++) {
            map.put(A[i][0], map.getOrDefault(A[i][0], 0) + 1);
            map.put(A[i][1], map.getOrDefault(A[i][1], 0) - 1);
        }

        int count = 0;
        int max = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count = count + entry.getValue();
            max = Math.max(max, count);
        }
        return max;
    }
}

public class Solution {
    public int solve(int[][] arr) {
        int[] startTimes = new int[arr.length];
        int[] endTimes = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            startTimes[i] = arr[i][0];
            endTimes[i] = arr[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int i = 0, j = 0, count = 0, maxCount = 0;
        while (i < arr.length && j < arr.length) {
            // A new meeting is starting before a meeting ends, so a new room is needed
            if (startTimes[i] < endTimes[j]) {
                i++;
                count++;
            } else {
                j++;
                count--; // ROom not needed set kr denge kissi previous room m
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}

public class Solution {
    public int solve(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }

        Arrays.sort(A, (a, b) -> Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        /*
         * int count = 0;
         * int temp = 0;
         */

        q.add(A[0]);
        for (int i = 1; i < A.length; i++) {
            int[] curr = A[i];
            int[] prev = q.poll();
            if (curr[0] < prev[1]) {
                q.add(prev);
                q.add(curr);
                // temp = 0;
            } else {
                prev[1] = curr[1];
                q.add(prev);
                // temp++;
                // count = Math.max(count,temp);
            }
        }
        return q.size();
    }
}
