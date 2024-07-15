public class LinearDiophantineEquation {
    // Nothing Just the application of Extended Euclidain Algo
    // You have been given three Integers a, b and k. you need to find an integral solution of x and y such that . 

    // It can be proven that solution always exist.
    // Input Format
    // The first line contains 3 integer a, b and k.

    // can covert it to  previos  Euclidain
    // a*x + b*y= k * gcd(a,b)==>  shift k  to left by diving by k ;===> But by this we will get Only one Solution 
    // What if we want all soln ==> by X--> X-b/G  && y-->Y+a/G;  --> Inke Multiples Ko Add and Subtract krkte rehna for all ans ;;
    public static class Pair {
		long x;
		long y;
		long gcd;

		public Pair(long x, long y, long gcd) {
			this.x = x;
			this.y = y;
			this.gcd = gcd;
		}
	}
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
        int k = scn.nextInt();
        
		Pair ans = euclids(a, b);
        ans.x *= k;
        ans.y *= k;

		System.out.println(ans.x + " " + ans.y);  
    }
    
	public static Pair euclids(long a, long b) {
		if (b == 0) {
			return new Pair(1, 0, a);
		}
		Pair dash = euclids(b, a % b);

		return new Pair(dash.y, dash.x - ((a / b) * dash.y), dash.gcd);
	}
}
// Sample Input
// 3 5 8
// Sample Output
// 16 -8

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-interview-prep/number-theory/linear-diophantine-equation-official/ojquestion