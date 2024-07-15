/* package codechef; // don't place package name! */
/*Author: Jatin Yadav*/
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[10001]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
   



    //GCD OR HCF CALCULATION
    public static long gcd(long a,long b){
        if(b==0){
            return a;

        }
        return gcd(b,a%b);
    }



    //BINARY EXPONENTIATION
    public static long binpow(long a,long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1)==1)
                res = res * a;
            a = a * a;
            b >>= 1;
        }
        return res;
    }
    
    
    static int nCr(int n, int r)
    {
        return fact(n) / (fact(r) *
                fact(n - r));
    }

    // Returns factorial of n
    static int fact(int n)
    {
        if(n==0)
            return 1;
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
   
   
   
   
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Reader s = new Reader();
        long t = s.nextLong();
        //int t =1;

        while (t-- > 0) {
            long n = s.nextLong();
            long c=0;
            
            String str = s.readLine();
            for(int i=0; i<n-1; i++){
                if(str.charAt(i)=='1' && str.charAt(i+1)=='0'){
                    c++;
                    
                }
                
                
            }
            System.out.println(c);
        }
	}
}
