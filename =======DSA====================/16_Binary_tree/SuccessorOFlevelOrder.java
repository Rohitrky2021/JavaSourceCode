import java.util.Queue;

import javax.swing.tree.TreeNode;

public class SuccessorOFlevelOrder {  //O(N)  --> Both 
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return null;
        }

        q.offer(root);

        while (!q.isEmpty()) {

            int levelSize = q.size();

            List<Integer> currentlevel = new ArrayList<>();

          
                TreeNode curr = q.poll();
                currentlevel.add(curr.val);

                if (curr.left != null) {
                    q.offer(curr.left); // Adding the left part of Node
                }
                if (curr.right != null) { // Adding the Right part of Node
                    q.offer(curr.right);
                }

                if(curr.val==key){
                    break;
                }

        }
        return q.peek();// Just Right Element of Key Given 
    }
}
