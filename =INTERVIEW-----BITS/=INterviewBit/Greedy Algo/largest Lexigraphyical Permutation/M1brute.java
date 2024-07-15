
    import java.util.ArrayList;
    import java.util.Collections;
    
    public class M1brute {
        public ArrayList<Integer> findLargestPermutation(ArrayList<Integer> A, int B) {
            int N = A.size();
            if (B >= N) {
                Collections.sort(A, Collections.reverseOrder());
                return A;
            }
    
            for (int i = 0; i < N && B > 0; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < N; j++) {
                    if (A.get(j) > A.get(maxIndex)) {
                        maxIndex = j;
                    }
                }
                if (maxIndex != i) {
                    Collections.swap(A, i, maxIndex);
                    B--;
                }
            }
            return A;
        }
    }
    