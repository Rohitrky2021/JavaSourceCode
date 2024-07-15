import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class E_Enemy_is_weak {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) nums[i] = Integer.parseInt(parts[i]);
        Solution solution = new Solution();
        System.out.println(solution.approach2(nums));
    }
}

class Solution {
    public long approach1(int[] nums) {
        int[] ngl = numGreaterToLeft(nums);
        int[] nsr = numSmallerToRight(nums);
 
        long triplets = 0L;
        for(int i = 0; i < nums.length; i++) {
            triplets += ngl[i] * 1L * nsr[i];
        }
        return triplets;
    }

    public long approach2(int[] nums) {
        Pair[] pairs = new Pair[nums.length];
        int[] active = new int[nums.length];
        SegmentTree tree = new SegmentTree(active);
        for(int i = 0; i < nums.length; i++) pairs[i] = new Pair(nums[i], i);

        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p2.value, p1.value));

        long triplets = 0L;
        for(int i = pairs.length - 1; i >= 0; i--) {
            int actualIndex = pairs[i].index;
            long numSmallRight = tree.query(actualIndex, active.length - 1);
            long totalRight = pairs.length - actualIndex - 1;
            long numGreaterRight = totalRight - numSmallRight;

            long totalGreater = i;
            long numGreaterLeft = totalGreater - numGreaterRight;

            triplets += numGreaterLeft * numSmallRight;
            tree.update(actualIndex, 1);
        }
        return triplets;
    }

    private int[] numGreaterToLeft(final int[] nums) {
        int[] ngl = new int[nums.length];
        Pair[] pairs = new Pair[nums.length];
        int[] active = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p2.value, p1.value));
        SegmentTree tree = new SegmentTree(active);
        for(int i = 0; i < pairs.length; i++) {
            int actualIndex = pairs[i].index;
            ngl[actualIndex] = tree.query(0, actualIndex);
            tree.update(actualIndex, 1);
        }
        return ngl;
    }

    private int[] numSmallerToRight(final int[] nums) {
        int[] nsr = new int[nums.length];
        Pair[] pairs = new Pair[nums.length];
        int[] active = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p2.value, p1.value));
        SegmentTree tree = new SegmentTree(active);
        for(int i = pairs.length - 1; i >= 0; i--) {
            int actualIndex = pairs[i].index;
            nsr[actualIndex] = tree.query(actualIndex, active.length - 1);
            tree.update(actualIndex, 1);
        }
        return nsr;
    }
}

class Pair {
    int value;
    int index;
    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class SegmentTree {
    private final int[] arr;
    private final int[] tree;

    SegmentTree(final int[] arr) {
        this.arr = arr;
        this.tree = new int[4 * arr.length];
    }

    private void updateHelper(int index, int value, int arrLeftIndex, int arrRightIndex, int treeIndex) {
        if(arrLeftIndex == arrRightIndex) {
            tree[treeIndex] = value;
            return;
        }
        int mid = (arrLeftIndex + arrRightIndex) / 2;
        if(index <= mid) updateHelper(index, value, arrLeftIndex, mid, 2 * treeIndex + 1);
        else updateHelper(index, value, mid + 1, arrRightIndex, 2 * treeIndex + 2);
        tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
    }

    private int queryHelper(int queryLeftIndex, int queryRightIndex, int arrLeftIndex, int arrRightIndex, int treeIndex) {
        if(outOfRange(queryLeftIndex, queryRightIndex, arrLeftIndex, arrRightIndex)) return 0;
        if(completeOverlap(queryLeftIndex, queryRightIndex, arrLeftIndex, arrRightIndex)) return tree[treeIndex];
        int mid = (arrLeftIndex + arrRightIndex) / 2;
        return queryHelper(queryLeftIndex, queryRightIndex, arrLeftIndex, mid, 2 * treeIndex + 1) + 
                queryHelper(queryLeftIndex, queryRightIndex, mid + 1, arrRightIndex, 2 * treeIndex + 2);
    }

    private boolean outOfRange(int queryLeftIndex, int queryRightIndex, int arrLeftIndex, int arrRightIndex) {
        return queryRightIndex < arrLeftIndex || queryLeftIndex > arrRightIndex;
    }

    private boolean completeOverlap(int queryLeftIndex, int queryRightIndex, int arrLeftIndex, int arrRightIndex) {
        return queryLeftIndex <= arrLeftIndex && arrRightIndex <= queryRightIndex;
    }

    public void update(int index, int value) {
        updateHelper(index, value, 0, arr.length - 1, 0);
    }

    public int query(int queryLeftIndex, int queryRightIndex) {
        return queryHelper(queryLeftIndex, queryRightIndex, 0, arr.length - 1, 0);
    }
}