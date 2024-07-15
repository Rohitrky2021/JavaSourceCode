import java.util.*;



import java.io.*;
import java.lang.reflect.Method;
import java.math.*;

public class Main {

	// -- static variables --- //
	static FastReader		sc	= new FastReader();
	static PrintWriter	out	= new PrintWriter(System.out);
	static int					mod	= (int) 1000000007;

	public static void main(String[] args) throws Exception {

		int t = sc.nextInt();
		while (t-- > 0)
			Main.go();
		// out.println();
		out.flush();
	}

	// >>>>>>>>>>>>>>>>>>> Code Starts <<<<<<<<<<<<<<<<<<<< //
	static class pair {
		int x, y;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			pair other = (pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		pair(pair p){
			this.x=p.x;
			this.y=p.y;
		}
	}

	/*
	 * 1) Read the statements and abstract out the task.
	 * 2)Read the constraints carefully to note some limitations.
	 * 3)Do look at the sample values if you to be sure that what you have understood is correct.
	 * 4)Think about the problem and see if there is a connection between any previously solved problems.
	 * 5)Write any brute force approach first and try to optimise it.
	 * 6)Try some elimination process, try out by taking small examples and asking question to yourself.
	 * 7) Structure code before you write the code.
	 * 8)Debug the code, by trying to some few more testcase. Going through the code from beginning.
	 * 9)Don't stuck on a particular idea.
	 * 10)Try same problem with some different idea.
	 */
	
	static void go() throws Exception {
		int n=sc.nextInt();
		char a[] = sc.next().toCharArray();
		if(a[0]=='1') {
			int i = 1; 
			int blocks=0;
			while(i<n) {
				int j=i;
				
				while(j<n && a[j]=='1') {j+=1;continue;}
				
				i=j;
				while(i+1< n && a[i]<=a[i+1]) {
					i+=1;
				}
				blocks +=1;
				i+=1;
			}
			out.println(blocks);
			return;
		}else {
			int i=0;
			for(;i<n;i++) {
				if(a[i]=='1') {
					break;
				}
			}
			i+=1;
			int blocks=0;
			while(i<n) {
				int j=i;
				
				while(j<n && a[j]=='1') {j+=1;continue;}
				
				i=j;
				while(i+1< n && a[i]<=a[i+1]) {
					i+=1;
				}
				blocks +=1;
				i+=1;
			}
			out.println(blocks);
			return;
		}
		
		
	}


  

	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	// >>>>>>>>>>> Code Ends <<<<<<<<< //

	// --For Rounding--//
	static double round(double value, int places) {

		if (places < 0)
			throw new IllegalArgumentException();
		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	// ----Greatest Common Divisor-----//
	static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	// --- permutations and Combinations ---//
	static long	fact[];
	static long	invfact[];

	static long ncr(int n, int k) {
		if (k < 0 || k > n) {
			return 0;
		}
		long x = fact[n];
		long y = fact[k];
		long yy = fact[n - k];
		long ans = (x / y);
		ans = (ans / yy);
		return ans;
	}

	// ---sieve---//
	static int prime[] = new int[1000006];

	// static void sieve() {
	//     Arrays.fill(prime, 1);
	//     prime[0] = 0;
	//     prime[1] = 0;
	//     for (int i = 2; i * i <= 1000005; i++) {
	//         if (prime[i] == 1)
	//             for (int j = i * i; j <= 1000005; j += i) {
	//                 prime[j] = 0;
	//             }
	//     }
	// }

	// ---- Manual sort ------//
	static void sort(long[] a) {
		ArrayList<Long> aa = new ArrayList<>();
		for (long i : a) {
			aa.add(i);
		}
		Collections.sort(aa);
		for (int i = 0; i < a.length; i++)
			a[i] = aa.get(i);
	}

	static void sort(int[] a) {
		ArrayList<Integer> aa = new ArrayList<>();
		for (int i : a) {
			aa.add(i);
		}
		Collections.sort(aa);
		for (int i = 0; i < a.length; i++)
			a[i] = aa.get(i);
	}

	// --- Fast exponentiation ---//
	static long pow(long x, long y) {
		long res = 1l;
		while (y != 0) {
			if (y % 2 == 1) {
				res = (x * res);
			}
			y /= 2;
			x = (x * x);
		}
		return res;
	}

	// >>>>>>>>>>>>>>> Fast IO <<<<<<<<<<<<<< //
	static class FastReader {
		BufferedReader	br;
		StringTokenizer	st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		int[] intArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			return a;
		}

		long[] longArray(int n) {
			long a[] = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextLong();
			return a;
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
