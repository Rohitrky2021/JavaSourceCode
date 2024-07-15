
    import java.util.Arrays;
    import java.util.Comparator;
    
    public class SortingbasisOfSetbits {
        public int[] sortByBits(int[] arr) {
            // Define a custom comparator to compare integers by the number of set bits
            Comparator<Integer> bitComparator = new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    int bitCountA = Integer.bitCount(a); // Count set bits in 'a'
                    int bitCountB = Integer.bitCount(b); // Count set bits in 'b'
                    
                    // If the number of set bits is the same, compare the integers themselves
                    if (bitCountA == bitCountB) {
                        return a - b;
                    }
                    
                    // Otherwise, sort by the number of set bits
                    return bitCountA - bitCountB;
                }
            };
            
            // Sort the array using the custom comparator
            Arrays.sort(arr, bitComparator);
            
            return arr;
        }
    
        public static void main(String[] args) {
            SortBySetBits sorter = new SortBySetBits();
            int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
            int[] arr2 = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
            
            int[] result1 = sorter.sortByBits(arr1);
            int[] result2 = sorter.sortByBits(arr2);
            
            System.out.println(Arrays.toString(result1)); // Output for Example 1
            System.out.println(Arrays.toString(result2)); // Output for Example 2
        }
    }
    
