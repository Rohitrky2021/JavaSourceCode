
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class RealE {
 
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
            byte[] buf = new byte[64]; // line length 
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
	public static void main (String[] args) throws java.lang.Exception
	{
	   Reader sc = new Reader();
	   int t = sc.nextInt();
	   
	   while(t-- > 0)
	   {
	   int n = sc.nextInt();
	   int m = sc.nextInt();
	   int k = sc.nextInt();
	   int cnt[] = new int[n+1];
	   int arr[][] = new int[m][2];
	   for(int i = 0 ; i < m ; i++)
	   {
	       int l = sc.nextInt();
	       int r = sc.nextInt();
	       arr[i][0] = l;
	       arr[i][1] = r;
	       cnt[l]++;
	       if(r+1 <= n)
	       cnt[r+1]--;
	   }
	   
	    int ans = 0 , mx = 0;
	   for(int i = 1 ; i <= n ; i++)
	   {
	       cnt[i] += cnt[i-1];
	       if(cnt[i] == 0)
	       ans++;
	   }
	   
	   int ones[] = new int[n+1];
	   int twos[] = new int[n+1];
	   for(int i = 1 ; i <= n ; i++)
	   {
	       ones[i] = ones[i-1];
	       if(cnt[i] == 1)
	       ones[i]++;
	       
	       twos[i] = twos[i-1];
	       if(cnt[i] == 2)
	       twos[i]++;
	   }
	   
	  mx = ans;
	  
	  int single[] = new int[m];
	  
	  ArrayList<Integer> start[] = new ArrayList[n+1];
	  ArrayList<Integer> end[] = new ArrayList[n+1];
	  for(int i = 1 ; i <= n ; i++)
	  {
	      start[i] = new ArrayList<Integer>();
	      end[i] = new ArrayList<Integer>();
	  }
	  
	  int tot = 0;
	  
	  int mx1 = 0 , mx2 = 0;
	  for(int i = 0 ; i < m ; i++)
	  {
	      single[i] = ones[arr[i][1]]-ones[arr[i][0]-1];
	      if(single[i] > mx2)
	      {
	          mx1 = mx2;
	          mx2 = single[i];
	      }
	      
	      else if(single[i] > mx1)
	      {
	          mx1 = single[i];
	      }
	      
	      start[arr[i][0]].add(i);
	      end[arr[i][1]].add(i);
	  }
	  
	  mx = Math.max(mx,mx1+mx2+ans);
	  TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
	  
	  for(int i = 1 ; i <= n ; i++)
	  {
	      for(Integer v : start[i])
	      {
	          map.put(v,1);
	          tot++;
	      }
	      
	      if(tot == 2)
	      {
	          int f = map.firstKey();
	          int l = map.lastKey();
	          
	          int ll = Math.max(arr[f][0],arr[l][0]);
	          int rr = Math.min(arr[f][1],arr[l][1]);
	          
	          if(ll <= rr)
	          {
	              mx = Math.max(mx,single[f]+single[l]+twos[rr]-twos[ll-1]+ans);
	          }
	      }
	      
	      for(Integer v : end[i])
	      {
	          map.remove(v);
	          tot--;
	      }
	  }
	  
	  System.out.println(mx);
	  
	   }
	}
}