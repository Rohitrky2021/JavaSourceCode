import java.util.*;
public class square {
    // A brute force approach based implementation
// to find if a number can be written as sum
// of two squares.


	
	// function to check if there exist two
	// numbers sum of whose squares is n.
	public static boolean sumSquare(long n)
	{
		for (long i = 1; i * i <= n; i++)
			for (long j = 1; j * j <= n; j++)
				if (i * i + j * j == n) {
					System.out.println(i+" "+j);
									 
					return true;
	}

		return false;
	}
	
	// driver Program
	public static void main(String args[])
	{
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        // int arr[]=new int[5];
        while(T-->0){
            String n=sc.nextLine();

            
            if (sumSquare(n))
            return;
                        // System.out.println("Yes");
                    else
                        System.out.println("No");
        }
		
	}
}


/*This code is contributed by Nikita Tiwari.*/
