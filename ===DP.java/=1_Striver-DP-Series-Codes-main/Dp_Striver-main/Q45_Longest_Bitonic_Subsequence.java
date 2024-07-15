import java.util.*;
// bitonic means increasing then decreasing
// suppose we have array of {1, 11, 2, 10, 4, 5, 2, 1} in this array 1, 2, 10 are increasing then
// 4, 2, 1 or 5, 2, 1 are decreasing so length of bitonic will be 6
// it can be only increasing or decreasing
// so we use same concept of LIS
// firstly store LIS from 0 to n in dp1
// then store LIS from n-1 to 0 in dp2
// bcoz we want increasing then decreasing 
// and in both dp add their values and subtract 1 bcioz one element is common
// eq nums : {1, 11, 2, 10, 4, 5, 2, 1};
// dp1 :     {1, 2, 2, 3, 3, 4, 2, 1};
// dp2 :     {1 ,5, 2, 4, 3, 3, 2, 1};
// max will be 3 + 4 or  4 + 3 = 7 - 1
// in nums {1, 2, 10} is increasing and {10, 4, 2, 1} is decreasing
// in both 10 is common so ans will be 3 + 4 - 1 = 6
public class Q45_Longest_Bitonic_Subsequence {

    public static void main(String[] args) {
        int[] nums = { 1, 11, 2, 10, 4, 5, 2, 1 };

        int n = nums.length;

        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && 1 + dp1[j] > dp1[i]){
                    dp1[i] = 1 + dp1[j];
                }
            }
        }
        
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        int maxi = 1;
        
        for(int i = n-1; i >= 0; i--){
            for(int j = n-1; j > i; j--){
                if(nums[i] > nums[j] && 1 + dp2[j] > dp2[i]){
                    dp2[i] = 1 + dp2[j];
                }
            }
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }

        System.out.println(maxi);
    }

}