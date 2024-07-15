
import java.util.HashMap;

public class sortcount {

    // this not for SubSequence Only for SubArray   --> All Count of Subarray having 0 sum 
    public static void main(String args[]) {
        // int arr[] = { 10, 2, -2, -20, 20 };
        int arr[] = {2,8,-3,-5,2,-4,6,1,2,1,-3,4 };

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);

        int sum = 0, k = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hm.containsKey(sum)) {
                ans ++;
            }

            hm.put(sum, hm.getOrDefault(sum, 0) + 1);

        }
        System.out.println(ans+1);
    }
}
