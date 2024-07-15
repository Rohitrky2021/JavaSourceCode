import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;
import java.io.PrintStream;
import java.util.*;

class Codechef {

	// public static final boolean LOCAL = System.getProperty("ONLINE_JUDGE")==null;
	private static FastScanner fs = new FastScanner();
	private static Scanner sc = new Scanner(System.in);

	private static void solve(int t) throws Exception {
		
		int n=fs.nextInt();
		String s=fs.next();
		
		int preone[]=new int[n];
		
		for(int i=0;i<n;i++  ) {
			if( i==0 ) {
				if( s.charAt(i)=='1' ) preone[i]=1;
			}else {
				if( s.charAt(i)=='1' ) {
					preone[i]=preone[i-1]+1;
				}else {
					preone[i]=preone[i-1];
				}
			}
		}

		
		int postzero[]=new int[n];
		
		for(int i=n-1;i>=0;i--  ) {
			if( i==n-1 ) {
				if( s.charAt(i)=='0' ) postzero[i]=1;
			}else {
				if( s.charAt(i)=='0' ) {
					postzero[i]=postzero[i+1]+1;
				}else {
					postzero[i]=postzero[i+1];
				}
			}
	
		}

		
		int ans=n;

		
		for( int i=0;i<n;i++ ) {
			int v=0;
			v=preone[i];
			if( i<n-1 )
				v+=postzero[i+1];
			
			ans=Math.min(ans, v);
			
		}
		
		
		
		ans=Math.min( postzero[0] , ans);
		ans=Math.min( preone[n-1] , ans);
		
		
		
		System.out.println(ans);
			
		
	}
	
	
	
	


	static long gcd(long a, long b) {
		if (b == 0l) {
			return a;
		}

		return gcd(b, a % b);
	}
	
	static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		int sqr=(int)Math.sqrt(n);
		for (int i = 2; i <=sqr ; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) throws Exception {
		int tcr = 1;
		// tcr = sc.nextInt();
		tcr = fs.nextInt();
		
		//sieve=sieve() ;
		
		while (tcr-- > 0) {
			solve(tcr);
		}
		System.gc();
	}

	static class FastScanner {

		BufferedReader br;
		StringTokenizer st;

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		FastScanner(String file) {

			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				st = new StringTokenizer("");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("file not found");
				e.printStackTrace();
			}

		}

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String readLine() throws IOException {
			return br.readLine();
		}
	}

	
}
