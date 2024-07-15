public class TreeToGraphConverter {
    
}


// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/?envType=daily-question&envId=2024-01-10


class Solution {
    /*
       unique approach of building a graph from binary tree
       */
   
       public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
           Map<TreeNode,List<TreeNode>> graph = new HashMap<>();
           buildGraphMap(graph,root,null);
           return getDistance(target,graph,k);
           
       }
       
       public void buildGraphMap(Map<TreeNode,List<TreeNode>> graph, TreeNode node, TreeNode parent){
           if(node == null)
               return;
           
           if(!graph.containsKey(node)){
               graph.put(node,new ArrayList<>());
               //building an undirected graph(so that it can have a bachkward traversal edge) 
               //from binary tree
               if(parent != null){
                   graph.get(node).add(parent);
                   //backward edge
                   graph.get(parent).add(node);
               }
               
               buildGraphMap(graph,node.left,node);
               buildGraphMap(graph,node.right,node);
           }
       }
       
       
       public List<Integer> getDistance(TreeNode source, Map<TreeNode,List<TreeNode>> graph, int k){
       
           //simple bfs traversal to find nodes at distance k in undirected graph
           List<Integer> res = new ArrayList<>();
           Queue<TreeNode> q = new LinkedList<>();
           Set<TreeNode> visited = new HashSet<>();
           q.add(source);
           //as the graph is undirected we need to keep track of the visited array so that it won't visit
           //already visited node and do not end up in infinite loop
           visited.add(source);
   
           while(!q.isEmpty()){
               int size=q.size();
               //nodes at distance k
               if(k==0){
                  for(int i=0;i<size;i++){
                      res.add(q.poll().val);
                  }
                   return res;
               }
               for(int i=0;i<size;i++){
                   TreeNode cur = q.poll();
                   for(TreeNode v : graph.get(cur)){
                       if(!visited.contains(v)){
                           q.add(v);
                           visited.add(v);
                       }
                   }
               }
               k--;
           }
           return res;
       }
   }
   
//    ==============================================================================================>>>>>>>>>>>>>>>>>
   
   //M2 OF TEsted working method 
       public void convert(TreeNode current, int parent, Map<Integer, Set<Integer>> map){
        if (current == null) {
            return;
        } 
        if (!map.containsKey(current.val)) {
            map.put(current.val, new HashSet<>());
        } 
        Set<Integer> adjacentList = map.get(current.val);
        if (parent != 0) {
            adjacentList.add(parent);
        } 
        if (current.left != null) {
            adjacentList.add(current.left.val);
        } 
        if (current.right != null) {
            adjacentList.add(current.right.val);
        } 
        convert(current.left, current.val, map);
        convert(current.right, current.val, map);
    }    

    