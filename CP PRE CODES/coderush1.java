import java.util.*;
import java.io.*;
public class coderush1{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int l = Integer.parseInt(line[1]);
            long s = Long.parseLong(line[2]);
            long sum = (n * (n + 1)) / 2;
            if (l == n) {
                System.out.println(sum == s ? "YES" : "NO");
                continue;
            }
            long min = n - l + 1;
            long max = min + l - 1;
            if (s < min || s > max) {
                System.out.println("NO");
                continue;
            }
            long diff = s - min;
            if (diff == 0 || diff == l - 1) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
        }
    }
}





