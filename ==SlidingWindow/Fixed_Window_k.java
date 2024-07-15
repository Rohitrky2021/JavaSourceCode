public class Fixed_Window_k {
    class Solution {
        public int minKBitFlips(int[] arr, int k) {
            int n = arr.length;
            int operations = 0;
    
            for (int i = 0; i < n; ) {
                // If we encounter a 0, we need to perform the operation
                if (arr[i] == 0) {
                    // Change the next k elements to 1
                    for (int j = i; j < i + k && j < n; j++) {
                     if(i==n-1 && k>1)return -1;
                        arr[j] = 1^arr[j];
                    }
                    operations++;
                    // Move the window to the position after the current window
                    i += k;
                } else {
                    // If current element is 1, move to the next element
                    i++;
                }
            }
    
            return operations;
        }
    }
}
