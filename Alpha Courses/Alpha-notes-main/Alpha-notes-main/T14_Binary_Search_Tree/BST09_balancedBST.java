package T14_Binary_Search_Tree;

import java.util.*;

public class BST09_balancedBST {
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

    public static void main(String[] args) {
        int values[] = { 1, 5, 6, 7, 2, 3, 4, };

        Node root = null;

        BST09_balancedBST tree = new BST09_balancedBST();

        for (int i = 0; i < values.length; i++) {
            root = tree.insertbts(root, values[i]);
        }
        tree.inorder(root);
        root = tree.balancedBST(root);
        System.out.println("-------------------------");
        tree.inorder(root);
    }

    Node root;

    BST09_balancedBST() {
        root = null;
    }

    Node balancedBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderArrayList(root, list);
        System.out.println(list);
        root = creatBalancedBST(list, 0, list.size() - 1, null);
        return root;
    }

    Node creatBalancedBST(ArrayList<Integer> list, int s, int e, Node root) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;

        root = new Node(list.get(mid));
        root.left = creatBalancedBST(list, s, mid - 1, root);
        root.right = creatBalancedBST(list, mid + 1, e, root);

        return root;
    }

    void inorderArrayList(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inorderArrayList(root.left, list);
        list.add(root.data);
        inorderArrayList(root.right, list);
    }

    Node creatBalancedBST(int values[], int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;

        root = new Node(values[mid]);
        root.left = creatBalancedBST(values, s, mid - 1);
        root.right = creatBalancedBST(values, mid + 1, e);

        return root;
    }

    Node insertbts(Node root, int valu) {
        if (root == null) {
            root = new Node(valu);
            return root;
        }

        if (root.data > valu) {
            root.left = insertbts(root.left, valu);
        } else {
            root.right = insertbts(root.right, valu);
        }

        return root;
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

}
