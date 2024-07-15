package T13_Binary_Tree;

public class BT01_buildTree {
    static class Node {
        int data;
        Node rightNode;
        Node leftNode;

        Node(int data) {
            this.data = data;
            this.rightNode = null;
            this.leftNode = null;
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
            newNode.rightNode = buildTree(nodes);
            newNode.leftNode = buildTree(nodes);
            return newNode;
        }

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);

    }

}