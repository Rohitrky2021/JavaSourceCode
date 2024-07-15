import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> minimumRightShifts(List<Integer> nums) {
        // Convert the List<Integer> to an Integer[] array
        Integer[] arr = nums.toArray(new Integer[nums.size()]);

        subsetA.stream().mapToInt(Integer::intValue).toArray();
        

        
        // Now, you can treat 'arr' as an array and write your logic
        int n = arr.length;
        
        // Your logic goes here
       
        
        // Create a List to store the result
        List<Integer> result = new ArrayList<>();
        
        // Add elements to the result list
        for (int num : arr) {
            result.add(num);
        }
        
        return result; // Return the result as a List
    }
    
    public static void swap(int a, int b)
	{
        
		// same as a = a + b
		a = (a & b) + (a | b);
		// same as b = a - b
		b = a + (~b) + 1;
		// same as a = a - b
		a = a + (~b) + 1;
		// System.out.print("After swapping: a = " + a + ", b = " + b);
	}
    
}
    public static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
