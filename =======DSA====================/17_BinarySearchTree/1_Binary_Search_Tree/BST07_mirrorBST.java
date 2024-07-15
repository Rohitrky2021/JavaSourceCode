
package T14_Binary_Search_Tree;


public class BST07_mirrorBST {
    static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root;

    BST07_mirrorBST() {
        root = null;
    }

    Node insertbts(Node root, int valu) {
        if (root == null) {
            root = new Node(valu);
            return root;
        }

        if (root.data > valu) {
            root.left = insertbts(root.left, valu);
        } else {
            root.right = insertbts(root.right, valu);
        }

        return root;
    }

    Node mirrorBST(Node root) {
        if (root == null) {
            return root;
        }
        Node leftNode = mirrorBST(root.left);
        Node rightNode = mirrorBST(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        BST07_mirrorBST tree = new BST07_mirrorBST();

        for (int i = 0; i < values.length; i++) {
            root = tree.insertbts(root, values[i]);
        }

        tree.inorder(root);
        System.err.println();
        Node newRoot = tree.mirrorBST(root);
        tree.inorder(newRoot);

    }
}
