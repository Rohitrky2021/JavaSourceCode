import java.util.*;

public class K {
    static class DSU {
        int[] parent, size;
        int n;

        public DSU(int n) {
            this.n = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int a) {
            if (parent[a] == a) {
                return a;
            }
            return parent[a] = find(parent[a]); // Path compression
        }

        public void unite(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                if (size[rootA] < size[rootB]) {
                    int temp = rootA;
                    rootA = rootB;
                    rootB = temp;
                }
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }

        public boolean same(int a, int b) {
            return find(a) == find(b);
        }

        public int getSize(int a) {
            return size[find(a)];
        }
    }

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = line.charAt(j);
            }
        }

        DSU dsu = new DSU(n * m);
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // Unite adjacent '#' cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '#') {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m && a[ni][nj] == '#') {
                            dsu.unite(i * m + j, ni * m + nj);
                        }
                    }
                }
            }
        }

        int ans = 0;
        // Find the largest connected component of '#'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '#') {
                    ans = Math.max(ans, dsu.getSize(i * m + j));
                }
            }
        }

        // Consider flipping '.' to '#'
        for (int i = 0; i < n; i++) {
            int thisRow = 0;
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '.') {
                    thisRow++;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m && a[ni][nj] == '#') {
                            int root = dsu.find(ni * m + nj);
                            if (!s.contains(root)) {
                                thisRow += dsu.getSize(ni * m + nj);
                                s.add(root);
                            }
                        }
                    }
                }
            }
            ans = Math.max(ans, thisRow);
        }

        for (int i = 0; i < m; i++) {
            int thisCol = 0;
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (a[j][i] == '.') {
                    thisCol++;
                    for (int k = 0; k < 4; k++) {
                        int ni = j + dx[k];
                        int nj = i + dy[k];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m && a[ni][nj] == '#') {
                            int root = dsu.find(ni * m + nj);
                            if (!s.contains(root)) {
                                thisCol += dsu.getSize(ni * m + nj);
                                s.add(root);
                            }
                        }
                    }
                }
            }
            ans = Math.max(ans, thisCol);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        sc.close();
    }
}
