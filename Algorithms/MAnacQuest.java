public class MAnacQuest {
    // BUT THIS IS FASTER  MAN !!!
    class Solution {
        public int[] getManacherValue(StringBuilder s){
            int[] dp = new int[s.length()];
            int i = 0, left = -1, right = -1;
            
            while(i < s.length()){
                if(i > right){
                    int j = 0;
                    while(i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)){
                        j++;
                    }
                    
                    dp[i] = j - 1;
                    left = i - dp[i];
                    right=  i + dp[i];
                }
                else{
                    int mirror = right + left - i;
                    int mirror_left = mirror - dp[mirror];
                    
                    if(mirror_left == left){
                        int j = right + 1 - i;
                        while(i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)){
                            j++;
                        }
    
                        dp[i] = j - 1;
                        left = i - dp[i];
                        right=  i + dp[i];
                    }
                    else if(mirror_left < left){
                        dp[i] = right - i;
                    }
                    else{
                        dp[i] = dp[mirror];
                    }
                }
                i++;
            }
            return dp;
        }
        
        public String longestPalindrome(String s) {
            StringBuilder newString = new StringBuilder("#");
            for(int i = 0; i < s.length(); i++)
            {
                newString.append(s.charAt(i));
                newString.append("#");
            }
    
            int[] dp = getManacherValue(newString);
            int left = 0, right = 0;
            
            for(int i = 0; i < newString.length(); i++){
                if(dp[i] *  2 >= right - left + 1){
                    left = i - dp[i];
                    right = i + dp[i];
                }
            }
            return newString.substring(left, right + 1).replace("#", "");
        }
    }
}
