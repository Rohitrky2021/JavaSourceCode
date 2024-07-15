import java.util.*;
public class Good_Integer {
    static int getProduct(int n)
    {
        int product = 1;
 
        while (n != 0) {
            product = product * (n % 10);
            n = n / 10;
        }
 
        return product;
    }
    
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        // int arr[]=new int[5];
        while(T-->0){
          int n=sc.nextInt()+1;
          int k=sc.nextInt();
          int product=1,count=0;
          while(product%k!=0){
          product=getProduct(n);
          n+=1;
            count++;

Integer.MAX_VALUE

        }
        if(count==0){
            continue;
        }
        else{
        System.out.println(count);
        }
    }
}
}

