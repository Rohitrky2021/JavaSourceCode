package T13_Binary_Tree;

public class BT14_minDist {
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

    BT14_minDist() {
        root = null;
    }

    Node lcaNode(Node root, int k1, int k2) {
        if (root == null || root.data == k1 || root.data == k2) {
            return root;
        }
        Node leftLca = lcaNode(root.left, k1, k2);
        Node rightLca = lcaNode(root.right, k1, k2);

        if (rightLca == null) {
            return leftLca;
        }

        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int rightDist = lcaDist(root.right, n);
        int leftDist = lcaDist(root.left, n);

        if (rightDist == -1 && leftDist == -1) {
            return -1;
        } else if (rightDist == -1) {
            return leftDist + 1;
        } else {
            return rightDist + 1;
        }
    }

    int minDist(Node root, int n1, int n2) {
        Node lca = lcaNode(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        return dist1 + dist2;
    }

    public static void main(String[] args) {
        BT14_minDist tree = new BT14_minDist();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        int ans = tree.minDist(tree.root, 3, 4);
        System.out.println(ans);
    }
}
