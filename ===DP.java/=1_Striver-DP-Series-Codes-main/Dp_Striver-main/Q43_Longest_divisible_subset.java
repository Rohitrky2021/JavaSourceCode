import java.util.*; 
// subset is not in order if we sort the array we can find subsequence which will be one of our subset
// and use same method but here we want divisbible so check for divisible condition rather than increasing

public class Q43_Longest_divisible_subset {
    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 9, 8};
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        Arrays.sort(arr);

        for(int i = 0; i < n; i++){

            for(int prev = 0; prev < i; prev++){

                if(arr[i] % arr[prev] == 0 && 1 + dp[prev] > dp[i]){

                    dp[i] = 1 + dp[prev];

                }

            }

            max = Math.max(max, dp[i]);

        }
        
        System.out.println(max);

        // print the subset
        // create a variable prev assign it value -1
        // now start loop from end
        // if dp[i] equals to max then check if prev == -1 or prev is divisible by arr[i] then add
        // arr[i] into ans and reduce max by 1 and make arr[i] as prev
        List<Integer> ans = new ArrayList<>();
        int prev = -1;

        for(int i = n-1; i >= 0; i--){
            if(dp[i] == max && (prev % arr[i] == 0 || prev == -1)){
                ans.add(arr[i]);
                max--;
                prev = arr[i];
            }
        }

        System.out.println(ans);

    }
}
