import java.util.*;

// https://codeforces.com/problemset/problem/1889/B

public class S_H1_Doremy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ts = sc.nextInt();
        
        while (ts-- > 0) {
            int n = sc.nextInt();
            long c = sc.nextLong();
            long[] a = new long[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            
            Solution solution = new Solution();
            if (solution.canArrange(n, c, a)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        sc.close();
    }
}

class Solution {
    public boolean canArrange(int n, long c, long[] a) {
        Pair[] o = new Pair[n - 1];
        
        for (int i = 1; i < n; i++) {
            o[i - 1] = new Pair(a[i] - ((long) i + 1) * c, i + 1);
        }
        
        Arrays.sort(o, new Comp());
        long start = a[0];
        
        for (int i = 0; i < n - 1; i++) {
            start += a[o[i].index - 1];
            if (start < o[i].index * c) {
                return false;
            }
        }
        
        return true;
    }
}

class Pair {
    long value;
    int index;

    public Pair(long value, int index) {
        this.value = value;
        this.index = index;
    }

    public String toString() {
        return value + " " + index;
    }
}

class Comp implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return Long.compare(b.value, a.value);
    }
}
