import java.util.Scanner;

public class equano {
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        long T=sc.nextLong();
        while(T-->0){
            long diff=0;
            long s=sc.nextLong();
            long fu=sc.nextLong();
            long x=sc.nextLong();
            if((s-fu)<0){
                diff=fu-s;
                }
            else{
                diff=s-fu;
            }     
            if(x==1){
                System.out.println("Yes");
            }
            else if(s==fu){
                System.out.println("Yes");
            }
            else if(diff%(2*x)==0){
                System.out.println("yes");
            }

            else{
                System.out.println("no");
            }

        }
    }
}
