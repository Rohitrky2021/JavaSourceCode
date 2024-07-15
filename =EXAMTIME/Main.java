import java.util.Arrays;

public class Main{
    public long[] solve(int[] A, int[][] B) {
        long[] results = new long[B.length];
        for (int i = 0; i < B.length; i++) {
            int[] q = B[i];
            int l = q[1] - 1;
            int r = q[2] - 1;
            int v = q[3];
            switch (q[0]) {
                case 1:
                    for (int j = l; j <= r; j++)
                        A[j] = v;
                    break;
                case 2:
                    for (int j = l; j <= r; j++)
                        A[j] |= v;
                    break;
                case 3:
                    long sum = 0;
                    for (int j = l; j <= r; j++) {
                        int minVal = A[j];
                        for (int k = j; k <= r; k++) {
                            minVal = Math.min(minVal, A[k]);
                            sum += minVal;
                        }
                    }
                    results[i] = sum;
                    break;
            }
        }
        return results;
    }
}
