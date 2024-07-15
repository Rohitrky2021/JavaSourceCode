package T13_Binary_Tree;

public class BT16_sumTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    Node root;

    BT16_sumTree() {
        root = null;
    }

    int sumofNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftChild = sumofNodes(root.left);
        int rightchild = sumofNodes(root.right);

        int data = root.data;

        int newLeft = (root.left == null) ? 0 : root.left.data;
        int newright = (root.right == null) ? 0 : root.right.data;

        root.data = leftChild + rightchild + newLeft + newright;

        return data;
    }

    public static void main(String[] args) {
        BT16_sumTree tree = new BT16_sumTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        tree.sumofNodes(tree.root);
        System.out.println(tree.root.data);
    }
}
