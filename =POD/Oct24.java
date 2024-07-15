import java.util.*;
import java.util.Deque;
import java.util.PriorityQueue;

public class Oct24 {
    class Solution {

        public class CustomPriorityQueue<T> extends ArrayDeque<T> {
            @Override
            public boolean add(T element) {
                if (isEmpty() || ((Comparable<T>) element).compareTo(getLast()) >= 0) {
                    return super.offer(element);
                } else {
                    int index = 0;
                    for (T e : this) {
                        if (((Comparable<T>) element).compareTo(e) < 0) {
                            break;
                        }
                        index++;
                    }
                    add(index, element);
                    return true;
                }
            }
            
        
            // Add other custom methods if needed
        }
     

        public List<Integer> largestValues(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            q.offer(root);
            int level = 1;
            while (!q.isEmpty()) {
                int levelSize = q.size();
                CustomPriorityQueue<Integer> currentlevel = new CustomPriorityQueue<>();
                // List<Integer> currentlevel = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode curr = q.poll();
                    currentlevel.add(curr.val);
                    if (curr.left != null) {
                        q.offer(curr.left); // Adding the left part of Node
                    }
                    if (curr.right != null) { // Adding the Right part of Node
                        q.offer(curr.right);
                    }
                }
    
                 
                ans.add(currentlevel.getLast());
    
               
                level++;
            }
            return ans;
        }
    }
      
}
