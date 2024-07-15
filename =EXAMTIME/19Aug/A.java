import java.util.ArrayList;
import java.util.List;

class NumArray {
    int n;
    int[] st;  
    int[] nums;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.st = new int[4 * n];
        build(0, 0, n - 1);
    }

    public void update(int index, int val) {
        pointUpdate(0, 0, n - 1, index, val);
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private void build(int index, int low, int high) {
        if (low == high) {
            st[index] = nums[low];
            return;
        }
        int mid = (low + high) / 2;
        build(2 * index + 1, low, mid);
        build(2 * index + 2, mid + 1, high);

        st[index] = st[2 * index + 1] + st[2 * index + 2];
    }

    private int query(int index, int low, int high, int l, int r) {
        if (low >= l && high <= r) {
            return st[index];
        }
        if (low > r || high < l) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        int left_result = query(2 * index + 1, low, mid, l, r);
        int right_result = query(2 * index + 2, mid + 1, high, l, r);
        return left_result + right_result;
    }

    private void pointUpdate(int index, int low, int high, int node, int val) {
        if (low == high) {
            st[index] = val;
            nums[node] = val;
            return;
        }
        int mid = low + (high - low) / 2;
        if (node <= mid) {
            pointUpdate(2 * index + 1, low, mid, node, val);
        } else {
            pointUpdate(2 * index + 2, mid + 1, high, node, val);
        }
        st[index] = st[2 * index + 1] + st[2 * index + 2];
    }

     public long subArraySum(int left, int right) {
        long sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i] * (i - left + 1) * (right - i + 1);
        }
        return sum;
    }
}

public class A {

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
                long sum = numArray.subArraySum(L, R);
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
