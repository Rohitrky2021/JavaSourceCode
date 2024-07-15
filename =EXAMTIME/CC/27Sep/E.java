import java.util.Scanner;

public class E {

    // Define constants for modulo calculation
    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        while (T-- > 0) {
            int N = scanner.nextInt(); // Length of the string
            String S = scanner.next(); // Binary string

            // Calculate the number of operation strings
            long result = countOperationStrings(N, S);
            System.out.println(result);
        }
    }

    // Function to calculate the number of operation strings
    private static long countOperationStrings(int N, String S) {
         
        char[] s = S.toCharArray();
        int ans=1;
        for (int i = 2; i < s.length; i+=2) {
            if(s[i]=='0'){
                if(s[i-1]==s[i-2])ans*=s[i-1]=='0'?3:1;
                else ans*=1;

            }else{
                if(s[i-1]==s[i-2])ans*=s[i-1]=='1'?2:0;
                else ans*=2;
            }
            ans%=MOD;
        }
 
        return ans;
         
    }
}
