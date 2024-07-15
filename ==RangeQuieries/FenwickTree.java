public class FenwickTree {
 
        private int[] tree;
    
        public FenwickTree(int size) {
            tree = new int[size + 1];
        }
    
        // Add 'delta' to the element at index 'index'
        public void update(int index, int delta) {
            index++; // Convert 0-based index to 1-based index
            while (index < tree.length) {
                tree[index] += delta;
                index += index & -index; // Update the next relevant index till end 
            }
        }
    
        // Get the prefix sum up to index 'index'
        public int query(int index) {
            index++; // Convert 0-based index to 1-based index
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index; // Move to the previous relevant index til inddex 1 as 1 based index
            }
            return sum;
        }
    
        // Get the sum in the range [left, right]
        public int rangeQuery(int left, int right) {
            if (left == 0) {
                return query(right);
            } else {
                return query(right) - query(left - 1);  // r- (l-1)
            }
        }
    
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
            FenwickTree fenwick = new FenwickTree(arr.length);
    
            for (int i = 0; i < arr.length; i++) {
                fenwick.update(i, arr[i]);
            }
    
            System.out.println("Prefix Sum at index 5: " + fenwick.query(5)); // Output: 21
            System.out.println("Sum in the range [2, 5]: " + fenwick.rangeQuery(2, 5)); // Output: 18
    
            // Update the value at index 3 to 10
            fenwick.update(3, 10);
    
            System.out.println("Updated Prefix Sum at index 5: " + fenwick.query(5)); // Output: 31
        }
    }
    