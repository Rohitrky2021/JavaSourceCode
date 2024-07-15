package T14_Binary_Search_Tree;

public class BST04_PrintInRange {

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

    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    void printInRange(Node root, int n1, int n2) {
        if (root == null) {
            return;
        }

        if (n1 <= root.data && root.data <= n2) {
            printInRange(root.left, n1, n2);
            System.out.print(root.data + " ");
            printInRange(root.right, n1, n2);
        }
        if (root.data < n1) {
            printInRange(root.right, n1, n2);
        }
        if (root.data > n2) {
            printInRange(root.left, n1, n2);
        }

    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        BST04_PrintInRange tree = new BST04_PrintInRange();

        for (int i = 0; i < values.length; i++) {
            root = tree.insertbts(root, values[i]);
        }
        tree.printInRange(root, 3,6);
    }
}