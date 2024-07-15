import java.util.*;

class ok {
    private final int V;
    private final List<Integer>[] adj;
    private int cycleCount;

    @SuppressWarnings("unchecked")
    public ok(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
        cycleCount = 0;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public int countDirectedCycles() {
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];

        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                if (isCyclicUtil(v, visited, recursionStack)) {
                    cycleCount++;
                }
            }
        }
        return cycleCount;
    }

    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recursionStack) {
        if (!visited[v]) {
            visited[v] = true;
            recursionStack[v] = true;

            for (int adjVertex : adj[v]) {
                if (!visited[adjVertex] && isCyclicUtil(adjVertex, visited, recursionStack)) {
                    return true;
                } else if (recursionStack[adjVertex]) {
                    return true;
                }
            }
        }
        recursionStack[v] = false;
        return false;
    }
}

public class directedCycle {
    public static void main(String[] args) {
        int a[] =  {1,2,3,4,6,5};
        int b[] =  {7,6,4,1,2,1};
        ok graph = new ok(2 * a.length);

        for (int i = 0; i < b.length; i++) {
            graph.addEdge(a[i], b[i]);
            graph.addEdge(b[i], a[i]);
        }

        int directedCyclesCount = graph.countDirectedCycles();
        System.out.println("Number of Directed Cycles: " + directedCyclesCount);
    }
}
