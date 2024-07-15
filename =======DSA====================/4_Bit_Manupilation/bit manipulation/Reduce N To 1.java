import java.io.*;
import java.util.*;

public class Main {

    public static int solution(long n) {
        //write your code here
        int res = 0; 
        
        while(n != 1){
            if(n % 2 == 0){
                n = n / 2;
            } else if(n == 3){
                res = 2;
                break;
            } else if((n & 3) == 1){
                n = n - 1;
            } else if((n & 3) == 3){
                n = n + 1;
            }
            
            res++;
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        System.out.println(solution(n));
    }
	
	
}