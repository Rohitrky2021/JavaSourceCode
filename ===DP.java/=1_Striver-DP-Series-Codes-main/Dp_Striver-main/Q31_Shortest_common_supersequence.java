// in this problem we have to print the shortest common supersequence, it is like union of two strings
// so we find out the longest common subsequence then the length of supersubsequence will be n + m - lcs
// we subtract lcs bcoz we don't want to take longest common subsequence two times
// now in order to print run a loop from i = n and j = m if both are greater than 0 then check
// char at i and j (1 based indexing so s1.charAt(i-1)) if they are same then add ith char into ans string
// and decrease both i and j
// if (i-1)th cell is greater than print ith char and set i-- else do for j
// after while loop their is chance that any string is rest so check for s1 and s2 at end return ans
public class Q31_Shortest_common_supersequence {
    public static void main(String[] args) {

        String s1 = "brute";
        String s2 = "groot";

        int n = s1.length();
        int m = s2.length();
 
        int[][] dp = new int[n+1][m+1];

        for(int idx1 = 1; idx1 <= n; idx1++){

            for(int idx2 = 1; idx2 <= m; idx2++){

                if(s1.charAt(idx1-1) == s2.charAt(idx2-1)){

                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
 
                }

                else {

                    dp[idx1][idx2] = Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);

                }

            }

        }

        String ans = "";

        int i = n, j = m;

        while(i > 0 && j > 0){

            if(s1.charAt(i-1) == s2.charAt(j-1)){

                ans = s1.charAt(i-1) + ans;
                i--;
                j--;

            }

            else if(dp[i-1][j] > dp[i][j-1]){

                ans = s1.charAt(i-1) + ans;
                i--;

            }

            else {

                ans = s2.charAt(j-1) + ans;
                j--;

            }

        }

        while(i > 0){

            ans = s1.charAt(i-1) + ans;
            i--;

        }

        while(j > 0){

            ans = s2.charAt(j-1) + ans;
            j--;

        }

        System.out.println(ans);

    }
}
