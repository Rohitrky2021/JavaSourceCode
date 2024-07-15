public class Bool_of_Bottom_UP_Tree {
    
}


    /**
     * Approac 1: Bactracking time implementation
     * ? Complexity
     ** Time complexity: O(n)
     ** Space complexity: O(n)
     */
    
class Solution {
    public boolean evaluateTree(TreeNode root) {
        return traverseBottomUp(root);
    }
    boolean ans;

    public boolean traverseBottomUp(TreeNode root) {
        if (root == null) return false;
        if(root.val==0)return false;
        if(root.val==1) return true;

        // Traverse left subtree
        boolean l= traverseBottomUp(root.left);

        // Traverse right subtree
       boolean r= traverseBottomUp(root.right);

        if(root.val==2){
            ans=l|r;
        }else if(root.val==3){
            ans=l&r;
        }

        return ans;
    }
}