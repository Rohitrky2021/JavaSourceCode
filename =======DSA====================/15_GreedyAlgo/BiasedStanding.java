import java.util.Scanner;
public class BiasedStanding {
    // https://www.spoj.com/problems/BAISED/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[10000];
            
            for (int i = 0; i < n; i++) {
                String name = scanner.next();
                int rank = scanner.nextInt();
                a[rank]++;
            }
            
            int actualRank = 1;
            int sum = 0;
            
            for (int i = 1; i <= n; i++) {
                while (a[i] > 0) {
                    sum += Math.abs(actualRank - i);
                    a[i]--;
                    actualRank++;
                }
            }
            
            System.out.println(sum);
        }
        
        scanner.close();
    }
    
}

