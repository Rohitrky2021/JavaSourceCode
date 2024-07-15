import java.util.Scanner;

public class sum_of_first_n {
    public static void main(String args[]) 
    {int sum=0;
        System.out.println("enter the last no. till u want the sum ");
        Scanner sc=new Scanner(System.in);
        
        int n;
n=sc.nextInt();
System.out.println("till n u want is:"+ n);
        while(n>0)
        {sum +=n;  /*8888888888888888888888888888888888888888888888888888888888888888888888888888888 */
            n--;

        }
        System.out.println("the sum is:"+ sum);
    }
    
}
