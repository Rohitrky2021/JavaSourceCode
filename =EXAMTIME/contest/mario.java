import java.util.Scanner;

public class mario {
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        
        while(T-->0){
            int n=sc.nextInt(); 
           String s=new String();
           s=sc.next();
           String s2=s.substring((s.length())/2);
           String s1=s.substring(0, (s.length())/2);
            if(s1.equals(s2)){
                System.out.println("YES");
            }
            
            else{
                System.out.println("NO");
            }
            System.out.println(s1+s2);
        }
        
    }
}
