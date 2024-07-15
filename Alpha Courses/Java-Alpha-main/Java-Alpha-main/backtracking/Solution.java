import java.util.*;

public class Solution{
    
    //monkcoder 
    // menkcodor
    public static void reverse(String str) {
        String newstr = "" ; 
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i)=='a'|| str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u'){
                newstr = newstr+str.charAt(i);
            }
        }
        int temp = newstr.length();

        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i)=='a'|| str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u'){
                
                str = str.substring(0, i) + newstr.charAt(temp-1)+str.substring(i+1);
                temp--;
            }
        }
        System.out.println(str);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        reverse(str);
    }
}
