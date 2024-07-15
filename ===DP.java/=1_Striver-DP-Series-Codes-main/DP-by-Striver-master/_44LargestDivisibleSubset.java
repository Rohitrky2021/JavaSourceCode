import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * From this and from previous LIS we have find out that if we found a thing that 
 * for eaxmple 4<7  then 4 will definely 4<8 we used this only and passed our  
 * command to next number and get assure that before that all number will deginely
 * follow the rule and satisfyt the condition 
 * for ex her if 4 divide 8 then it will definely divide which 8 divieds i.e 16 ->4/16 ->true
 */
public class _44LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {1, 8, 7, 4, 16};
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.sort(nums);
        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            hash[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + dp[j] > dp[i]) {
                        dp[i] = dp[j] + 1;
                        hash[i] = j;// Used to Track back the ans
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = hash[index];
        }
        System.out.println(res);
    }
}
