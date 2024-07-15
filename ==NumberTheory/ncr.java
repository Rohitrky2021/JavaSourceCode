
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ncr {
    static int MOD = 1000000007;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        long[][] ncr = calculateBinomialCoefficients(5005, 5005);
        
        while (t-- > 0) {
            String[] st = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            int r = Integer.parseInt(st[1]);
            
            if (n >= r) { // Check for valid n and r values
                sb.append(ncr[n][r] + "\n"); 
            } else {
                sb.append("0\n"); // nCr is not defined when n < r
            }
        }

        System.out.println(sb);
    }

    // Iterative DP Approach to calculate binomial coefficients
    static long[][] calculateBinomialCoefficients(int n, int k) {
        long[][] arr = new long[n + 1][k + 1];
        
        for (int i = 0; i <= n; i++) {
            arr[i][0] = 1;
            for (int j = 1; j <= k && j <= i; j++) {
                arr[i][j] = (arr[i - 1][j] + arr[i - 1][j - 1]) % MOD;
            }
        }
        
        return arr;
    }
}
