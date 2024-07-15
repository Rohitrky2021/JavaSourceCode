import java.lang.reflect.Array;
import java.util.*;
public class sep23{

    public static void main(String[] args) {
        
    }

    public boolean isSubsequence(String s, String t) {
      

        int arr1=s.toCharArray();
        int arr2=t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        s=Arrays.toString(arr1);
        t=Arrays.toString(arr2);
System.out.println(s+" "+t);
        if(s.contains(t) || t.contains(s)){
            return true;
        }else{
            return false;
        }

    }
}