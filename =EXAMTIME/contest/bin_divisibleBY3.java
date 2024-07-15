// Java program to check if the binary String is divisible
// by 3.
import java.util.*;

class bin_divisibleBY3
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
        System.out.print("0" +"\n");
	}
    
    else if(zero==0){
        System.out.println("-1");
    }
	else {
        System.out.println((Math.abs(oddbits - evenbits) % 3)/2);
		// System.out.print("No" +"\n");
	}
}

// Driver Program
public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
	// String A = "10101";
    String A= sc.nextLine();
	CheckDivisibilty(A);
}
}

// This code is contributed by umadevi9616

