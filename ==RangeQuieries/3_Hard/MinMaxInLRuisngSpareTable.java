import java.io.*;
import java.util.*;
// << M1 >>-->using segment TREE
// --------------------------------------
// The above segment tree-based solution also allows array updates also to happen in O(Log n) time.
//  Assume a situation when there are no updates (or the array is static).
//   We can actually process all queries in O(1) time with some preprocessing.
//    One simple solution is to make a 2D table of nodes that stores all ranges minimum and maximum.
//     This solution requires O(1) query time but requires O(N^2) preprocessing time and O(N^2) extra space 
//     which can be a problem for large N.
    

// << M2 >>---> More efficient way 
// -------------------------------------
// We can solve this problem in O(1) query time AND O(N)--FOR WORST,
//  O(n Log n) space and O(n Log n) preprocessing time 
// using the Sparse Table.
// query operation in O(1) time with O(n Log n) preprocessing time and O(n Log n) space.
public class MinMaxInLRuisngSpareTable {
// public class Main {
      static InputReader in = new InputReader(System.in);
      static PrintWriter out = new PrintWriter(System.out);
      /*
      input functions in.nextInt();     in.nextIntArray(n);      in.nextIntArray1(n);
      output fnctions out.println();    out.print();
    
      use in for reading input
      use out for printing output
      */
    
      static int table[][];
    
      static void build(int n, int arr[]) {
        int k = (int)(Math.log(n) / Math.log(2));
        table = new int[k + 1][n];
        table[0] = arr;
        for (int j = 1; j <= k; j++) {
          for (int i = 0; i + (1 << j) <= n; i++) {
            // THIS FOR MAX 
            // table[j][i] = Math.min(table[j - 1][i], table[j - 1][i + (1 << (j - 1))]);

            // FOR MIN 
            table[j][i] = Math.max(table[j - 1][i], table[j - 1][i + (1 << (j - 1))]);

            // table[i][j] = table[i][j - 1] + table[i + (1 << (j - 1))][j - 1];
            // table[j][i] = (table[j - 1][i] + table[j - 1][i + (1 << (j - 1))]);



          }
        }
      }
//       static void buildSparseTable(int arr[],int n)
// {
//     for (int i = 0; i < n; i++)
//         table[i][0] = arr[i];
 
//     for (int j = 1; j <= k; j++)
//         for (int i = 0; i <= n - (1 << j); i++)
//             table[i][j] = table[i][j - 1] + table[i + (1 << (j - 1))][j - 1];
// }
    
      static int query(int l, int r) {
        int count = r - l + 1;
        int k = (int)(Math.log(count) / Math.log(2)); //2^k
        return Math.min(table[k][l], table[k][r - (1 << k) + 1]);
      }
    
    
      public static void main(String[] args) throws IOException {
    
        int n = in.nextInt();
        int arr[] = in.nextIntArray(n);
    
        build(n, arr);
    
        int q = in.nextInt();
    
        while (q-- > 0) {
          int l = in.nextInt();
          int r = in.nextInt();
          out.println(query(l, r));
        }
    
        out.close();
      }
    
      private static class InputReader implements AutoCloseable {
    
        private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    
    
        private static final InputStream DEFAULT_STREAM = System.in;
    
        private static final int MAX_DECIMAL_PRECISION = 21;
    
        private int c;
    
        private final byte[] buf;
        private final int bufferSize;
        private int bufIndex;
        private int numBytesRead;
    
        private final InputStream stream;
    
        private static final byte EOF = -1;
    
        private static final byte NEW_LINE = 10;
    
        private static final byte SPACE = 32;
    
        private static final byte DASH = 45;
    
        private static final byte DOT = 46;
        private char[] charBuffer;
        private static final byte[] bytes = new byte[58];
        private static final int[] ints = new int[58];
        private static final char[] chars = new char[128];
    
        static {
          char ch = ' ';
          int value = 0;
          byte _byte = 0;
          for (int i = 48; i < 58; i++)
            bytes[i] = _byte++;
          for (int i = 48; i < 58; i++)
            ints[i] = value++;
          for (int i = 32; i < 128; i++)
            chars[i] = ch++;
        }
    
        public InputReader() {
          this(DEFAULT_STREAM, DEFAULT_BUFFER_SIZE);
        }
        public InputReader(int bufferSize) {
          this(DEFAULT_STREAM, bufferSize);
        }
        public InputReader(InputStream stream) {
          this(stream, DEFAULT_BUFFER_SIZE);
        }
        public InputReader(InputStream stream, int bufferSize) {
          if (stream == null || bufferSize <= 0)
            throw new IllegalArgumentException();
          buf = new byte[bufferSize];
          charBuffer = new char[128];
          this.bufferSize = bufferSize;
          this.stream = stream;
        }
        private byte read() throws IOException {
    
          if (numBytesRead == EOF)
            throw new IOException();
    
          if (bufIndex >= numBytesRead) {
            bufIndex = 0;
            numBytesRead = stream.read(buf);
            if (numBytesRead == EOF)
              return EOF;
          }
    
          return buf[bufIndex++];
        }
        private int readJunk(int token) throws IOException {
    
          if (numBytesRead == EOF)
            return EOF;
          do {
    
            while (bufIndex < numBytesRead) {
              if (buf[bufIndex] > token)
                return 0;
              bufIndex++;
            }
            numBytesRead = stream.read(buf);
            if (numBytesRead == EOF)
              return EOF;
            bufIndex = 0;
    
          } while (true);
    
        }
        public byte nextByte() throws IOException {
          return (byte) nextInt();
        }
        public int nextInt() throws IOException {
    
          if (readJunk(DASH - 1) == EOF)
            throw new IOException();
          int sgn = 1, res = 0;
    
          c = buf[bufIndex];
          if (c == DASH) {
            sgn = -1;
            bufIndex++;
          }
    
          do {
    
            while (bufIndex < numBytesRead) {
              if (buf[bufIndex] > SPACE) {
                res = (res << 3) + (res << 1);
                res += ints[buf[bufIndex++]];
              } else {
                bufIndex++;
                return res * sgn;
              }
            }
            numBytesRead = stream.read(buf);
            if (numBytesRead == EOF)
              return res * sgn;
            bufIndex = 0;
    
          } while (true);
    
        }
        public int[] nextIntArray(int n) throws IOException {
          int[] ar = new int[n];
          for (int i = 0; i < n; i++)
            ar[i] = nextInt();
          return ar;
        }
        public int[] nextIntArray1(int n) throws IOException {
          int[] ar = new int[n + 1];
          for (int i = 1; i <= n; i++)
            ar[i] = nextInt();
          return ar;
        }
        public void close() throws IOException {
          stream.close();
        }
    
      }
    }
                                    
