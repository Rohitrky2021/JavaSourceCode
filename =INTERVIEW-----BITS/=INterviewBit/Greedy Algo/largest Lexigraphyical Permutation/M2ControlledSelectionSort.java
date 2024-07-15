
public class M2ControlledSelectionSort {
        public int[] findLargestPermutation(int[] A, int B) {
            int N = A.length;
            if (B >= N) {
                Arrays.sort(A);
                reverseArray(A);
                return A;
            }
    
            for (int i = 0; i < N && B > 0; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < N; j++) {
                    if (A[j] > A[maxIndex]) {
                        maxIndex = j;
                    }
                }
                if (maxIndex != i) {
                    int temp = A[i];
                    A[i] = A[maxIndex];
                    A[maxIndex] = temp;
                    B--;
                }
            }
            return A;
        }
    
        private void reverseArray(int[] arr) {
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
    