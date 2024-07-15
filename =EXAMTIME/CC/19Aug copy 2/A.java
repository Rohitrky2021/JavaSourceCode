import java.util.*;
import java.lang.*;
import java.io.*;

class A
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            
            while (T-- > 0){
                int n=sc.nextInt(); 
                int m=sc.nextInt(); 
                if(n==1){
                    System.out.println("YES");
                    continue;
                }

                int check=m+1 +( m*(m+1)/2);

                if(n<check){
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
                }



                
            }

	}
}
