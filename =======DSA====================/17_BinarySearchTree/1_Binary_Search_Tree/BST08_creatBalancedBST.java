package T14_Binary_Search_Tree;

import java.util.*;

public class BST08_creatBalancedBST {
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

    BST08_creatBalancedBST() {
        root = null;
    }

    Node creatBalancedBST(int values[], int s, int e, Node root) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;

        root = new Node(values[mid]);
        root.left = creatBalancedBST(values, s, mid - 1, root.left);
        root.right = creatBalancedBST(values, mid + 1, e, root.right);

        return root;
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
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int values[] = { 1, 2, 3, 4, 5, 6, 7 };
        BST08_creatBalancedBST tree = new BST08_creatBalancedBST();
        Node root = tree.creatBalancedBST(values, 0, values.length - 1, null);
        tree.levelOrder(root);
    }
}
