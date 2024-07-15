public class BIT {
    // public class FenwickTree {
        private int[] BIT;
    
        public BIT(int size) {
            BIT = new int[size + 1];
        }
    
        // Add 'delta' to the element at index 'index'
        public void update(int index, int delta) {
            index++; // Convert 0-based index to 1-based index
            while (index < BIT.length) {
                BIT[index] += delta;
                index += index & -index; // Update the next relevant index
            }
        }
     
        // Get the prefix sum up to index 'index'
        public int query(int index) {
            index++; // Convert 0-based index to 1-based index
            int sum = 0;
            while (index > 0) {
                sum += BIT[index];
                index -= index & -index; // Move to the previous relevant index
            }
            return sum;
        }
    
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
            BIT fenwick = new BIT(arr.length);
    
            for (int i = 0; i < arr.length; i++) {
                fenwick.update(i, arr[i]);
            }
    
            System.out.println("Prefix Sum at index 5: " + fenwick.query(5)); // Output: 21
    
            // Update the value at index 3 to 10
            fenwick.update(3, 10);
    
            System.out.println("Updated Prefix Sum at index 5: " + fenwick.query(5)); // Output: 31
        }
    }
    