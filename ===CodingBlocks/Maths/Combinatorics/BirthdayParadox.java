
import java.util.*;
import java.io.*;

// bithday paradox Probability of min no. people present in an hall so there 50% chance 2 peopole  having borthday on same day 

public class BirthdayParadox   {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){

                Double  x=1.0;
                int people=0; // X deno 2 people have same birthday 

                Double p=in.nextDouble();// Probability Threshold he want to see --> Pecent so Whnen it 1 100% prob. we return 366 people
                float num=365,denom=365;

                // Corner Casse 
                if(p==1){
                    System.out.println("366");
                    return;
                }

                while(x>1-p){//x=1-p->minus of having Same   // i.e X==> All people hanving Different Birthday 
                    x=x*(num)/denom;
                    num--;
                    people++;
                    System.out.println(people+" "+x);
                }
                // write code here 
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
