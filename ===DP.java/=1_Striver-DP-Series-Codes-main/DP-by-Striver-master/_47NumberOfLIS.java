import java.util.Arrays;

public class _47NumberOfLIS {
    public static void main(String[] args) {
        int[] arr = {1,3,5,4,7};
        int n = arr.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        int maxi = 0;
        for(int i=0; i<n; i++){
            int c = 0;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                }else if(arr[i] > arr[j] && dp[j]+1 == dp[i]){
                    cnt[i] += cnt[j];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        System.out.println("count is " + Arrays.toString(cnt));
        System.out.println("dp is " + Arrays.toString(dp));
        int ans = 0;
        for(int i=0; i<n; i++){
          if(dp[i] == maxi) ans+= cnt[i]; // add every number count in how many lis they have Come
        }

        System.out.println("ans is "+ ans);
    }
}
