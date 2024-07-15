
    
    import java.util.HashMap;

    public class M3Greedy {
        public int[] findLargestPermutation(int[] A, int B) {
            int N = A.length;
            int[] result = new int[N];
            HashMap<Integer, Integer> indexMap = new HashMap<>();
    
            for (int i = 0; i < N; i++) {
                result[i] = A[i];
                indexMap.put(A[i], i);
            }
    
            for (int i = 0; i < N && B > 0; i++) {
                int maxVal = N - i;
                if (result[i] != maxVal) {
                    int indexToSwap = indexMap.get(maxVal);
                    indexMap.put(result[i], indexToSwap);
                    indexMap.put(maxVal, i);
                    int temp = result[i];
                    result[i] = maxVal;
                    result[indexToSwap] = temp;
                    B--;
                }
            }
            return result;
        }
    }
    