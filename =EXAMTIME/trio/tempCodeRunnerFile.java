import java.util.ArrayList;

public class Solution {
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
    private static void buildSegmentTree(int[] arr, SegmentTreeNode[] segmentTree, int start, int end, int current) {
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
    private static void updateSegmentTree(int[] arr, SegmentTreeNode[] segmentTree, int start, int end, int current, int left, int right, int val) {
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
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = A.get(i);
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
                long andValue = querySegmentTree(segmentTree, 0, N - 1, 0, l, r);
                result.add(andValue);
            }
        }

        return result;
    }
