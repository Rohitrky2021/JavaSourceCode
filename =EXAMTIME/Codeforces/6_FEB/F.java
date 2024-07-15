import java.util.*;

class Edge {
    int u, v, wt;

    Edge(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}
    class Pair<K, V> {
        public K first;
        public V second;
    
        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

class Graph {
    int V;
    ArrayList<ArrayList<Pair<Integer, Integer>>> adjacency;
    ArrayList<Edge> edge;

    Graph(int V) {
        this.V = V;
        adjacency = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjacency.add(new ArrayList<>());
        }
        edge = new ArrayList<>();
    }

    void addEdge(int u, int v, int w) {
        adjacency.get(u).add(new Pair<>(v, w));
        adjacency.get(v).add(new Pair<>(u, w));
        Edge e = new Edge(u, v, w);
        edge.add(e);
    }

    void removeEdge(int u, int v, int w) {
        adjacency.get(u).remove(new Pair<>(v, w));
        adjacency.get(v).remove(new Pair<>(u, w));
    }

    int minimumPath(int u, int v) {
        HashSet<Pair<Integer, Integer>> setds = new HashSet<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        setds.add(new Pair<>(0, u));
        dist[u] = 0;

        while (!setds.isEmpty()) {
            Pair<Integer, Integer> tmp = setds.iterator().next();
            setds.remove(tmp);

            int uu = tmp.K;

            for (Pair<Integer, Integer> i : adacjency.get(uu)) {
                int vv = i.getKey();
                int wt = i.getValue();

                if (dist[vv] > dist[uu] + wt) {
                    if (dist[vv] != Integer.MAX_VALUE && setds.contains(new Pair<>(dist[vv], vv))) {
                        setds.remove(new Pair<>(dist[vv], vv));
                    }
                    dist[vv] = dist[uu] + wt;
                    setds.add(new Pair<>(dist[vv], vv));
                }
            }
        }
        return dist[v];
    }

    int findMinCycle() {
        int min_cycle = Integer.MAX_VALUE;
        int E = edge.size();

        for (int i = 0; i < E; i++) {
            Edge e = edge.get(i);
            removeEdge(e.u, e.v, e.wt);
            int distance = minimumPath(e.u, e.v);
            min_cycle = Math.min(min_cycle, distance + e.wt);
            addEdge(e.u, e.v, e.wt);
        }

        return min_cycle;
    }
}

public class F {
    public static void main(String[] args) {
        int V = 6;
        Graph g = new Graph(V);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 4, 6);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 4, 3);
        g.addEdge(3, 5, 7);
        g.addEdge(4, 5, 8);
        System.out.println("Minimum weight cycle in the graph is: " + g.findMinCycle());
    }
}
