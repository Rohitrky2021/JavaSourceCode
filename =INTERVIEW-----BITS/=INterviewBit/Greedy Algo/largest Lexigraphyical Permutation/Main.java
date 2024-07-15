// https://www.interviewbit.com/problems/largest-permutation/

// Input 1:
//  A = [1, 2, 3, 4]
//  B = 1
// Input 2:
//  A = [3, 2, 1]
//  B = 2

// Example Output
// Output 1:
//  [4, 2, 3, 1]
// Output 2:
//  [3, 2, 1]
import java.util.*;
public class Main {
        public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
            Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < A.size(); i++) {
                queue.add(A.get(i));
                map.put(A.get(i), i);
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < A.size(); i++) {
                if (B != 0) {
                    int max = queue.poll();
                    list.add(max);
                    if (max == A.get(i)) {
                        continue;
                    }
                    A.set(map.get(max), A.get(i));
                    map.put(A.get(i), map.get(max));
                    B--;
                } else {
                    list.add(A.get(i));
                }
            }
            return list;
        }
    }


// ------------------------------------------------------------------------------------------------------
 

    public class Solution {
        public ArrayList<Integer> solve(ArrayList<Integer> nums, int B) {
            int N = nums.size();
            Integer[] arr = nums.toArray(new Integer[N]);
            int[] arqr=nums.toArray(new int[M]);
    
            // Create an index mapping to keep track of the original positions of elements
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                indexMap.put(arr[i], i);
            }
    
            // Iterate through the array and make swaps to maximize lexicographical value
            for (int i = 0; i < N; i++) {
                if (B == 0) break; // No more swaps left
                
                int originalIndex = indexMap.get(N - i); // Find the index of N - i
                if (originalIndex == i) continue; // No need to swap if the element is already in the correct position
                
                // Swap the elements
                int temp = arr[i];
                arr[i] = arr[originalIndex];
                arr[originalIndex] = temp;
                
                // Update the index mapping
                indexMap.put(temp, originalIndex);
                indexMap.put(arr[i], i);
                
                B--; // Decrement the number of swaps left
            }
    
            ArrayList<Integer> result = new ArrayList<>(Arrays.asList(arr));
            return result;
        }
    }
    