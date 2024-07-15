import java.util.PriorityQueue;

import javax.management.Descriptor;

public class ConnectingCities {
    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }

    }

    // prism Algorith
    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[cities.length];

        pq.add(new Edge(0, 0));
        int finalcost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (!visited[curr.dest]) {
                visited[curr.dest] = true;
                finalcost += curr.cost;
                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalcost;
    }

    public static void main(String args[]) {
        int cities[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };

        int ans = connectCities(cities);
        System.out.println(ans);
    }
}
