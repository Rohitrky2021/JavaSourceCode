import java.util.HashMap;
import java.util.Scanner;

public class cp1 {

    // Your DSU code here
    static class DisjointSetUnion {
        static int n;
        static int[] rank ;
        static int[] par ;

        static void init(int x) {
            n=x;
            rank = new int[ n];
            par = new int[ n];
            
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
        }

        static int find(int x) {
            if (x == par[x]) {
                return x;
            }
            return find(par[x]);
        }

        static void union(int a, int b) {
            int parA = find(a);
            int parB = find(b);

            if (rank[parA] == rank[parB]) {
                par[parB] = parA;
                rank[parA]++;
            } else if (rank[parA] < rank[parB]) {
                par[parA] = parB;
            } else {
                par[parB] = parA;
            }
        }
    }

    static int mod = (int) 1e9 + 7;

    public static void solve(int[] arr1, int[] arr2) {
        int n = arr1.length;

        // Initialize DSU
        DisjointSetUnion.init(n);

        // HashMaps to store indices
        HashMap<Integer, Integer> idx1 = new HashMap<>();
        HashMap<Integer, Integer> idx2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            idx1.put(arr1[i], i);
            idx2.put(arr2[i], i);
        }

        // Union operations based on puzzle conditions
        for (int i = 0; i < n; i++) {
            // int r1 = idx1.get(arr1[i]);
            // int r2 = idx2.get(arr1[i]);
            int px1 = DisjointSetUnion.find(i);
            int px2 = DisjointSetUnion.find(i);

            if (px1 != px2) {
                DisjointSetUnion.union(px1, px2);
            }

            int y1 = idx1.get(arr2[i]);
            int y2 = idx2.get(arr2[i]);
            int py1 = DisjointSetUnion.find(y1);
            int py2 = DisjointSetUnion.find(y2);

            if (py1 != py2) {
                DisjointSetUnion.union(py1, py2);
            }
        }

        // Calculate the answer
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (DisjointSetUnion.find(i) == i) {
                ans = (ans * 2) % mod;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long t = scn.nextLong();
        while (t-- > 0) {
            int n = scn.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = scn.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arr2[i] = scn.nextInt();
            }
            solve(arr1, arr2);
        }
    }
}
