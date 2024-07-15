import java.util.*;

public class ExtendedEuclidian {
//     You have been given two Integers a and b. you need to find an integral solution of x and y such that 
// ====>>>>>  a*x + b*y= gcd(a,b).
// It can be proven that solution always exist.
// Input Format
// The first line contains 2 integer a and b
// Output Format
// output integral value of x and y in a single line.

    public static class Pair{
        long x,y,gcd;
        public  Pair(long x,long y,long gcd){
            this.x=x;
            this.y=y;
            this.gcd=gcd;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		Pair ans = euclids(a, b);
		System.out.println(ans.x + " " + ans.y);
        
    }

    public static Pair euclids(long a, long b) {
		if (b == 0) {
			return new Pair(1, 0, a);
		}
		Pair dash = euclids(b, a % b);
        
        long cX=dash.y;
        long cY=dash.x - ((a / b) * dash.y);

		return new Pair(cX,cY, dash.gcd);
	}
}

// Sample Input
// 34
// 24
// Sample Output
// 5 -7  ==> x and y

               
                                
                                