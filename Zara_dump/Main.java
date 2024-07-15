import java.util.ArrayList;

public class Main {
    // Segment Tree Node
    static class SegmentTreeNode {
        long andValue; // Stores the bitwise AND of the range
        long orValue; // Stores the bitwise OR of the range

        public SegmentTreeNode() {
            this.andValue = 0;
            this.orValue = 0;
        }
    }

    // Function to build the Segment Tree
    private static void buildSegmentTree(long[] arr, SegmentTreeNode[] segmentTree, int start, int end, int current) {
        if (start == end) {
            segmentTree[current].andValue = arr[start];
            segmentTree[current].orValue = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        buildSegmentTree(arr, segmentTree, start, mid, 2 * current + 1);
        buildSegmentTree(arr, segmentTree, mid + 1, end, 2 * current + 2);

        segmentTree[current].andValue = segmentTree[2 * current + 1].andValue & segmentTree[2 * current + 2].andValue;
        segmentTree[current].orValue = segmentTree[2 * current + 1].orValue | segmentTree[2 * current + 2].orValue;
    }

    // Function to perform range OR update in the Segment Tree
    private static void updateSegmentTree(long[] arr, SegmentTreeNode[] segmentTree, int start, int end, int current, int left, int right, int val) {
        if (left > end || right < start) {
            return;
        }

        if (start == end) {
            segmentTree[current].andValue = arr[start] | val;
            segmentTree[current].orValue = arr[start] | val;
            return;
        }

        int mid = (start + end) / 2;
        updateSegmentTree(arr, segmentTree, start, mid, 2 * current + 1, left, right, val);
        updateSegmentTree(arr, segmentTree, mid + 1, end, 2 * current + 2, left, right, val);

        segmentTree[current].andValue = segmentTree[2 * current + 1].andValue & segmentTree[2 * current + 2].andValue;
        segmentTree[current].orValue = segmentTree[2 * current + 1].orValue | segmentTree[2 * current + 2].orValue;
    }

    // Function to perform range AND query in the Segment Tree
    private static long querySegmentTree(SegmentTreeNode[] segmentTree, int start, int end, int current, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && right >= end) {
            return segmentTree[current].andValue;
        }

        int mid = (start + end) / 2;
        long leftValue = querySegmentTree(segmentTree, start, mid, 2 * current + 1, left, right);
        long rightValue = querySegmentTree(segmentTree, mid + 1, end, 2 * current + 2, left, right);

        return leftValue & rightValue;
    }

    public ArrayList<Long> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int N = A.size();
        long[] arr = new long[N];
        for (int  i = 0; i < N; i++) {
            arr[i] = (long) A.get(i);
        }

        // Build the Segment Tree
        int treeSize = 2 * (int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2))) - 1;
        SegmentTreeNode[] segmentTree = new SegmentTreeNode[treeSize];
        for (int i = 0; i < treeSize; i++) {
            segmentTree[i] = new SegmentTreeNode();
        }

        buildSegmentTree(arr, segmentTree, 0, N - 1, 0);

        ArrayList<Long> result = new ArrayList<>();

        for (ArrayList<Integer> query : B) {
            int type = query.get(0);
            int l = query.get(1) - 1; // Convert to 0-based indexing
            int r = query.get(2) - 1; // Convert to 0-based indexing
            int v = query.get(3);

            if (type == 1) {
                updateSegmentTree(arr, segmentTree, 0, N - 1, 0, l, r, v);
            } else if (type == 2) {
                updateSegmentTree(arr, segmentTree, 0, N - 1, 0, l, r, v);
            } else if (type == 3) {
                long andValue =1;
                for (int i = l; i < r; i++) {
                    andValue&=arr[i];
                }
                result.add(andValue);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Main solution = new Main();

        // Sample Input 1
        ArrayList<Integer> A1 = new ArrayList<>();
        A1.add(1);
        A1.add(0);
        A1.add(2);
        A1.add(5);
        ArrayList<ArrayList<Integer>> B1 = new ArrayList<>();
        B1.add(new ArrayList<>(java.util.Arrays.asList(3, 1, 3, 0)));
        B1.add(new ArrayList<>(java.util.Arrays.asList(1, 1, 2, 4)));
        B1.add(new ArrayList<>(java.util.Arrays.asList(2, 2, 4, 5)));
        B1.add(new ArrayList<>(java.util.Arrays.asList(3, 1, 4, 0)));
        ArrayList<Long> result1 = solution.solve(A1, B1);
        System.out.println("Sample Output 1 - " + result1);

        // Sample Input 2
        ArrayList<Integer> A2 = new ArrayList<>();
        A2.add(5);
        A2.add(4);
        A2.add(3);
        A2.add(2);
        A2.add(1);
        ArrayList<ArrayList<Integer>> B2 = new ArrayList<>();
        B2.add(new ArrayList<>(java.util.Arrays.asList(3, 2, 4, 0)));
        B2.add(new ArrayList<>(java.util.Arrays.asList(1, 1, 2, 8)));
        B2.add(new ArrayList<>(java.util.Arrays.asList(2, 2, 4, 2)));
        B2.add(new ArrayList<>(java.util.Arrays.asList(3, 1, 3, 0)));
        B2.add(new ArrayList<>(java.util.Arrays.asList(3, 3, 5, 0)));
        ArrayList<Long> result2 = solution.solve(A2, B2);
        System.out.println("Sample Output 2 - " + result2);
        System.out.println(4&5&7);
    }
}
