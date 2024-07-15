//WAP on string compression
public class stringcompression {
    public static String compress(String str) {
        String newStr = "";
        for(int i=0;i<str.length(); i++) {
            Integer count =1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) 
            {
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if(count > 1) {
                newStr += count.toString();
            }
        }
        return newStr;
    }
    public static void main(String[] args) {
        String str = "aaabbcccdd";
        System.out.println(compress(str));
    }
}
/*
 * Explanation:
 * the for loop traverses the entire string.
 * the while loop sees whether the alphabets are same or no and it continues 
 * till the alphabets are the same. 
 * for eg: it is aaa then the while loop continues till the second alphabet which is "a"
 * and then the while loop stops and goes to the if statement as "a" is the last alphabet common and then next alphabet is different.
 * if the letters are same repeatedly then it creates a new string and then returns the new string.
 * and then we print the function which we created before the main function.
 */