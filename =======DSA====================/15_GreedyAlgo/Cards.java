
    // https://codeforces.com/contest/1172/problem/A
    import java.util.Scanner;

    public class Cards {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = 200010;
            int n = scanner.nextInt();
            int[] a = new int[N];
            int[] b = new int[N];
            int[] p = new int[N];
            int ans = 0;
    
            for (int i = 1; i <= n; ++i) {
                a[i] = scanner.nextInt();
                p[a[i]] = 0;
            }
    
            for (int i = 1; i <= n; ++i) {
                b[i] = scanner.nextInt();
                p[b[i]] = i;
            }
    
            if (p[1] != 0) {
                int i;
                for (i = 2; p[i] == p[1] + i - 1; ++i);
                if (p[i - 1] == n) {
                    int j;
                    for (j = i; j <= n && p[j] <= j - i; ++j);
                    if (j > n) {
                        System.out.print(n - i + 1);
                        return;
                    }
                }
            }
    
            for (int i = 1; i <= n; ++i)
                ans = Math.max(ans, p[i] - i + 1 + n);
    
            System.out.print(ans);
        }
    }
    