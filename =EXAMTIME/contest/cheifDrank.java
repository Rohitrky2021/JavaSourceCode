import java.util.Scanner;

public class cheifDrank {
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
        int n=sc.nextInt();
        if(n>=2000){
            System.out.println("yes");
        }
        else{
            System.out.println("NO");
        }
    }
        
    }
}
