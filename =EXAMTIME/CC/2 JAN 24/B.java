import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) {
            int n = sc.nextInt();
            
            if(n % 2 == 0) {
                System.out.println(n / 2 + " " + n);
            } else {
                System.out.println((n / 2) + 1 + " " + n);
            }
        }
        
        sc.close();
    }
}
