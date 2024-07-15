package T13_Binary_Tree;

public class BT12_kthLevel {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BT12_kthLevel() {
        root = null;
    }

    void klevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        klevel(root.left, level + 1, k);
        klevel(root.right, level + 1, k);
    }

    public static void main(String[] args) {
        /*
         * Create following Binary Tree
         *         1
         *        / \
         *       2 3
         *        \
         *         4
         *          \
         *           5
         *            \
         *             6
         *    
         */
        BT12_kthLevel tree = new BT12_kthLevel();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        int k = 2;
        tree.klevel(tree.root, 1, k);
    }
}
