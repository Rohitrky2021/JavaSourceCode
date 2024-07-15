import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1 {

    public static List<String> solve(List<List<String>> p, List<String> a, int w) {
        List<String> r = new ArrayList<>();
        r.add("*".repeat(w + 2));
        for (int i = 0; i < p.size(); i++) {
            String l = "";
            for (String wd : p.get(i)) {
                if (l.length() + wd.length() + (l.isEmpty() ? 0 : 1) > w) {
                    if (a.get(i).equals("LEFT")) {
                        l += " ".repeat(w - l.length());
                    } else if (a.get(i).equals("RIGHT")) {
                        l = " ".repeat(w - l.length()) + l;
                    }
                    r.add("*" + l + "*");
                    l = "";
                }
                if (!l.isEmpty()) {
                    l += " ";
                }
                l += wd;
            }
            if (!l.isEmpty()) {
                if (a.get(i).equals("LEFT")) {
                    l += " ".repeat(w - l.length());
                } else if (a.get(i).equals("RIGHT")) {
                    l = " ".repeat(w - l.length()) + l;
                }
                r.add("*" + l + "*");
            }
        }
        r.add("*".repeat(w + 2));
        return r;
    }

    public static void main(String[] args) {
        // Example usage
        List<List<String>> p = new ArrayList<>();
        p.add(Arrays.asList("hello", "world"));
              p.add(Arrays.asList("How","areYou","doing"));
                            p.add(Arrays.asList( "please look","and align","to right"));


      
        // p.add(Arrays.asList("Another", "line", "of", "text"));
        
        List<String> a = Arrays.asList("LEFT", "RIGHT","RIGHT");
        int w = 16;

        List<String> result = solve(p, a, w);

        // Print the result
        for (String line : result) {
            System.out.println(line);
        }
    }
}
