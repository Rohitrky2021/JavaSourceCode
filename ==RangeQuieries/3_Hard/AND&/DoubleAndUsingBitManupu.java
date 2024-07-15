import java.util.HashMap;
import java.util.Map;
// OF a Find bitwise -->  AND (&) then Double ANd & on ANSwer <--of all possible sub-arrays-->at last is the single overall subarray!

// -> Time complexity of this approach is O(N * L),
//  where N is the length of the input array and L is the maximum number of bits required to
//   represent any number in the array.

// -> Space complexity of this approach is also O(L),
// as we are using a dictionary to store the count of set bits for each position.

// public class Main {->OF a Find bitwise AND (&) of all possible sub-arrays-->at last is the single overall subarray!

    public class DoubleAndUsingBitManupu {
	static int AND(int[] arr) {
		int n = arr.length;
		HashMap<Integer, Integer> bit_count = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int num = arr[i];
			int pos = 0;
			while (num > 0) {
				if ((num & 1) == 1) {
					if (!bit_count.containsKey(pos)) {
						bit_count.put(pos, 1);
					} else {
						bit_count.put(pos, bit_count.get(pos) + 1);
					}
				}
				num >>= 1;
				pos++;
			}
		}
		int res = 0;
		for (Map.Entry<Integer, Integer> entry : bit_count.entrySet()) {
			if (entry.getValue() == n) {
				res |= (1 << entry.getKey());
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		System.out.println(AND(arr));
	}
}
// then the AND of all these results.

// Examples: 

// Input : 1 2 3
// Output : 0
// All possible subarrays are 
// {1}, {2}, {3}, {1, 2}, {2, 3} and {1, 2, 3}
// ANDs of these subarrays are 1, 2, 3, 0, 2, 0.
// AND of these ANDs is 0.

// Input : 100 500 1000
// Output : 96 

