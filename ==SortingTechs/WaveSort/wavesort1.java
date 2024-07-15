
// https://www.interviewbit.com/problems/wave-array/

public class wavesort1 {
        public ArrayList<Integer> wave(ArrayList<Integer> nums) {
            Integer[] arr = nums.toArray(new Integer[nums.size()]);
            Arrays.sort(arr);
    
            ArrayList<Integer> result = new ArrayList<>();
    
            for (int i = 0; i < arr.length; i += 2) {
                if (i + 1 < arr.length) {
                    // Swap adjacent elements to create the wave
                    result.add(arr[i + 1]);
                    result.add(arr[i]);
                } else {
                    // If there's only one element left, add it to the result
                    result.add(arr[i]);
                }
            }
    
            return result;
        }
    }



// M2-------------->

    public class Solution {
        public ArrayList<Integer> wave(ArrayList<Integer> A) {
            
            Collections.sort(A);
            int n = A.size();
            
            for (int i = 2; i <= n; i += 2) {
                exch(A, i - 2, i - 1);
            }
            
            return A;
            
        }
        
        private void exch(ArrayList<Integer> A, int i, int j) {
            int temp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, temp);
        }
        
    }
    
    