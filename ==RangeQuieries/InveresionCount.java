public class InveresionCount {
 
        private int[] BIT;
    
        public InveresionCount(int size) {
            BIT = new int[size + 10000];
        }
    
        public void update(int index, int delta) {
            index++;
            while (index < BIT.length) {
                BIT[index] += delta;
                index += index & -index;
            }
        }
    
        public int query(int index) {
            index++;
            int sum = 0;
            while (index > 0) {
                sum += BIT[index];
                index -= index & -index;
            }
            return sum;
        }
    
        public static int countInversions(int[] arr) {
            int n = arr.length;
            FenwickTree fenwick = new FenwickTree(n);
    
            int inversionCount = 0;
    
            for (int i = n - 1; i >= 0; i--) {   // last se Update krna shuru krenge
                inversionCount += fenwick.query(arr[i] - 1); // Count elements smaller than arr[i] to the right.
                fenwick.update(arr[i], 1); // Increment the count for arr[i].
            }
    
            return inversionCount;
        }
    
        public static void main(String[] args) {
            int[] arr = {8, 4,9,2,8};
            int inversionCount = countInversions(arr);
            System.out.println("Inversion Count: " + inversionCount); // Output: 6
        }
    }
    