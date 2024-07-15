// in this problem we have given two strings s1 and s2 we have to return length of longest common 
// substring, in last problem we find longest common subseqyuence(may be consecutive or not)
// but substring have to be consecutive
// so use same logic just a small change we take max idx1 movement and idx2 movement but here
// we cannot take that so in that place set 0 and the longest common substring will be our
// max element of dp
public class Q27_longest_common_substring {
    public static void main(String[] args) {

        String s1 = "abcjklp";
        String s2 = "acjkp";

        int n = s1.length();
        int m = s2.length();


        // tabulation
        int[][] dp = new int[n+1][m+1];

        int ans = 0;

        for(int idx1 = 1; idx1 <= n; idx1++){

            for(int idx2 = 1; idx2 <= m; idx2++){

                if(s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)){

                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];

                    ans = Math.max(ans, dp[idx1][idx2]);

                }

                else {

                    dp[idx1][idx2] = 0;

                }

            }

        }

        System.out.println(ans);

    }
}
