package T13_Binary_Tree;

public class BT02_preorderTraversal {
    static class Node {
        int data;
        Node rightNode;
        Node leftNode;

        Node(int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1 || idx >= nodes.length) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.leftNode = buildTree(nodes);
            newNode.rightNode = buildTree(nodes);
            return newNode;
        }

        void preOrder(Node root) {
            if (root == null) {
                // System.out.print(-1 + " ");
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.leftNode);
            preOrder(root.rightNode);
        }

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        tree.preOrder(root);
        System.out.println();

    }

}