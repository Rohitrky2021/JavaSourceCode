public class Tree_bottom_Up {
    
}


/**
* Approach 1: Recursion (Postorder Traversal)- Maintaing the Parent Node
* ? Complexity
** Time complexity: O(n)
** Space complexity: O(n)
*/
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return traverse(root, null, target);
    }

    private TreeNode traverse(TreeNode node, TreeNode parent, int target) {
        if (node == null)
            return null;

        node.left = traverse(node.left, node, target);
        node.right = traverse(node.right, node, target);

        if (node.left == null && node.right == null && node.val == target) {
            if (parent != null) {
                if (parent.left == node)
                    parent.left = null;
                else if (parent.right == node)
                    parent.right = null;
            }
            return null; // Remove the current node
        }

        return node;
    }
}

/**
 * Approach 2: Recursion (Postorder Traversal) -> Direct 
 * ? Complexity
 ** Time complexity: O(n)
 ** Space complexity: O(n)
 */
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return root;
        if (root.left == null && root.right == null) {
            return target == root.val ? null : root;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null) {
            return target == root.val ? null : root;
        }
        return root;
    }

}
 
// Similar to 2nd one Just written in Differnt way  ----->>>
 
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        // 1. Visit the left children
        root.left = removeLeafNodes(root.left, target);

        // 2. Visit the right children
        root.right = removeLeafNodes(root.right, target);

        // 3. Check if the current node is a leaf node and its value equals target
        if (root.left == null && root.right == null && root.val == target) {
            // Delete the node by returning null to the parent, effectively disconnecting it
            return null;
        }

        // Keep it untouched otherwise
        return root;
    }
}

/**
* Approach 3: Iterative (PostOrder Traversal) --> Not recommended to use 
* ? Complexity
** Time complexity: O(n)
** Space complexity: O(n)
*/

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root, lastRight = null;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.peek();

            if (current.right != lastRight && current.right != null) {
                current = current.right;
                continue;
            }

            stack.pop();

            if (current.right == null && current.left == null && current.val == target) {
                if (stack.isEmpty()) return null;
                TreeNode parent = stack.peek();
                if (parent.left == current) parent.left = null;
                else parent.right = null;
            }

            lastRight = current;
            current = null;
        }
        return root;
    }
}
