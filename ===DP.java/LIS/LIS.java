import java.lang.reflect.Array;
import java.util.*;



public class LIS {

    public static int lcs(int arr1[],int arr2[]){
        int n=arr1.length;
        int m=arr2.length;

        int dp[][]=new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
            
        }
        return dp[n][m];

    }

    public static int lis(int arr[]){
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int arr2[]=new int[set.size()];
        int i=0;
        for (int num : set) {
            arr2[i]=num;
            i++;
            
        }

        Arrays.sort(arr2);
        return lcs(arr, arr2);

        
    }
    public static void main(String args[]){
        int arr[]={50,3,10,7,40,80};
        System.out.println(lis(arr));
    }
}


// ------------------------------/>>>>>>>>>>>
 

class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> tree = new TreeSet<>();

        for (int x : nums) {
            if (tree.isEmpty() || tree.last() < x) {
                tree.add(x);
                continue;
            } 

            int key = tree.ceiling(x); // Yhi p Binary search waala use hota hai -> just greater than this x
            tree.remove(key);// Usko nikal do ya uska bucket bnaa k wha add krdo 
            tree.add(x);
        }

        return tree.size();
    }
}




class Solution2 {
 
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int mx = 0;

        for (int i = 0; i < dp.length; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }

            dp[i] = max + 1;

            if (dp[i] > mx) {
                mx = dp[i];
            }
        }

        return mx;
    }
}

 
public class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] distinctSortedNums = removeDuplicatesAndSort(nums);
        int[][] memo = new int[n + 1][distinctSortedNums.length + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return lcs(nums, distinctSortedNums, n, distinctSortedNums.length, memo);
    }

    private int lcs(int[] arr1, int[] arr2, int n, int m, int[][] memo) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (memo[n][m] != -1) {
            return memo[n][m];
        }

        if (arr1[n - 1] == arr2[m - 1]) {
            return memo[n][m] = 1 + lcs(arr1, arr2, n - 1, m - 1, memo);
        } else {
            int ans1 = lcs(arr1, arr2, n - 1, m, memo);
            int ans2 = lcs(arr1, arr2, n, m - 1, memo);
            return memo[n][m] = Math.max(ans1, ans2);
        }
    }

    private int[] removeDuplicatesAndSort(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int[] distinctSortedNums = new int[set.size()];
        int index = 0;
        for (int num : set) {
            distinctSortedNums[index++] = num;
        }

        Arrays.sort(distinctSortedNums);
        return distinctSortedNums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // arr = array of elements
        int[] arr = {50, 3, 10, 7, 40, 80};

        System.out.println("Size of the longest increasing subsequence: " + solution.lengthOfLIS(arr));
    }
}

