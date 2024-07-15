import java.util.ArrayList;
import java.util.List;

class NumArray {
    int[] nums;
    long[] prefixSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.prefixSum = new long[nums.length + 1];
        buildPrefixSum();
    }

    private void buildPrefixSum() {
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        for (int i = index + 1; i < prefixSum.length; i++) {
            prefixSum[i] += diff;
        }
    }

    public long subArraySum(int left, int right) {
        long sum = 0;
        for (int i = left; i <= right; i++) {
            sum += (prefixSum[right + 1] - prefixSum[i]) * (i - left + 1);
        }
        return sum;
    }
}

public class C {

    public static List<Long> solve(int N, int Q, int[] A, int[][] queries) {
        NumArray numArray = new NumArray(A);
        List<Long> result = new ArrayList<>();

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
                result.add(sum);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        int Q = 2;
        int[] A = {2, 1, 4, 3, 1};
        int[][] queries = {{1, 2, 2}, {2, 1, 3}};

        List<Long> result = solve(N, Q, A, queries);
        for (long res : result) {
            System.out.println(res);
        }
    }
}
