import java.util.StringTokenizer;    
public class tokeniser {
    
     
     /* Driver Code */  
     public static void main(String args[])  
     {    
       /* StringTokenizer object */  
       StringTokenizer st = new StringTokenizer("Hello Everyone Have a nice day"," ");    
             /* Prints the number of tokens present in the String */  
             System.out.println("Total number of Tokens: "+st.countTokens());    
             

        String s1=new String("25");
        String s2=new String("30");
        System.out.println(((Object)(s2.charAt(0)-s1.charAt(0))).getClass());
        // System.out.println(getclass);
        System.out.println(((Object)(s2.charAt(0))).getClass());
        System.out.println('A'-'B');


        


     }    
     


    }  


