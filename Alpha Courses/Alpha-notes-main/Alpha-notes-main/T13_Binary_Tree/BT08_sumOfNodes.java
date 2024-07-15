
package T13_Binary_Tree;

import java.util.*;

public class BT08_sumOfNodes {

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

        void levelOrder(Node root) {
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
                    if (currNode.leftNode != null) {
                        q.add(currNode.leftNode);
                    }
                    if (currNode.rightNode != null) {
                        q.add(currNode.rightNode);
                    }
                }
            }
        }

        int sumofNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int lf = sumofNodes(root.leftNode);
            int lr = sumofNodes(root.rightNode);
            return root.data + lf + lr;
        }

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        tree.levelOrder(root);
        System.out.println(tree.sumofNodes(root));

    }

}