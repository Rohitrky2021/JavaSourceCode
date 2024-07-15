import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B{
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();

        while (t-- > 0) {
            solve(scanner);
        }
    }

    static void solve(FastScanner scanner) throws IOException {
        int n = scanner.nextInt();
        
        ArrayList<Integer> v = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 1;
        
        for (int i = 0; i < n; i++) {
            v.add(scanner.nextInt());
        }
        
        ans.add(v.get(0));
        
        for (int i = 1; i < n; i++) {
            if (v.get(i) >= v.get(i - 1)) {
                ans.add(v.get(i));
                count++;
            } else {
                ans.add(v.get(i));
                ans.add(v.get(i));
                count += 2;
            }
        }
        
        System.out.println(count);
        
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        
        System.out.println();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
