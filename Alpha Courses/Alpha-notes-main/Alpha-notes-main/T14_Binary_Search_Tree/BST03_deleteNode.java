package T14_Binary_Search_Tree;

public class BST03_deleteNode {

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

    Node buildTree(Node root, int values[]) {
        for (int i = 0; i < values.length; i++) {
            root = insertbts(root, values[i]);
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

    boolean Searching(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        } else if (root.data > key) {
            return Searching(root.left, key);
        } else {
            return Searching(root.right, key);
        }
    }

    Node deletNode(Node root, int val) {
        if (root.data > val) {
            root.left = deletNode(root.left, val);
        } else if (root.data < val) {
            root.right = deletNode(root.right, val);
        } else {
            // case 1 leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            Node ios = findInorderSuccessor(root.right);
            root.data = ios.data;
            root.right = deletNode(root.right, ios.data);

        }
        return root;
    }

    Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };

        BST03_deleteNode tree = new BST03_deleteNode();
        Node root = tree.buildTree(null, values);
        tree.inorder(root);
        tree.deletNode(root, 4);
        tree.inorder(root);

    }
}
