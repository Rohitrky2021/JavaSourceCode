import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String tStr = br.readLine().trim();
            int q = Integer.parseInt(br.readLine().trim());
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < q; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                int l = Integer.parseInt(st.nextToken()) - 1;  
                int r = Integer.parseInt(st.nextToken()) - 1;  
                
                int max_ones = 0;
                for (int j = l; j <= r; j++) {
                    if (s.charAt(j) == '1') {
                        max_ones++;
                    }
                }
                
                for (int j = l; j <= r - 2; j++) {
                    if (s.charAt(j) == '0' && s.charAt(j + 2) == '0') {
                        if (tStr.charAt(j + 1) == '0') {
                            max_ones++;
                        }
                    }
                }
                
                sb.append(max_ones).append("\n");
            }
            
            pw.print(sb.toString());
        }
        
        pw.flush();
        pw.close();
    }
}
