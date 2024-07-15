/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{ 
		FastReader sc = new FastReader();
	    PrintWriter pw = new PrintWriter(System.out);
	    int t = sc.nextInt();
	    while(t-- > 0){ 
	        int n = sc.nextInt();
	        String str = sc.next();
	        char prev = 'a';
	        int ans = 0;
	        for(int i=0;i<n;i++){
	           char x = str.charAt(i);
	           boolean flag = false;
	           if(x != prev){
	               prev = x;
	               flag = true;
	           }
	           if(flag && prev == '1'){
	               ans++;
	               flag = false;
	           } pw.
	           flag = false;
	        }
	        if(str.charAt(n-1) == '1'){
	            ans--;
	        }
	        pw.println(ans);
	    }
	    pw.flush();
	}
	
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
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
