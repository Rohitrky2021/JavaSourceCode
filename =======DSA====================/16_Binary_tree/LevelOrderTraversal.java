import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class LevelOrderTraversal {
    // https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/

    public List<List<Integer>> levelOrder1(TreeNode root) {
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
                   currentlevel.add(curr.val); // we are on parent level and adding it in ans currently 
                   

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
           return ans;
   }


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>



    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        q.add(root);
        q.add(null);
        
        while (!q.isEmpty()) {
            Node currnode = q.remove();
            if (currnode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);

                }

            } else {
                System.out.print(currnode.data + " ");
                if (currnode.left != null) {
                    q.add(currnode.left);
                    System.out.print("L  ");
                }
                if (currnode.right != null) {
                    q.add(currnode.right);
                    System.out.print("R  ");
                }
            }

        }


        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> levels = new ArrayList<List<Integer>>();
            if (root == null) return levels;
        
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            int level = 0;
            while ( !queue.isEmpty() ) {
              // start the current level
              levels.add(new ArrayList<Integer>());
        
              // number of elements in the current level
              int level_length = queue.size();
              for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();
        
                // fulfill the current level
                levels.get(level).add(node.val);
        
                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
              }
              // go to next level
              level++;
            }
            return levels;
          }
 
}
