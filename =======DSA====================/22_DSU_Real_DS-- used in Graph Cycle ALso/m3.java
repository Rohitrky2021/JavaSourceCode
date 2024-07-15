public class m3 {
    import java.util.Scanner;

    public class Main {
        static final int M = (int) (1e9 + 7);
    
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int t = scn.nextInt();
    
            while (t-- != 0) {
                int n = scn.nextInt();
                int[] nums1 = new int[n];
                int[] nums2 = new int[n];
    
                for (int i = 0; i < n; i++) {
                    nums1[i] = scn.nextInt();
                }
    
                for (int i = 0; i < n; i++) {
                    nums2[i] = scn.nextInt();
                }
    
                int ans = solve(nums1, nums2, n);
                System.out.println(ans);
            }
        }
    
        private static int solve(int[] nums1, int[] nums2, int n) {
            int ans = 1;
            int[] parent = new int[2 * n + 1];
            int[] rank = new int[2 * n + 1];
    
            for (int i = 1; i <= 2 * n; i++) {
                rank[i] = 0;
                parent[i] = i;
            }
    
            for (int i = 0; i < n; i++) {
                int x = nums1[i];
                int y = nums2[i];
                if (!union(parent, rank, x, y)) {
                    ans = (ans * 2) % M;
                }
            }
    
            return ans;
        }
    
        static int find(int[] parent, int x) {
            if (x == parent[x]) {
                return x;
            }
            int temp = find(parent, parent[x]);
            parent[x] = temp;
            return temp;
        }
    
        static boolean union(int[] parent, int[] rank, int x, int y) {
            int lx = find(parent, x);
            int ly = find(parent, y);
    
            if (lx == ly) {
                return true;
            }
    
            if (rank[lx] > rank[ly])
                parent[ly] = lx;
            else if (rank[ly] > rank[lx])
                parent[lx] = ly;
            else {
                parent[ly] = lx;
                rank[lx]++;
            }
            return false;
        }
    }
    