import java.util.ArrayList;
import java.util.List;

public class code {
    public static List<String> solve(List<String> s, List<String> a) {
        List<String> r = new ArrayList<>();

        for (String song : s) {
            String[] songParts = song.split(":");
            String sn = songParts[0];
            int sl = Integer.parseInt(songParts[1]);

            for (String anim : a) {
                String[] animParts = anim.split(":");
                String an = animParts[0];
                int al = Integer.parseInt(animParts[1]);

                if (sl % al == 0) {
                    r.add(an + ":" + (sl / al));
                    break;
                }
            }
        }

        return r;
    }

    public static void main(String[] args) {
        List<String> s = List.of("notion:180", "voyage:185", "sample:180");
        List<String> a = List.of("circles:360", "square:180", "lines:37");

        List<String> result = solve(s, a);

        // Print the result
        for (String res : result) {
            System.out.println(res);
        }
    }
}
