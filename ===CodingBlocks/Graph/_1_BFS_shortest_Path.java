 

import java.util.*;

class Graph<T> {

    private Map<T, List<T>> l;

    public Graph() {
        l = new HashMap<>();
    }

    /*
     *  // Below Addedge its function helps in creating undirect graph 
     *  //  i.e both side will will have the edge bothWay
     */

    public void addEdge(T x, T y) {
        l.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
        l.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
    }

    public void bfs(T src, T dest) {
        Queue<T> q = new LinkedList<>();
        q.offer(src);

        Map<T, Integer> dist = new HashMap<>();

        // All other nodes will have inf dist
        for (T key : l.keySet()) {
            dist.put(key, Integer.MAX_VALUE);
        }
        // Dist of src from src = 0
        dist.put(src, 0);

        while (!q.isEmpty()) {
            T curr = q.poll();

            // Push all neighbours of curr
            List<T> neighbours = l.get(curr);
            if (neighbours != null) {
                for (T nbr : neighbours) {
                    if (dist.get(nbr) == Integer.MAX_VALUE) { // nbr has not been visited yet
                        q.offer(nbr);
                        dist.put(nbr, dist.get(curr) + 1); // Update distance
                    }
                }
            }
        }

        System.out.println(" this is ans dest Dist "+ dist.get(dest));
        // Print dist to every node
        for (Map.Entry<T, Integer> entry : dist.entrySet()) {
            System.out.println("Node "+entry.getKey() + " Distnace from Source  " + entry.getValue());
        }
    }
}

public class _1_BFS_shortest_Path {

    public static void main(String[] args) {

        Graph<Integer> g = new Graph<>();

        g.addEdge(0, 1); // above its function helps in creating undirect graph 
        g.addEdge(0, 3); //  i.e both side will will have the edge bothWay
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        g.bfs(0, 2);
    }
}
