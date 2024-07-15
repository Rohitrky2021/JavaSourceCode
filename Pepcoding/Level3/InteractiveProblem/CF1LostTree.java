public class CF1LostTree {

    // Distance Away Nodes From me 
    // Key point to calculate all edges calculate for all odd level node edges or even one 
    // or ye Odd even k liye --> Make a array from Root Node jha root se sbka distance store hoga --> This Distance from Node arr[] Given 
    // i.e all array index having odd num odd level m aayenge and same goes with the Even 


    
    // Q---> https://codeforces.com/contest/1534/problem/D

    // Code--> https://codeforces.com/contest/1534/submission/125742778

    import java.util.*;
import java.io.*;
import java.math.*;

public class lost_tree {
	static StringBuilder sb;
	static long fact[];
	static int mod = (int) (1e9 + 7);

	static class Pair implements Comparable<Pair> {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Pair o) {
			return (int) (this.y - o.y);

		}

	}

	static void solve() {
		int n = i();

		int[][] map = new int[n + 1][n + 1];
		System.out.println("? " + 1);

		int[] arr = readArray(n);
		System.out.flush();

		int even = 0;
		int odd = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 1) {
				map[1][i + 1] = 1;
				map[i + 1][1] = 1;
			}
			if (arr[i] % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}

		int check = -1;
		if (even <= odd) {
			check = 0;
		} else {
			check = 1;
		}

		for (int i = 2; i <= n; i++) {
			if (arr[i - 1] % 2 == check) {
				System.out.println("? " + i);

				int[] arr1 = readArray(n);
				System.out.flush();

				for (int j = 0; j < n; j++) {
					if (arr1[j] == 1) {
						map[i][j + 1] = 1;
						map[j + 1][i] = 1;
					}
				}
			}
		}

		sb.append("!\n");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (map[i][j] == 1) {
					sb.append(i + " " + j + "\n");
				}
			}
		}

	}

	public static void main(String[] args) {
		sb = new StringBuilder();
		int test = 1;
		while (test-- > 0) {
			solve();
		}
		System.out.println(sb);

	}

	/*
	 * fact=new long[(int)1e6+10]; fact[0]=fact[1]=1; for(int i=2;i<fact.length;i++)
	 * { fact[i]=((long)(i%mod)*1L*(long)(fact[i-1]%mod))%mod; }
	 */**
	// *******************************************NCR%P*****************************************************

	static long p(long x, long y)// POWER FXN //
	{
		if (y == 0)
			return 1;

		long res = 1;
		while (y > 0) {
			if (y % 2 == 1) {
				res = (res * x) % mod;
				y--;
			}

			x = (x * x) % mod;
			y = y / 2;

		}
		return res;
	}

	static long ncr(int n, int r) {
		if (r > n)
			return (long) 0;

		long res = fact[n] % mod;
		// System.out.println(res);
		res = ((long) (res % mod) * (long) (p(fact[r], mod - 2) % mod)) % mod;
		res = ((long) (res % mod) * (long) (p(fact[n - r], mod - 2) % mod)) % mod;
		// System.out.println(res);
		return res;

	}

	// *******************************************END*******************************************************

	// *********************************Disjoint set
	// union*************************//

	// *******************************************PRIME FACTORIZE
	// *****************************************************************************************************//
	static TreeMap<Integer, Integer> prime(long n) {
		TreeMap<Integer, Integer> h = new TreeMap<>();
		long num = n;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (n % i == 0) {
				int nt = 0;
				while (n % i == 0) {
					n = n / i;
					nt++;
				}
				h.put(i, nt);
			}
		}
		if (n != 1)
			h.put((int) n, 1);
		return h;

	}

	// *************CLASS PAIR
	// ***********************************************************************************************************************************************

	// *************CLASS PAIR
	// *****************************************************************************************************************************************************

	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int Int() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String String() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() {
			return String();
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}

	static class OutputWriter {
		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}

		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		public void printLine(Object... objects) {
			print(objects);
			writer.println();
		}

		public void close() {
			writer.close();
		}

		public void flush() {
			writer.flush();
		}
	}

	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);

	public static long[] sort(long[] a2) {
		int n = a2.length;
		ArrayList<Long> l = new ArrayList<>();
		for (long i : a2)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < l.size(); i++)
			a2[i] = l.get(i);
		return a2;
	}

	public static long pow(long x, long y) {
		long res = 1;
		while (y > 0) {
			if (y % 2 != 0) {
				res = (res * x);// % modulus;
				y--;

			}
			x = (x * x);// % modulus;
			y = y / 2;
		}
		return res;
	}

	// GCD___+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static long gcd(long x, long y) {
		if (x == 0)
			return y;
		else
			return gcd(y % x, x);
	}
	// ****************LOWEST COMMON MULTIPLE
	// *************************************************************************************************************************************

	public static long lcm(long x, long y) {
		return (x * (y / gcd(x, y)));
	}

	// INPUT
	// PATTERN******************************************************************************************************************************************************************
	public static int i() {
		return in.Int();
	}

	public static long l() {
		String s = in.String();
		return Long.parseLong(s);
	}

	public static String s() {
		return in.String();
	}

	public static int[] readArray(int n) {
		int A[] = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = i();
		}
		return A;
	}

	public static long[] readArray(long n) {
		long A[] = new long[(int) n];
		for (int i = 0; i < n; i++) {
			A[i] = l();
		}
		return A;
	}

}
}
