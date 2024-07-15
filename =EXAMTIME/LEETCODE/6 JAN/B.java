public class Solution {
    private int r(int a) {
        return a & 1;
    }

    private int u(int a) {
        return a;
    }

    public int minOperations(int[] n, int k) {
        isSorted(n);
        int x = 0;
        for (int i : n) {
            x ^= i;
        }

        int res = 0;
        k ^= x; 
         isSorted(n);
        while (k > 0) {
            res += r(k);
            k >>= 1;
        }
        

        return u(res);
    }

        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
