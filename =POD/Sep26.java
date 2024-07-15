import java.util.*;
import java.util.stream.Collectors;

public class Sep26{

    public static void main(String[] args) {
        String s="cbacdcbc";
        char arr[]=s.toCharArray();
    //    HashSet<Character> hs =new HashSet<>(arr);
    //    for (int i = 0; i < s.length(); i++) {
    //     hs.add(arr[i]);
    //    } 
    
    Set<Character> hs = s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());  //short way of above lines
                System.out.println(hs);

    }

    // public String removeDuplicateLetters(String s) {

    //     int arr

    //     return s;
        
    // }
}