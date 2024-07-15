import java.util.*;

public class Solution {
    public ArrayList<Long> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int N = A.size();
        int c=0;
        int arr[]=new int[A.size()];
        for(int i:A){
            // c&=i;
            arr[c]=i;
            c++;
        }
        ArrayList<Long> result = new ArrayList<>();
        
        for (ArrayList<Integer> query : B) {
            int type = query.get(0);
            int l = query.get(1) - 1; // Convert to 0-based indexing
            int r = query.get(2) - 1; // Convert to 0-based indexing
            int v = query.get(3);
            
            if (type == 1) {
                long value = v;
                for (int i = l; i <= r; i++) {
                    A.set(i, v);
                }
            } else if (type == 2) {
                for (int i = l; i <= r; i++) {
                    int oldValue = A.get(i);
                    A.set(i, oldValue | v);
                }
            } else if (type == 3) {
                long sum = 0;
                // for (int i = l; i <= r; i++) {
                //     sum=arr[r]&arr[l];
                //     for (int j = i; j <= r; j++) {
                //         long andResult = A.get(i);
                //         for (int k = i + 1; k <= j; k++) {
                //             andResult &= A.get(k);
                //         }
                //         sum += andResult;
                //     }
                // }
                sum =AND(arr,l,r);
                result.add(sum);
            }
        }
        
        return result;
    }
    static long AND(int[] arr,int l,int r) {
		int n = arr.length;
		HashMap<Integer, Integer> bit_count = new HashMap<>();
		for (int i = l; i <r+1; i++) {
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
		long res = 0;
		for (Map.Entry<Integer, Integer> entry : bit_count.entrySet()) {
			if (entry.getValue() == n) {
				res |= (1 << entry.getKey());
			}
		}
		return res;
	}

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Sample Input 1
        ArrayList<Integer> A1 = new ArrayList<>();
        A1.add(1);
        A1.add(0);
        A1.add(2);
        A1.add(5);
        ArrayList<ArrayList<Integer>> B1 = new ArrayList<>();
        B1.add(new ArrayList<>(java.util.Arrays.asList(3, 1, 3, 0)));
        B1.add(new ArrayList<>(java.util.Arrays.asList(1, 1, 2, 4)));
        B1.add(new ArrayList<>(java.util.Arrays.asList(2, 2, 4, 5)));
        B1.add(new ArrayList<>(java.util.Arrays.asList(3, 1, 4, 0)));
        ArrayList<Long> result1 = solution.solve(A1, B1);
        System.out.println("Sample Output 1 - " + result1);

        // Sample Input 2
        ArrayList<Integer> A2 = new ArrayList<>();
        A2.add(5);
        A2.add(4);
        A2.add(3);
        A2.add(2);
        A2.add(1);
        ArrayList<ArrayList<Integer>> B2 = new ArrayList<>();
        B2.add(new ArrayList<>(java.util.Arrays.asList(3, 2, 4, 0)));
        B2.add(new ArrayList<>(java.util.Arrays.asList(1, 1, 2, 8)));
        B2.add(new ArrayList<>(java.util.Arrays.asList(2, 2, 4, 2)));
        B2.add(new ArrayList<>(java.util.Arrays.asList(3, 1, 3, 0)));
        B2.add(new ArrayList<>(java.util.Arrays.asList(3, 3, 5, 0)));
        ArrayList<Long> result2 = solution.solve(A2, B2);
        System.out.println("Sample Output 2 - " + result2);
    }
}
