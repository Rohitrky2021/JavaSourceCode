import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _45LongestStringChain {
    public static void main(String[] args) {
        String[] arr = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println("len is "+ longestStrChain(arr));
        System.out.println("space optimized "+ optimal(arr));
    }

    public static int longestStrChain(String[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        int n = arr.length;
        if(n == 1) return 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 0;

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){ //checking with prev strings 
                if(check(arr[i], arr[j]) && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }

    public static boolean check(String a, String b){
        if(a.length() != b.length()+1) return false;

        int i = 0;
        int j = 0;
        while(i < a.length()){
            if(j < b.length() && a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j == b.length();
    }


    public static int optimal(String [] words){
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1); // here we are skipping ith character
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
//             System.out.println("after some update"+ dp);
            res = Math.max(res, best);
        }
        return res;
    }
}
