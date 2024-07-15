import java.util.*;
// import java.
public class builder {
    public static void main(String[] args){
        char ch='a';
        String name="rohit, is the3 boss";
        StringBuilder alpha=new StringBuilder("");
        StringBuilder r1=new StringBuilder("");
        printletter(name);
        

        // for( ch='a';ch<='z';ch++){
        //     alpha.append(alpha);
        //     System.out.print(ch);
        //     char ch2=Character.toUpperCase(alpha.charAt(0));
        //     alpha.append(ch2);
        // }
        // System.out.print(alpha);
        // System.out.println();
        for (int i = 0; i < name.length(); i++) {
            r1.append(Character.toUpperCase(name.charAt(i)));

            
        }
        System.out.println(r1);
                // ch=Character.toUpperCase();
    }
    public static void printletter(String xyx){
        for (int i = 0; i < xyx.length(); i++) {
            System.out.print( xyx.charAt(i)+" ");
            
        }
        System.out.println();
    }
}
