public class REGEx {
    
}
import java.math.BigInteger;
import java.util.regex.*;

class Solution {
    public int myAtoi(String s) {
        // Define a regex pattern to match the integer part of the string
        Pattern pattern = Pattern.compile("^\\s*([-+]?(\\d+))"); // imp<<<<<<<<<<<<<<<<

        // Use Matcher to find and extract the integer part
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            try {
                // Parse the extracted integer part using BigInteger
                String intStr = matcher.group(1);
                BigInteger bigInt = new BigInteger(intStr);

                // Check if the parsed value is within the 32-bit integer range
                if (bigInt.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
                    return Integer.MIN_VALUE;
                } else if (bigInt.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                    return Integer.MAX_VALUE;
                }

                return bigInt.intValue();
            } catch (NumberFormatException e) {
                // Handle the case where the extracted part cannot be parsed as an integer
                return 0; // Return 0 or handle the error as needed
            }
        } else {
            return 0; // Return 0 if no valid integer part is found in the input string
        }
    }
}


// https://leetcode.com/problems/reverse-words-in-a-string-iii/?envType=daily-question&envId=2023-10-01
class Solution {

    public String reverseWords(String s) {
       StringBuilder ss=new StringBuilder();
        String ar[]=s.split(" ");
      

        for(String  i:ar){
            StringBuilder m=new StringBuilder(i);
            ss.append(m.reverse()+" ");

        }
          return  ss.toString().trim();
    }
}



 

public class SplitWithRegex {
    public static void main(String[] args) {
        String text = "Hello,World-How:Are+You";

        // Split the string using a regex pattern
        String[] parts = text.split("[,\\-:+]");

        // Print the resulting substrings
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
