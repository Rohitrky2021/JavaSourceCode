import java.util.Arrays;

public class G18_DisjointSet_union {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        
        return par[x] = find(par[x]);
    }

    static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }
    }

    public static void main(String[] args) {
        init();
        union(1, 3);
        System.out.println(find(3));
        // union(2, 4);
        // union(3, 6);
        // union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);

        System.out.println(Arrays.toString(rank));
        System.out.println(Arrays.toString(par));
    }
}
