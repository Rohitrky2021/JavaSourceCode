package T13_Binary_Tree;

public class BT15_kAncestor {
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

    BT15_kAncestor() {
        root = null;
    }

    int kAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);

        if (max + 1 == k) {
            System.out.println(root.data + " ");
        }
        return max + 1;

    }

    public static void main(String[] args) {
        BT15_kAncestor tree = new BT15_kAncestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        tree.kAncestor(tree.root, 6, 3);
    }
}
