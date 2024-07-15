//WAP to check whether a string is a palindrome or not
public class palindromestring {
    public static boolean palindrome(String str) {
        for(int i=0; i<str.length()/2; i++) {
            int n = str.length();
            if(str.charAt(i) != str.charAt(n-1-i)) 
            {
                //not a palindrome
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(palindrome(str));
    }
}
