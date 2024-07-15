
 
import java.io.*;
import java.util.*;
public class tank {
    static int mod = (int) 1e9 + 7;
    static int mod2 = 998244353;
    static FastReader sc = new FastReader(System.in);
    //static Scanner sc=new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int dx[]={-1,1,0,0};
    static int dy[]={0,0,-1,1};
    //static int t[];
//    static boolean checkk;
//    static int ans_ch=0;
    static ArrayList<Integer>as[];
    static HashSet<Integer> t[];
    static ArrayList<Integer> chh;
    static long ans=1;
    public static void main(String[] args) throws IOException {

        int tt = sc.nextInt();
        //int tt = 1;
        Gr1zler:
        for (int WTF = 0; WTF < tt; WTF++) {
            int n=sc.nextInt();
            long c=sc.nextInt();
            long a[]=sc.nextArrLong(n);
            PriorityQueue<Pair> s=new PriorityQueue<>(Comparator.comparingLong(x -> x.y));
            long sum=a[0];
            for(long i=1;i<n;i++){
                s.add(new Pair((int)i,c*(i+1)-a[(int)i]));
            }
            boolean ch=true;
            while(!s.isEmpty()){
                //out.println(s.peek().x+" "+s.peek().y);
                if(s.peek().y-sum>0){
                    ch=false;
                    break ;
                }else{
                    sum+=a[s.peek().x];
                    s.poll();
                }
            }
            if(ch){
                out.println("Yes");
            }else{
                out.println("No");
            }

        }
        out.close();
    }
    static  class Pair{
        public int x;
        public long y;
        public  Pair(int x,long y){
            this.x=x;
            this.y=y;
        }
    }
    static class Pair2{
        public long x;
        public long y;
        public long z;
        public Pair2(int x, long y,long z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static long getSqrt(long n) {
        long low = 1;
        long high = (long) 1E7;
        long ans = 1;
        while (low <= high) {
            long mid = (low + high) / 2;
            long sqr = mid * mid;
            if (sqr <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    static long gcd(long a, long b)
    {
        return b==0 ? a : gcd( b, a%b);
    }
    static  long lcm(long a, long b)
    {
        return (a*b)/gcd( a, b);
    }
    static long modpow(long a,long n){
        long res=1;
        while(n!=0){
            if ((n & 1) == 1){
                res*=a;
                res%=mod2;
                n-=1;
            }else{
                a*=a;
                a%=mod2;
                n>>=1;
            }

        }
        return res;
    }
    static void arraySortInt(int arr[]) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            a.add(arr[i]);
        }
        Collections.sort(a);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a.get(i);
        }
    }
    static void arraySortlong(long arr[]) {
        ArrayList<Long> a = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            a.add(arr[i]);
        }
        Collections.sort(a);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a.get(i);
        }
    }
    static class FastReader {
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) {
            in = is;
        }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan()) ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        int[] nextArrInt(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] nextArrLong(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
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

        public long nextLong() throws IOException {
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

        public double nextDouble() throws IOException {
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

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }

        public void printarray(int arr[]) {
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}