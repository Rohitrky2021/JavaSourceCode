import java.util.Arrays;

// One more method of sorting arr[] -> distinct ones using Hashset -> then Applying LCS with Original arr[]
public class _41LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,2,3};
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int[] a : dp) Arrays.fill(a, -1);
        System.out.println("memo : " + solve(arr,0, -1, dp));
        int[] optiDp = new int[n];
        Arrays.fill(optiDp, -1);
        System.out.println("optimized memo : " + optimizedMemo(arr, 0, -1, optiDp));
        System.out.println("tabu : "+ tabu(arr));
    }

    public static int solve(int[] arr, int i, int prev, int[][] dp) {
        if (i == arr.length) return 0;
        if(dp[i][prev+1] != -1) return dp[i][prev+1];

        int not =  solve(arr, i + 1, prev, dp);
        int take = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            take = 1 + solve(arr, i + 1, i, dp);
        }

        return dp[i][prev+1] =  Math.max(take, not);
    }

    public static int optimizedMemo(int[] arr, int i, int prev, int[] dp) {
        if (i == arr.length) return 0;
        if(dp[prev+1] != -1) return dp[prev+1];

        int not =  optimizedMemo(arr, i + 1, prev, dp);
        int take = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            take = 1 + optimizedMemo(arr, i + 1, i, dp);
        }
        return dp[prev+1] =  Math.max(take, not);
    }
// This is the main method This will Mostly used in Modified Version OF Question
    public static int tabu(int[] arr){
        int ans = 1;
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=0; i<n; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
// This below one Accepted as its like Binary Search Mostly -> Accepted on all platforms 
    public static int longestIncreasingSubsequence(int arr[]) {
            TreeSet<Integer> t=new TreeSet<>();
            t.add(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if(arr[i]>t.last()){
                    t.add(arr[i]);
                    continue;
                }
    
                int key = t.ceiling(arr[i]);
                t.remove(key);
    
                t.add(arr[i]);
            }
    
            return t.size();
        }
 // Binary search way we have done same logic in above Treeset OPitmised 
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        
        return sub.size();
    } 
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }
            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
      }
}
 
 

/*
[0,1,0,3,2,3]

dp = [1,2,1,3,3,1]

i = 0, j = 0 no change
i = 1 j = 0 dp[1] = 1,2  = 2
i = 2 j = 0 and 1  dp[2] = 1
i = 3 j = 0,1,2 dp[3] = 2,3,2 = 3
i = 4 j = 0,1,2,3 dp[4] = 2,3,2,0 = 3
i = 5 j = 0,1,2,3,4 dp[5] = 2,3,2,0,4 = 4
 */