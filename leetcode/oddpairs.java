import java.util.Scanner;
public class oddpairs {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int n=sc.nextInt();
            // System.out.println(fun(n)); 
            // for (int i = 1; i <= n; i++) {
                r(n);
            // }
        }
    }
    public static int fun(int n){
        int ecount=0;
        int ocount=0;
        if(n==0){
            return ocount;
        }
        if( (n&1)==0){
            // if((n-1&1)==1){
                ecount++;
                return fun(n-1);

            // }
        }
        if( (n&1)==1){
            // if((n-1&1)==0){
                ocount++;
                return fun(n-1);

            // }
        }
        return ocount*2;


        
    }
    public static void r(int n){
        int ecount=0;
        int ocount=0;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= n; j++) {
                int c=i+j;
                if((c&1)!=0){
                    ecount++;
                }
            }
            
        }
        System.out.println(ecount);

    }
}
