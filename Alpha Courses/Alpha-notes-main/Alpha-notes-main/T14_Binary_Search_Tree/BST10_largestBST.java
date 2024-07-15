package T14_Binary_Search_Tree;

public class BST10_largestBST {
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

    BST10_largestBST() {
        root = null;
    }

    class info {
        int min;
        int max;
        boolean isBst;
        int size;

        info(int min, int max, boolean isBst, int size) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    static int maxBst = 0;

    info largestBST(Node root) {
        if (root == null) {

            return new info(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
        }
        info leftInfo = largestBST(root.left);
        info rightInfo = largestBST(root.right);

        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        int size = leftInfo.size + rightInfo.size + 1;

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new info(min, max, false, size);
        }
        if (leftInfo.isBst && rightInfo.isBst) {
            maxBst = Math.max(maxBst, size);
            return new info(min, max, true, size);
        }
        return new info(min, max, false, size);
    }

    public static void main(String[] args) {
        BST10_largestBST tree = new BST10_largestBST();
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(20);

        tree.root.right = new Node(60);
        tree.root.right.left = new Node(45);
        tree.root.right.right = new Node(70);
        tree.root.right.right.left = new Node(65);
        tree.root.right.right.right = new Node(80);

        tree.largestBST(tree.root);
        System.out.println(maxBst);

    }
}
