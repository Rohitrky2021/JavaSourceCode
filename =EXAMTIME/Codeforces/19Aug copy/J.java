import java.io.*;
import java.util.*;

public class J {
    
    static IOHandler sc = new IOHandler();
    static PrintWriter out = new PrintWriter(System.out);
    static int [][] dirs = new int [][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public static void main(String[] args) throws IOException {
        new Thread(null, new Solution(), "solution", 1 << 26 ).start();
    }
    
    private static class Solution implements Runnable {
        public void run() {
            int testCases = sc.nextInt();
            for (int i = 1; i <= testCases; ++i) {
                solve(i);
            }
            out.flush();
        }
        
        private void solve(int t) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char [][] arr = new char [n][];
            for (int i = 0; i < n; ++i) {
                arr[i] = sc.next().toCharArray();
            }
            
            UnionFind uf = new UnionFind(n * m);
            int[][] pos = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            int island = 0;
            List<Integer> lSize = new ArrayList<>();
            lSize.add(0);

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (arr[i][j] == '.' || visited[i][j])
                        continue;
                    lSize.add(dfs(arr, i, j, visited, pos, ++island, uf));
                }
            }

            Set<Integer> set;
            int added;
            long result = 0;
            long val;

            for (int i = 0; i < n; ++i) {
                set = new HashSet<>();
                added = 0;
                if (i > 0) {
                    for (int j = 0; j < m; ++j) {
                        set.add(pos[i - 1][j]);
                    }
                }
                if (i < n - 1) {
                    for (int j = 0; j < m; ++j) {
                        set.add(pos[i + 1][j]);
                    }
                }
                for (int j = 0; j < m; ++j) {
                    if (arr[i][j] == '.')
                        ++added;
                    else
                        set.add(pos[i][j]);
                }
                val = added;
                for (int num : set) {
                    val += lSize.get(num);
                }
                result = Math.max(result, val);
            }

            for (int j = 0; j < m; ++j) {
                set = new HashSet<>();
                added = 0;
                if (j > 0) {
                    for (int i = 0; i < n; ++i) {
                        set.add(pos[i][j - 1]);
                    }
                }
                if (j < m - 1) {
                    for (int i = 0; i < n; ++i) {
                        set.add(pos[i][j + 1]);
                    }
                }
                for (int i = 0; i < n; ++i) {
                    if (arr[i][j] == '.')
                        ++added;
                    else
                        set.add(pos[i][j]);
                }
                val = added;
                for (int num : set) {
                    val += lSize.get(num);
                }
                result = Math.max(result, val);
            }
            
            out.println(result);
        }
        
        private int dfs(char [][] arr, int r, int c, boolean [][] visited,
            int [][] pos, int island, UnionFind uf) {
            
            if (visited[r][c])
                return 0;
            
            Queue<int []> queue = new LinkedList<>();
            queue.add(new int [] {r, c});
            visited[r][c] = true;
            pos[r][c] = island;
            uf.union(r * arr[0].length + c, island);
            
            int [] cur;
            int x, y;
            int result = 0;
            
            while (!queue.isEmpty()) {
                cur = queue.remove();
                r = cur[0];
                c = cur[1];
                ++result;
                
                for (int [] dir : dirs) {
                    x = r + dir[0];
                    y = c + dir[1];
                    
                    if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length)
                        continue;
                    else if (visited[x][y] || arr[x][y] == '.')
                        continue;
                    
                    queue.add(new int [] {x, y});
                    visited[x][y] = true;
                    pos[x][y] = island;
                    uf.union(x * arr[0].length + y, island);
                }
            }
            return result;
        }
    }
    
    private static class IOHandler {
        BufferedReader br;
        StringTokenizer st;
    
        public IOHandler() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        int [] readArray(int n) {
            int [] res = new int [n];
            for (int i = 0; i < n; ++i)
                res[i] = nextInt();
            return res;
        }
        
        int [] readArray2(int n) {
            int [] res = new int [n + 1];
            for (int i = 1; i <= n; ++i)
                res[i] = nextInt();
            return res;
        }
        
        int [][] readGraph(int n, int m, int c) {
            int [][] graph = new int [n + 1][];
            int [] count = new int [n + 1];
            int [][] arr = new int [m][1 + c];
            int a, b;
            for (int i = 0; i < m; ++i) {
                a = sc.nextInt();
                b = sc.nextInt();
                arr[i][0] = a;
                arr[i][1] = b;
                ++count[a];
                ++count[b];
                for (int j = 2; j <= c; ++j) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i <= n; ++i) {
                graph[i] = new int [count[i] * c];
                count[i] = 0;
            }
            int swap;
            for (int [] tArr : arr) {
                for (int j = 1; j < tArr.length; ++j) {
                    graph[tArr[0]][count[tArr[0]]++] = tArr[j]; 
                }
                swap = tArr[0];
                tArr[0] = tArr[1];
                tArr[1] = swap;
                for (int j = 1; j < tArr.length; ++j) {
                    graph[tArr[0]][count[tArr[0]]++] = tArr[j]; 
                }
            }
            return graph;
        }
    
        long nextLong() {
            return Long.parseLong(next());
        }
    
        double nextDouble() {
            return Double.parseDouble(next());
        }
    
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

class UnionFind {
    public int[] parent;
    public int[] size;
    
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (size[rootA] >= size[rootB]) {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            } else {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
            return true;
        }
        return false;
    }
    
    public int getSize(int x) {
        return size[find(x)];
    }
}
