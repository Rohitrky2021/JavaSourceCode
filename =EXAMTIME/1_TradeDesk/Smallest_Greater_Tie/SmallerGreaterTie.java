import java.util.Vector;

public class SmallerGreaterTie {
    public static void main(String[] args) {
        // Hardcoded example values
        int n = 5;
        Vector<Integer> v = new Vector<>(n);
        v.add(3);
        v.add(7);
        v.add(1);
        v.add(5);
        v.add(2);

        int pt = 4;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (v.get(i) > pt) {
                cnt++;
            } else if (v.get(i) < pt) {
                cnt--;
            }
        }

        if (cnt < 0) {
            System.out.println("smaller");
        } else if (cnt > 0) {
            System.out.println("greater");
        } else {
            System.out.println("tie");
        }
    }
}
