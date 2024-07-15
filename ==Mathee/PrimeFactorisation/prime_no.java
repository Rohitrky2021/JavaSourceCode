package PrimeFactorisation;

 
import java.util.*;
public class prime_no{ 


 public static boolean isprime(int n){//Normal checking for that n
    if (n==2){
        return true;
    }
   
    for(int i=2;1<=n-1;i++){
        if((n-1)/i == 0)
        return false;
    }return true;
 }



 public static boolean isprimem(int n){// Optimised One Using -->Square-Root 
    if (n==2){
        return true;
    }
    for(int i=2;1<=Math.sqrt(n-1);i++){
        if((n-1)/i == 0)
        return false;
    }return true;
 }
    


public static void main (String args[]){
    System.out.println(isprime(8));
    System.out.println("the fast ans is"+isprimem(8));

}
}