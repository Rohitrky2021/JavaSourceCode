
    import java.util.Scanner;

    public class joining_cordinates {
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            // Read the number of existing snow drifts
            int n = scanner.nextInt();
    
            // Arrays to store the coordinates of existing snow drifts
            int[] x = new int[n];
            int[] y = new int[n];
    
            // Read the coordinates of each snow drift
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
            }
    
            // Find the minimum number of new snow drifts needed
            int minSnowDrifts = findMinSnowDrifts(x, y, n);
    
            // Output the result
            System.out.println(minSnowDrifts);
    
            scanner.close();
        }
    
        // Function to find the minimum number of new snow drifts needed
        private static int findMinSnowDrifts(int[] x, int[] y, int n) {
            // We can connect any two existing snow drifts, so the minimum number of new snow drifts
            // needed is the maximum number of disconnected components in the graph
            // formed by the existing snow drifts.
    
            // Initialize parent array for Union-Find
            int[] parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
    
            // Perform Union-Find to find the number of connected components
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (x[i] == x[j] || y[i] == y[j]) {
                        union(parent, i, j);
                    }
                }
            }
    
            // Count the number of unique parents (representing connected components)
            int connectedComponents = 0;
            for (int i = 0; i < n; i++) {
                if (parent[i] == i) {
                    connectedComponents++;
                }
            }
    
            // The minimum number of new snow drifts is the number of connected components minus 1
            return connectedComponents - 1;
        }
    
        // Helper function for Union-Find
        private static int find(int[] parent, int i) {
            if (parent[i] != i) {
                parent[i] = find(parent, parent[i]);
            }
            return parent[i];
        }
    
        // Helper function for Union-Find
        private static void union(int[] parent, int i, int j) {
            int rootI = find(parent, i);
            int rootJ = find(parent, j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
    }
    
// M2 or just do dfs and visit all the ones that i can reqach 

 

public class Main {
    static int mod = (int) 1e9 + 7;
    static boolean[] vis;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Point[] p=new Point[n];
        for(int i=0;i<n;i++)p[i]=new Point(sc.nextInt(),sc.nextInt());
        vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,n,p);
                count++;
            }
        }
        System.out.println(count-1);
    }
    
    static void dfs(int i,int n,Point[] p){
        vis[i]=true;
        for(int j=0;j<n;j++){
            if(!vis[j]){
                if(p[i].x==p[j].x || p[i].y==p[j].y){
                    dfs(j,n,p);
                }
            }
        }
    }
}