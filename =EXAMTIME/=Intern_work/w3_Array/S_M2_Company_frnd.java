// https://codeforces.com/problemset/problem/580/B
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class S_M2_Company_frnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d = sc.nextLong();
        long[][] v = new long[n][2];
        
        for (int i = 0; i < n; i++) {
            v[i][0] = sc.nextLong();
            v[i][1] = sc.nextLong();
        }
        
        Solution solution = new Solution();
        long result = solution.calculateMaxSum(n, d, v);
        System.out.println(result);
        
        sc.close();
    }
}

class Solution {
    public long calculateMaxSum(int n, long d, long[][] v) {
        Arrays.sort(v, Comparator.comparingLong(ar -> ar[0]));
        int j = 0;
        long sum = 0, mx = 0;
        
        for (int i = 0; i < n; i++) {
            while (v[i][0] - v[j][0] >= d) {
                sum -= v[j][1];
                j++;
            }
            sum += v[i][1];
            mx = Math.max(mx, sum);
        }
        
        return mx;
    }
}
