
    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.Queue;


    public class m {
        public int solution(int N, int[] A, int[] B) {
            int M = A.length;
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }
            int[] indegree = new int[N];
    
            for (int i = 0; i < M; i++) {
                graph.get(A[i]).add(B[i]);
                graph.get(B[i]).add(A[i]);
                indegree[A[i]]++;
                indegree[B[i]]++;
            }
    
            Queue<Integer> q = new LinkedList<>();
            int[] vis = new int[N];
    
            for (int i = 0; i < N; i++) {
                if (indegree[i] < 2) {
                    q.add(i);
                    vis[i] = 1;
                }
            }
    
            int ans = 0;
    
            while (!q.isEmpty()) {
                ans++;
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    int node = q.poll();
    
                    for (int x : graph.get(node)) {
                        indegree[x]--;
                        if (indegree[x] < 2 && vis[x] == 0) {
                            q.add(x);
                            vis[x] = 1;
                        }
                    }
                }
            }
    
            return ans;
        }
    
        public static void main(String[] args) {
            int N = 7;
            int[] A = {0, 1, 2, 1, 4, 4};
            int[] B = {1, 2, 0, 4, 5, 6};
    
            m solution = new m();
            int result = solution.solution(N, A, B);
            System.out.println("Result: " + result);
        }

            
    }
    