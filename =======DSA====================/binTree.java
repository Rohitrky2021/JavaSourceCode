import java.util.*;

public class binTree {// PRE - IN - POST - LEVEL -> ORDE$R TRAVELSER
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;

        }
    }

    static class binaryTre {
        static int idx = -1;

        public Node buildTree(int node[]) {
            idx++;
            if (node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(node[idx]);
            // newNode=buildTree(node);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);

            return newNode;
        }

        public void preorder(Node root) {
            if (root == null) {
                System.out.print("-1" + " ");
                return;
            }
            System.out.print((root.data) + " ");

            preorder(root.left);
            preorder(root.right);
        }

        public void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public void postorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.right);
            System.out.print(root.data + " ");
            postorder(root.left);
        }

        /* Level order travelser */
        public void levelorder(Node root) {
            /* we use a dtta structure here FIFO */
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }

        }
    }

    public static void main(String[] arg) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        binaryTre bin = new binaryTre();
        Node root = bin.buildTree(node);
        System.out.println(root.data);

        bin.preorder(root);
        System.out.println();

        bin.inorder(root);
        System.out.println();

        bin.postorder(root);
        System.out.println();

        bin.levelorder(root);
    }

}
