import java.util.*;
import java.lang.*;
import java.io.*;

class B
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            
            while (T-- > 0){
                int n=sc.nextInt(); 
                int m=sc.nextInt(); 
                 

                int check=(int) (m*11)-n*10;
                System.out.println(check+" c");
                
                System.out.println((int)Math.ceil((check*1.0)/100));
                


                
            }

	}
}
