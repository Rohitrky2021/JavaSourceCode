import java.util.*;
public class cp1 {
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
        int arr[]=new int[5];
        while(T-->0){
          int n=sc.nextInt();
          int k=sc.nextInt();
          int product=1,count=0;
          while(product%k!=0){
          product=getProduct(n);
          n+=1;
            count++;



        }
        System.out.println(count-1);
    }
}
}