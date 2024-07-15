package Trees;

public class AVL {
    private class Node {
        int data;
        int height;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    public static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    public static int getBalanceFactor(Node node) {
        return (getHeight(node.left) - getHeight(node.right));
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return y;
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.data) {
            node.left = insert(node.left, value);
        } else if (value > node.data) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }

        // update node height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // get node`s balance factor
        int bf = getBalanceFactor(node);

        // LL case
        if (bf > 1 && value < node.left.data) {
            return rightRotate(node);
        }
        // RR case
        if (bf < -1 && value > node.right.data) {
            return leftRotate(node);
        }
        // LR case
        if (bf > 1 && value > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RL case
        if (bf < -1 && value < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;

    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private Node root;

    public static void main(String args[]) {
        AVL avl = new AVL();
        avl.root = avl.insert(avl.root, 10);
        avl.root = avl.insert(avl.root, 20);
        avl.root = avl.insert(avl.root, 30);
        avl.root = avl.insert(avl.root, 40);
        avl.root = avl.insert(avl.root, 50);
        avl.root = avl.insert(avl.root, 25);

        avl.preorder(avl.root);
    }
}
