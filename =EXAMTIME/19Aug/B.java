import java.util.ArrayList;
import java.util.List;

class NumArray {
    int n;
    int[] nums;
    Node[] st; // Segment tree array of nodes

    class Node {
        long sum;        // Sum of elements in the range
        long subArraySum; // Sum of all subarrays in the range

        Node(long sum, long subArraySum) {
            this.sum = sum;
            this.subArraySum = subArraySum;
        }
    }

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.st = new Node[4 * n];
        build(0, 0, n - 1);
    }

    public void update(int index, int val) {
        pointUpdate(0, 0, n - 1, index, val);
    }

    public long sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right).subArraySum;
    }

    private void build(int index, int low, int high) {
        if (low == high) {
            st[index] = new Node(nums[low], nums[low]);
            return;
        }
        int mid = (low + high) / 2;
        build(2 * index + 1, low, mid);
        build(2 * index + 2, mid + 1, high);

        st[index] = merge(st[2 * index + 1], st[2 * index + 2]);
    }

    private Node merge(Node left, Node right) {
        long sum = left.sum + right.sum;
        long subArraySum = left.subArraySum + right.subArraySum + left.sum * (right.sum + right.subArraySum);
        return new Node(sum, subArraySum);
    }

    private Node query(int index, int low, int high, int l, int r) {
        if (low >= l && high <= r) {
            return st[index];
        }
        if (low > r || high < l) {
            return new Node(0, 0); // Neutral element for the merge operation
        }
        int mid = low + (high - low) / 2;
        Node left_result = query(2 * index + 1, low, mid, l, r);
        Node right_result = query(2 * index + 2, mid + 1, high, l, r);
        return merge(left_result, right_result);
    }

    private void pointUpdate(int index, int low, int high, int node, int val) {
        if (low == high) {
            st[index] = new Node(val, val);
            nums[node] = val;
            return;
        }
        int mid = low + (high - low) / 2;
        if (node <= mid) {
            pointUpdate(2 * index + 1, low, mid, node, val);
        } else {
            pointUpdate(2 * index + 2, mid + 1, high, node, val);
        }
        st[index] = merge(st[2 * index + 1], st[2 * index + 2]);
    }
}

public class B {

    public static List<Integer> solve(int N, int Q, int[] A, int[][] queries) {
        NumArray numArray = new NumArray(A);
        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int type = query[0];
            if (type == 1) {
                int index = query[1] - 1;
                int val = query[2];
                numArray.update(index, val);
            } else if (type == 2) {
                int L = query[1] - 1;
                int R = query[2] - 1;
                long sum = numArray.sumRange(L, R);
                result.add((int) sum);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        int Q = 2;
        int[] A = {2, 1, 4, 3, 1};
        int[][] queries = {{1, 2, 2}, {2, 1, 3}};

        List<Integer> result = solve(N, Q, A, queries);
        for (int res : result) {
            System.out.println(res);
        }
    }
}
