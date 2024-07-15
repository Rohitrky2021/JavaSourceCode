import java.util.Arrays;
// this is similar ques like longest increasing subsequence,
// here we want to print max length of longest string chain
// given array of strings which is precedesor of prev string
// suppose prev string is "a" next can be "ab" or "ba" means one char is added
// so firstyly we sort the stringin the basis of their length
// then use compare function is the cond where we gave cond like arr[i] > arr[j] for longest
// increasing subsequ
// rest all will be same
// in compare function first string is longer and second is 1 length smaller
// check if s1.length() != s2.length() +1 then return false
// now compare each char using two variable n1 and n2
// if both end at size then return true else return false 
public class Q44_Longest_String_Chain {

    public static boolean compare(String s1, String s2){

        if(s1.length() != s2.length() + 1) return false;

        int n1 = 0, n2 = 0;

        while(n1 < s1.length()){
            if(n2 < s2.length() && s1.charAt(n1) == s2.charAt(n2)){
                n1++;
                n2++;
            }
            else n1++;
        }

        if(n1 == s1.length() && n2 == s2.length()) return true;
        return false;

    }

    public static void main(String[] args) {

        String[] words = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };

        // sort the words array using length
        // for length we use lamda function

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(compare(words[i], words[j]) && 1 + dp[j] > dp[i])
                dp[i] = 1 + dp[j];
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
