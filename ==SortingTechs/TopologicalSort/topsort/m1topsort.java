import java.util.*;
public class m1topsort {
    static class edge{
        int sorce;
        int dest;
        // int weight;

        edge(int s,int d){
            this.sorce=s;
            this.dest=d;
            // this.weight=w;
        } 

    }

    static void createGraph(ArrayList<edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[2].add(new edge(2, 3));
        graph[3].add(new edge(3, 1));
        graph[4].add(new edge(4, 0));
        graph[4].add(new edge(4, 1));
        graph[5].add(new edge(5, 0));
        graph[5].add(new edge(5, 2));

    }

    public static void calcindeee(ArrayList<edge> graph[], int indegre[]){
        //doing ++ in destination
        for (int i = 0; i < graph.length; i++) {
            int v=i;
            for (int j = 0; j < graph.length; j++) {
                edge e=graph[i].get(j);
                indegre[e.dest]++;
            }
        }
    }

    public static void topsort(ArrayList<edge> graph[]){
        int indegre[]=new int[graph.length];
        calcindeee(graph, indegre);
        Queue<Integer> q=new LinkedList<>();

        for (int i = 0; i < indegre.length; i++) {
            if(indegre[i]==0){
                q.add(indegre[i]);
            }
        }

        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr +" ");

            for (int i = 0; i <graph[curr].size(); i++) {
                edge e=graph[curr].get(i);
                indegre[e.dest]--;
                if(indegre[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }

        System.out.println();

    }
    public static void main(String args[]){
        int V=6;
        ArrayList<edge> graph[]=new ArrayList[V];
        createGraph(graph);
        topsort(graph);
    }

    // class Solution {-------------------------->QUESTION USING TOPOSORT ---<>>>COURSEES
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (numCourses == 0) {
                return true;
            }
    
            int[] course = new int[numCourses];
            for (int i = 0; i < prerequisites.length; i++) {
                course[prerequisites[i][1]]++;
            }
    
            boolean[] visited = new boolean[prerequisites.length];
            boolean flag = true;
            while (flag) {
                flag = false;
                for (int i = 0; i < prerequisites.length; i++) {
                    if (!visited[i]) {
                        if (course[prerequisites[i][0]] == 0) {
                            visited[i] = true;
                            course[prerequisites[i][1]]--;
                            flag = true;
                        }
                    }
                }
            }
    
            for (int i = 0; i < numCourses; i++) {
                if (course[i] != 0) {
                    return false;
                }
            }
    
            return true;
        }
    }
    










