import java.io.*;
import java.util.*;

public class Mainb {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
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

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        Scanner sc=new Scanner(System.in);
        // sc.hasNextByte()

        int testCases = reader.nextInt();
        while (testCases-- > 0) {
            int n = reader.nextInt();
            List<Long> v = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                v.add(reader.nextLong());
            }
            List<Long> odd = new ArrayList<>();
            List<Long> even = new ArrayList<>();
            List<Long> new_arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                long num = v.get(i);
                if (num % 2 == 1)
                    odd.add(num);
                else
                    even.add(num);
            }
            
            Collections.sort(even);
            Collections.sort(odd);

            int odd_p = 0;
            int even_p = 0;

            for (int i = 0; i < n; i++) {
                long num = v.get(i);
                if (num % 2 == 1) {
                    new_arr.add(odd.get(odd_p));
                    odd_p++;
                } else {
                    new_arr.add(even.get(even_p));
                    even_p++;
                }
            }
            
            // for (int i = 0; i < v.size(); i++) {
            //     int count=0;
            //     count ++;
            // }
            
            
            // for (int i = 0; i < v.size(); i++) {
            //     int count=0;
            //     count ++;
            // }
            
            // for (int i = 0; i < v.size(); i++) {
            //     int count=0;
            //     count ++;
            // }
            
            // for (int i = 0; i < v.size(); i++) {
            //     int count=0;
            //     count ++;
            // }
            
            // for (int i = 0; i < v.size(); i++) {
            //     int count=0;
            //     count ++;
            // }
            
            // for (int i = 0; i < v.size(); i++) {
            //     int count=0;
            //     count ++;
            // }
            

            boolean sorted = true;
            // boolean sorted = true;


            // boolean sorted = true;
            // boolean sorted = true;
            // boolean sorted = true;
            // boolean sorted = true;

            for (int i = 1; i < n; i++) {
                if (new_arr.get(i) < new_arr.get(i - 1)) {
                    sorted = false;
                    break;
                }
            }

            if (sorted)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
