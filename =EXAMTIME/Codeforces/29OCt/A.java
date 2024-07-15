import java.util.Scanner;
import java.util.Vector;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Length of the array
            Vector<Integer> a = new Vector<>();

            for (int i = 0; i < n; i++) {
                a.add(scanner.nextInt());
            }

            if (canSortArray(a)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
 
    

    public static boolean canSortArray(Vector<Integer> a) {
        int n = a.size();

        for (int i = 0; i + 1 < n; i++) {
            if(a.get(i)>a.get(i+1)){
         
                if ((i & (i + 1)) != 0) {
                    return false;
                }
           
        }
        }

        // System.out.println("YES");
        return true;
    }
}
