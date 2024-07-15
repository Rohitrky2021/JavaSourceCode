import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.*;
public class nCrModP {
//You have T test cases and for each test case you have been given n and r values and you need to find nCr mod 10^9+7.
// Input Format
// The first line contains an integer T.
// Next T lines contain integers n and r.
// Output Format
// for each query print nCr mod 10^9+7 in a line.
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		long[][] ncr = ncrcoll(5005, 5005);  // N value was given in Question N<5000   
		while (t-- > 0) {
			String[] st = br.readLine().split(" ");
			int n = Integer.parseInt(st[0]);
			int r = Integer.parseInt(st[1]);
			sb.append(ncr[n][r] + "\n");
		}

		System.out.println(sb);
	}

    static int p=1000000007;  // or can be written as  
    // int number = 1_000_000_007;  // Using underscores for readability

    // Iterative DP Approach --> for evry quuire will now in O(N)
	static long[][] ncrcoll(int n, int k) {
		long[][] arr = new long[n + 1][k + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i][0] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= i && j < arr[0].length; j++) {
				if (i == 1 && j == 1) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = (arr[i - 1][j] + arr[i - 1][j - 1]) % (p);
				}
			}
		}
		return arr;
	}
    
}

                                
                                
                                