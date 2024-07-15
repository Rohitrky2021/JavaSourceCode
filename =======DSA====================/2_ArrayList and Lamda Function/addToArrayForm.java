import java.util.*;

// 989. Add to Array-Form of Integer
// 3.2K
// 260
// Companies
// The array-form of an integer num is an array representing its digits in left to right order.

// For example, for num = 1321, the array form is [1,3,2,1].
// Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

 

// Example 1:

// Input: num = [1,2,0,0], k = 34
// Output: [1,2,3,4]
// Explanation: 1200 + 34 = 1234
// Example 2:

// Input: num = [2,7,4], k = 181
// Output: [4,5,5]
// Explanation: 274 + 181 = 455
// Example 3:

// Input: num = [2,1,5], k = 806
// Output: [1,0,2,1]
// Explanation: 215 + 806 = 1021
class addToArrayForm{
    static  List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Long.parseLong(s)
        int n = num.length;
        int carry = 0;
        int i = n - 1;
        while (i >= 0 || k > 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num[i];
            }
            if (k > 0) {
                sum += k % 10;
                k /= 10;
            }
            list.add(sum % 10);
            carry = sum / 10;
            i--;
            list.toString();
        }
        Collections.reverse(list);
        // lis
        return list;
        // Arrays.classstr
        

        
        

    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int k=11;
        // Arrays.asList(nums);
        List<Integer> ans =addToArrayForm(nums, k);
        System.out.println(ans.toString());
    }
}

// doing summ ading K
public String addStrings(String num1, String num2) {
        int nu[]=convertToIntArray(num1);
        int num=Integer.parseInt(num2);

}
public static int[] convertToIntArray(int num) {
    String numString = String.valueOf(num); // Convert the number to a string
    int[] intArray = new int[numString.length()];

    for (int i = 0; i < numString.length(); i++) {
        char c = numString.charAt(i); // Get the character at index i
        intArray[i] = Character.getNumericValue(c); // Convert the character to an integer
    }

    return intArray;
}