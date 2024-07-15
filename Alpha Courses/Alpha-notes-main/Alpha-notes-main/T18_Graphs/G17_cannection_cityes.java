package T18_Graphs;

import java.util.*;

public class G17_cannection_cityes {
    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.dest - e2.dest;
        }
    }

    static void prims(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge(0, 0));

        int finalCost = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (!vis[curr.dest]) {
                
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }

        }
        System.out.println("the final cost is : " + finalCost);
    }

    public static void main(String[] args) {
        int cities[][] = {
                { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 }
        };
        prims(cities);
    }
}
