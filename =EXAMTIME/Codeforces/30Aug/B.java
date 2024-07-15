import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Size of permutation
            int[] p = new int[n+1];
            int x=0;

            for (int j = 1; j <= n; j++) {
                x = scanner.nextInt(); // Permutation elements
                p[x]=j;
            }

            
            int len = n-1;

            for (int j = 2; j <=n; j++) {
               if(p[j]>p[j-1]){
                len-=1;
               }
            }

            
            System.out.println(len);
        }
    }
}
