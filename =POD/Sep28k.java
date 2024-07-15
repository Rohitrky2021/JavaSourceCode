import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Sep28k {

    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            ans.add(num);
        }
        while (i < nums.length) {
            if (nums[i] % 2 == 0) {
                Collections.swap(ans, i, j);
                i++;
                j++;
                continue;
            }
            i++;
        }
        int[] arr = new int[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            arr[k] = ans.get(k);
        }
        return arr;

    }
}
