package internship;

import java.util.*;

// https://www.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1
// for More --> https://www.geeksforgeeks.org/factorial-large-number/

public class BigFactorials {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		int n = sc.nextInt();
		arr.add(1);
		for(int i=2;i<=n;i++) {
			int carry = 0;
			for(int j=arr.size()-1;j>=0;j--) {
				int value = arr.get(j)*i + carry;
				arr.set(j,value%10);
				carry = value/10;
			}
			
			while(carry != 0) {
				arr.add(0,carry%10);
				carry /= 10;
			}
		}
		
		for(Integer val: arr) {
			System.out.print(val);
		}
		
		sc.close();

	}

}
 
/**   Complexity
 

** Time Complexity: O(N^2) - The outer loop runs for N times, and for each iteration, there can be up to N multiplications.
** Space Complexity: O(N) - The space used by the result vector to store the factorial digits 


*? 10! = 1*2*3*4*5*6*7*8*9*10 = 3628800 *=> return a list of integers denoting the digits 
 that make up the factorial of N.

*? Expected Approach
** Intuition
Since the factorial of N can be a very large number. It can not be stored in a regular integer data type. The intuition is to store the factorial use an array of digits. 

** Implementation
* Create an empty vector result to store the factorial.
* Initialize the vector with 1, representing the initial factorial value.
* Start a loop from 2 up to N.
*? For each number i:
	** Initialize carry as 0.
	** Traverse through the elements of result.
	** Perform multiplication of i with each digit in result, add the carry, and update the result with the product and the new carry.
	** Handle any remaining carry by continuously dividing it by 10 and appending the digits to the result.
* Reverse the result vector to obtain the correct factorial representation.
* Return the result vector containing the factorial of N. 

*/