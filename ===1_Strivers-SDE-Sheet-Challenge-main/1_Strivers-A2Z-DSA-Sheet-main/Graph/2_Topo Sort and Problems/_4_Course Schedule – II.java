/*
 *   210. Course Schedule II
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
    You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if
     you want to take course ai.
    
    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them.
     If it is impossible to finish all courses, return an empty array.
    
*    Example 1:
    
    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: [0,1]
    Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0.
     So the correct course order is [0,1].
*    Example 2:
    
    Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
    Output: [0,2,1,3]
    Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
     Both courses 1 and 2 should be taken after you finished course 0.
    So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
*    Example 3:
    
    Input: numCourses = 1, prerequisites = []
    Output: [0]
*/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Course_Schedule_II {
    /*
     * Time Complexity: O(N + E)
     * Space Complexity: O(N)
     */

    // BFS
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] nums : prerequisites){
            adj.get(nums[1]).add(nums[0]);
        }
        
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        int[] ans = new int[n];
        int k = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            ans[k++] = node;
            
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        if(k == n) return ans;  // to check if not we had a Cycle and could not do Topo Sort
        return new int[]{};
    }

    // M--2 Same way but  my code

    static int[] topSort(ArrayList<Edge>[] graph, int v) { // Corrected method signature
        int indeg[] = new int[v];

        // 1. Calculate Indegree 
        calcIndeg(graph, indeg);
        int count=0;
        ArrayList<Integer> ans=new ArrayList<>(); // Corrected ArrayList spelling

        // 2. Jinki Indegree==0 h unko Queue m daal do for a BFS start 
        Queue<Integer> q =  new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0){  // corrected comparison operator
                q.add(i);
                count++;
                ans.add(i);
            }
        }

        // NOrmal BFS 
        while(!q.isEmpty()){
            int curr = q.remove();
            // System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;       // corrected variable name
                if(indeg[e.dest] == 0){ // corrected comparison operator
                    q.add(e.dest); // corrected variable name
                    count++;
                    ans.add(e.dest);
                }
            }
        }

        if(count==v) {
            int[] result = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                result[i] = ans.get(i);
            }
            return result;
        }

        return new int[]{};
    }

    static void calcIndeg(ArrayList<Edge> graph[], int indeg[]){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        int numCourses = 2;
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
}
