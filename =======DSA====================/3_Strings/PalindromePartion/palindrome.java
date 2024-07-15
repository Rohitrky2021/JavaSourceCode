public class palindrome {
    public static void main(String args[]){
        String str="Sboobs";
        // System.out.printlnpalindrome(str);
        System.out.println(palindrome(str));
    }
    public static boolean palindrome(String xyx){
        int n=xyx.length();
        for (int i = 0; i < xyx.length()-1; i++) {
            if(Character.toLowerCase(xyx.charAt(i))!=xyx.charAt(n-1-i)){
                return false;
            }
        }
        
        return true;
    }

    public boolean isPalindrome(String xyx) {
        xyx.replaceAll("  :", "");
        int n=xyx.length();
        xyx.toLowerCase();
        for (int i = 0; i < xyx.length()-1; i++) {
            if(Character.toLowerCase(xyx.charAt(i))!=xyx.charAt(n-1-i)){
                
                return false;
            }
        }
        
        return true;
    }
  }
    
