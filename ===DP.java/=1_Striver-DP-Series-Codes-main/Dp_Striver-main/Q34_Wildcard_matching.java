// given two string s1 and s2 we have to check wheather they are matching or not
// in s1 we can have '*' and '?' if '*' that means it can match with string of len 0 or more than 0
// if '?' means it can match with single any character
// ex : s1 :"abc?df", s2 : "abcgdf"
// every char are similar except '?' it can match with 'g' 
// ex2 : s1 : "**ab", s2 : "ab" this is also matching bcoz '*' can match with string of len 0 also
public class Q34_Wildcard_matching {

    public static boolean f(int i, int j, String s1, String s2){

        // base case 1 : if i < 0 && j < 0 that means both strings matching ended so return true
        // base case 2 : if i < 0 && j >= 0 that means pattern is ended but string is left so return false
        // base case 3 : if j < 0 but i >= 0 that means pattern is still left so check the string from
        // 0 to i if there is only "*" then return true else return false

        if(i < 0 && j < 0) return true;

        if(i < 0 && j >= 0) return false;

        if(i >= 0 && j < 0){

            // boolean flag = true;

            for(int ii = 0; ii <= i; ii++) {

                if(s1.charAt(ii) != '*') {
                    // flag = false;
                    // break;
                    return false;
                }

            }

           // return flag;
           return true;

        }

        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?'){

            return f(i-1, j-1, s1, s2);

        }

        if(s1.charAt(i) == '*'){

            return f(i-1, j, s1, s2) || f(i, j-1, s1, s2);

        }

        return false;

    }
    
    public static void main(String[] args) {
        
        String s1 = "*", s2 = "aa"; // s1 is pattern and s2 is string

        int n = s1.length(), m = s2.length();

        // recursion
        // System.out.println(f(n-1, m-1, s1, s2));

        // memoization
        boolean[][] dp = new boolean[n+1][m+1];

        dp[0][0] = true;

        for(int j = 1; j <= m; j++) dp[0][j] = false;

        for(int i = 1; i <= n; i++){

            boolean flag = true;

            for(int ii = 1; ii <= i; ii++) {

                if(s1.charAt(ii - 1) != '*') {
                    flag = false;
                    break;
                }

            }

            dp[i][0] = flag;

        }

        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= m; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?'){

                    dp[i][j] = dp[i-1][j-1];

                }

                else if(s1.charAt(i-1) == '*'){

                    dp[i][j] = dp[i-1][j] || dp[i][j-1];

                }

                else dp[i][j] = false;

            }

        }

        System.out.println(dp[n][m]);
        
    }


}
