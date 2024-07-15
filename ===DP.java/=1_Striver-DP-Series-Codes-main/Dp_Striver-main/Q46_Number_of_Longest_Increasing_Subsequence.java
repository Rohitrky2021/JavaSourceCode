import java.util.Arrays;

// in LIS we were finding out the longest length of LIS
// here we want to count total LIS which is having the longest length
// so we create another array count to store the count of max length we got
// if any length occures repeatedly then increase its count
// otherwise st count for that with the prev count
public class Q46_Number_of_Longest_Increasing_Subsequence {

    public static void main(String[] args) {

        int[] nums = { 1, 3, 5, 4, 7 };

        int n = nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxi = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(1 + dp[j] > dp[i]){
                        dp[i] = 1 + dp[j];
                        count[i] = count[j];
                    }
                    else if(1 + dp[j] == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        int no = 0;

        for(int i = 0; i < n; i++){
            if(dp[i] == maxi) no += count[i];
        }

        System.out.println(no);

    }
}
