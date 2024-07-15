import java.util.Arrays;
import java.util.TreeMap;

// OPerations in O(1)  and O(1)
// https://cp-algorithms.com/data_structures/disjoint_set_union.html
public class G18_DisjointSet_union {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    static int find(int x) {  //  O(N)
        if (x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]);  // path Compression step i.e we storing in par[x] and calling recurr also 
    }

    static void union(int a, int b) { //  O(N)
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

    public long maximumImportance(int n, int[][] roads) {
        int indegree[] = new int[graph.length];

        for(int x[] :roads){
            indegree[x[0]]++;
            indegree[x[1]]++;
        }
      
        int check[][]=new int[n][2];

        for (int i = 0; i < n; i++) {
             check[i][0] =i+1;
             check[i][1] =indegree[i];
        }

        Arrays.sort(check,(a,b)->b[1]-a[1]);

        long ans=0;
        for (int i = 0; i < n; i++) {
            ans+=check[i][1]*(n-i);
        }

        return ans;


        
    }

    public static void main(String[] args) {
        init();
        union(1, 3);
     

        System.out.println(Arrays.toString(rank));
        System.out.println(Arrays.toString(par));
    }
}
