import java.util.*;

public class power {
    public static void main(String args[]){
        System.out.println(powere(2, 3));
        System.out.println(dppower(10, 6));
 
    }
    public static int powere(int a,int b){
        if (b==0){
            return 1;
        }
        return a*powere(a,b-1);
    }
    public static int dppower(int a,int n){
        if(n==1){
            return a;
        }
        // int x=dppower(a, n/2)*dppower(a, n/2);//calling this 2 times bad process
        System.out.println("loop pow up n -.>"+n);

        int x=dppower(a, n/2);
        System.out.println("loop pow low n -.>"+n);

        System.out.println("loop pow low -.>"+n/2);

        if(n%2!=0){
            return x*a*x;
        }
        return x*x;
    }
}
  