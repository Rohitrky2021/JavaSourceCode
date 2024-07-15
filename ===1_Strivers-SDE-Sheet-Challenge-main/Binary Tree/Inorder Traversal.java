import java.util.*;
import java.io.*;
/*
    
    Following is the Binary Tree node structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.data = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.data = val;
            this.left = left;
            this.right = right;
        }
    }

*/

public class Solution {
    public static List<Integer> getInOrderTraversal(TreeNode root) {
        // Write your code here.
        // recursive Approach !!
        // List<Integer> in = new LinkedList<Integer>();
        // if(root == null) return in; # 1

        // inHelper(root, in);
        // in.addAll(inorderTraversal(root.left)); # 1
        // in.add(root.val); # 1
        // in.addAll(inorderTraversal(root.right)); # 1
        // return in;

        // Iterative Approach !!
        List<Integer> trav = new ArrayList<Integer>();
        Stack<TreeNode> pickup = new Stack<TreeNode>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                pickup.push(node);
                node = node.left;
            } else {
                if (pickup.isEmpty())
                    break;
                node = pickup.pop();
                trav.add(node.data);
                node = node.right;
            }
        }

        return trav;
    }

    public void inHelper(TreeNode root, List<Integer> in) {
        if (root == null)
            return;

        inHelper(root.left, in);
        in.add(root.data);
        inHelper(root.right, in);
    }
}