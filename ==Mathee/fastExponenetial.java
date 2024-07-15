import java.util.*;

public class fastExponenetial{
    public static void main(String[] args) {
        int n = 4;
        int ans=1,a=2;
        

        while(n>0){
            System.out.println(ans);
            
            if((n&1)!=0){
                ans*=a;
            }
            a*=a;
            // System.out.println("dwon -1--"+a);
            n=n>>1;
            // System.out.println("dwon -2--"+n);

        }
        
        
        
        System.out.println(ans);



        
    }
    
public static int xpown(long x, long n, long p) {
    long res = 1;
    while (n > 0) {
        if (n % 2 != 0) {
            res = (res * x) % p;
            n--;
        } else {
            x = (x * x) % p;
            n = n / 2;
        }
    }
    return  (int)(res % p);
}

public static long longxpown(long x, long n, long p) {
    long res = 1;
    while (n > 0) {
        if (n % 2 != 0) {
            res = (res * x) % p;
            n--;
        } else {
            x = (x * x) % p;
            n = n / 2;
        }
    }
    return res % p;
}

    public static List<Integer> findFactors(int number) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
                System.out.println(i);
                

                // Check if the factor is not the square root of the number
                if (i != number / i) {
                    factors.add(number / i);
                    System.out.println(number/i);

                }
            }
        }

        return factors;
    }
}
