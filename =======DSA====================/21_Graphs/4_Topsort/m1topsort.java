import java.util.*;

public class m1topsort {
    static class edge {
        int source;
        int dest;

        edge(int s, int d) {
            this.source = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new edge(2, 3));
        graph[3].add(new edge(3, 1));
        graph[4].add(new edge(4, 0));
        graph[4].add(new edge(4, 1));
        graph[5].add(new edge(5, 0));
        graph[5].add(new edge(5, 2));
    }

    public static void calcindeee(ArrayList<edge> graph[], int indegree[]) {
        // doing ++ in destination
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                edge e = graph[v].get(j);
                indegree[e.dest]++;
            }
        }
    }

    public static void topsort(ArrayList<edge> graph[]) {
        int indegree[] = new int[graph.length];
        calcindeee(graph, indegree);
        Queue<Integer> q = new LinkedList<>();


        // logic yhi h ki JIska Indegree 0 Hota jaayega usko Queue m Add krte Jaayenge 
        // ---> ya after use one in Queue decrease degree of surround destination element degreee 
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        System.out.println("In-degree of vertices:");

        for (int i = 0; i < indegree.length; i++) {
            System.out.println("Vertex " + i + ": " + indegree[i]);
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topsort(graph);
    }
}


    // https://leetcode.com/problems/course-schedule/

    // class Solution {-------------------------->QUESTION USING TOPOSORT ---<>>>COURSEES
        // public boolean canFinish(int numCourses, int[][] prerequisites) {
        //     if (numCourses == 0) {
        //         return true;
        //     }
    
        //     int[] course = new int[numCourses];
        //     for (int i = 0; i < prerequisites.length; i++) {
        //         course[prerequisites[i][1]]++;
        //     }
    
        //     boolean[] visited = new boolean[prerequisites.length];
        //     boolean flag = true;
        //     while (flag) {
        //         flag = false;
        //         for (int i = 0; i < prerequisites.length; i++) {
        //             if (!visited[i]) {
        //                 if (course[prerequisites[i][0]] == 0) {
        //                     visited[i] = true;
        //                     course[prerequisites[i][1]]--;
        //                     flag = true;
        //                 }
        //             }
        //         }
        //     }
    
        //     for (int i = 0; i < numCourses; i++) {
        //         if (course[i] != 0) {
        //             return false;
        //         }
        //     }
    
        //     return true;
        // }
    
    










