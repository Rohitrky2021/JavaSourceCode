// Java program to check if the binary String is divisible
// by 3.
import java.util.*;

class Minimize_swaps
{

// Function to check if the binary String is divisible by 3.
static void CheckDivisibilty(String A)
{
	int oddbits = 0, evenbits = 0;
    int zero=0;
	for (int counter = 0; counter < A.length(); counter++)
	{
	
		// checking if the bit is nonzero
		if (A.charAt(counter) == '1')
		{
		
			// checking if the nonzero bit is at even
			// position
			if (counter % 2 == 0) {
				evenbits++;
			}
			else {
				oddbits++;
			}
		}
        else{
            zero++;
            
        }
	}
    
	// Checking if the difference of non-zero oddbits and
	// evenbits is divisible by 3.
	if (Math.abs(oddbits - evenbits) % 3 == 0) {
        System.out.println("0");
	}
    
    else if(zero==0){
        System.out.println("-1");
    }
	else {
        System.out.println((Math.abs(oddbits - evenbits) % 3));
		// System.out.print("No" +"\n");
	} 
}

// Driver Program
public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    int T=sc.nextInt();
    // int arr[]=new int[5];
    while(T-->0){
        String A=sc.next();
        CheckDivisibilty(A);
        System.out.println(Integer.parseInt(A, 2));
        System.out.println(Integer.parseInt("10101", 2));


    }
}
}

// This code is contributed by umadevi9616

// Scanner sc=new Scanner(System.in);
// String A = "10101";







