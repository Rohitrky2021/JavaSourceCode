import java.util.ArrayList;
import java.util.List;

public class j {
    public static void main(String[] args) {
        int n = 5; // Example usage

        List<String> result = solve(n);

        for (String row : result) {
            System.out.println(row);
        }
    }

    static List<String> solve(int n) {
        List<String> f = new ArrayList<>();

        if (n <= 0) {
            return f;
        }

        f.add(new String(new char[n]).replace('\0', '*'));

        for (int i = 1; i <= n - 2; ++i) {
            String l = "*" + new String(new char[n - 2]).replace('\0', ' ') + "*";
            f.add(l);
        }

        f.add(new String(new char[n]).replace('\0', '*'));
        return f;
    }
}
