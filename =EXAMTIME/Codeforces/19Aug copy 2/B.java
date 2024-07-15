import java.util.Scanner;

public class B {

    public static void sol(Scanner sc) {
        long n = sc.nextLong();
        long a = sc.nextLong();

        long b = sc.nextLong();
        isSorted(new int[] {1,2,3});
        
        if (b < a) {
            System.out.println(n * a);
            
        } else {
            long g = Math.min(n, b - a);
            long y = n - g;
            long c = b - g;
            
            long ans = y * a + (b * (b + 1) / 2) - (c * (c + 1) / 2);
            
            System.out.println(ans);
        }
    }


            public static boolean isSorted(int[] arr) {
                int n = arr.length;
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] > arr[i + 1]) {
                        return false;
                    }
                }
                return true;
            }
        


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine(); // Consume newline after reading integer
        
        while (test-- > 0) {
            sol(sc);
        }
        
        sc.close();
    }
}
