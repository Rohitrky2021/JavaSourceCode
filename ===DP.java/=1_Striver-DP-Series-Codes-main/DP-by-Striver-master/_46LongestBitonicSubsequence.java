//Let us first understand what a bitonic subsequence means.
//
//        A bitonic subsequence is a subsequence of an array in which the elements can be any of these three:
//
//        First, increase till a point and then decrease.
//        Goes on increasing (Longest increasing subsequence)
//        Goes on decreasing (Longest decreasing subsequence)

// first watch the array from left to right AS LIS
// then watch it form right to left as LIS
public class _46LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] arr ={1,11,2,10,4,5,2,1};
        int n = arr.length;

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        for(int i=0; i<n; i++){
            dp1[i]  = 1;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    dp1[i] = Math.max(dp1[i], dp1[j]+1);
                }
            }
        }

        for(int i=n-1; i>=0; i--){
            dp2[i] = 1;
            for(int j=n-1; j > i; j--){
                if(arr[i] > arr[j]){
                    dp2[i] = Math.max(dp2[i], dp2[j]+1);
                }
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, dp1[i]+dp2[i]-1);
        }
        System.out.println("longest bitonic subsequence length is : "+ ans);
    }
}
