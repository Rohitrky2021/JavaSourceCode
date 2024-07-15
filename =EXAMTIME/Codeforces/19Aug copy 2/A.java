import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            solve(s);
        }
        s.close();
    }
    
    public static void solve(Scanner s) {
        int n = s.nextInt();
        List<Long> lst = new ArrayList<>();
        int i = 0;
        while (i < n - 1) {
            lst.add(s.nextLong());
            i++;
        }
        

        Collections.sort(lst);
        long x = s.nextLong();
        x += lst.get(lst.size() - 1);
        System.out.println(x);
    }
}
