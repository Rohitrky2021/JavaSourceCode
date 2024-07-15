package T01_Arrays;

public class A07_max_subArr_sum {
    static int bruteForce(int arr[]) {
        int ms = 0; // maxSum

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int cs = 0; // currSum
                for (int j2 = i; j2 <= j; j2++) {
                    cs += arr[j2];
                    ms = ms < cs ? cs : ms;
                }
            }
        }
        return ms;
    }

    static int prefixSum(int arr[]) {
        int cs = 0; // maxSum
        int ms = 0; // currSum
        int preSum[] = new int[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                cs = preSum[j] - preSum[i - 1];
                ms = ms < cs ? cs : ms;
            }
        }
        return ms;
    }

    static int kadaneAlgo(int arr[], int n) {
        int ms = 0;
        int cs = 0;
        for (int i = 0; i < n; i++) {
            cs += arr[i];
            cs = cs < 0 ? 0 : cs;
            ms = ms < cs ? cs : ms;
        }
        return ms;
    }
}
