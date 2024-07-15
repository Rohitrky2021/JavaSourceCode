import java.util.Arrays;
import java.util.Scanner;

public class A_7{
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int L=sc.nextInt();
        String[] s=new String[N];
        sc.nextLine();
        while(N-->0){
        
            s[N]=sc.nextLine();
                
        }
        
       
        Arrays.sort(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        String ans="";
        for(String alpha:s){
            ans += alpha;
        }
        System.out.println(ans);


   

    
    }

}
