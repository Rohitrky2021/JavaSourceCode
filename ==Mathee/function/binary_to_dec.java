import java.util.*;
import java.util.regex.Pattern;

public class binary_to_dec {
    public static void bintodec(int n){
        int pow=0;
        int dec=0;
        while(n>0){
            int ld=n%10;
            dec=(dec+(ld* (int)Math.pow(2,pow)));
            pow++;
            n=n/10;
        }
            System.out.println(dec);
            }
    public static void binnum(int n){
        int c=0;
        int pow=0;
         while(n>0){
            int num=n%2;
            n=n/2;
            c=c+(num*(int)Math.pow(10,pow));
            // int c=length(n);
            pow++;
        }
        System.out.println(c);
         
    }        
    public static void main(String args[]){
        bintodec(10011);

        // M1
        binnum(19);
        String s="ok";
        s.split(regex)

        // M2
       StringBuilder s=new StringBuilder( Integer.toBinaryString(19));
       System.out.println( s.reverse());

       System.out.println(String.valueOf(Integer.par parseInt("101").));

       Pattern pt=Pattern.compile(regex)
       

    }
}
