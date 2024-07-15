import java.util.*;
public class flip2 {
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        long T=sc.nextLong();
        while(T-->0){
            long n=sc.nextLong();
            long m=sc.nextLong();
            // long x=sc.nextLong();
            // for(int i=m;i<n;i++){
            //     if((n*n)/(i*m)<0){

            //     }
            // }
            System.out.println(max(n, m));
            
            
        }
    }
    public static long max(long x,long m){
        int c=0;
        if((x*x)>(m*m)){
            return 1;
        }
        // long c=x*x;
        long r=max(x*x,m);
        c++;
        System.out.println(c);
        return r;
    }
}
