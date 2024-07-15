import java.util.ArrayList;
import java.util.List;

public class ReverselevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
           ArrayList<List<Integer>> ans = new ArrayList<>();
           if (root == null) {
               return ans;
           }
          

           q.offer(root);
          
           while (!q.isEmpty()) {

               int levelSize=q.size();

               List<Integer> currentlevel=new ArrayList<>();

               for (int i = 0; i < levelSize; i++) {
                   TreeNode curr=q.poll();
                   currentlevel.add(curr.val);
                   

                   if(curr.left!=null){
                       q.offer(curr.left); // Adding the left part of Node 
                   }
                   if(curr.right!=null){  // Adding the Right part of Node 
                       q.offer(curr.right);
                   }

               }
               
               //    Collections.reverse(currentlevel);
               ans.add(currentlevel);
            }
            for (int i = 0; i < ans.size(); i++) {
                ans.add(ans.get(ans.size()-1));
                ans.remove(ans.size()-1-i);
             
            }
           return ans;
   }
}
