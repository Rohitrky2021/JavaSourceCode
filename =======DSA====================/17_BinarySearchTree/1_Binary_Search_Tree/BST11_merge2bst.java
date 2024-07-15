
package T14_Binary_Search_Tree;

import java.util.*;

public class BST11_merge2bst {
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
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        levelOrder(root1);
        System.out.println("------------------");

        Node root2 = new Node(9);
        root2.left = new Node(3);
        levelOrder(root2);
        System.out.println("------------------");
        root2.right = new Node(12);
        Node root = mergBST(root1, root2);
        levelOrder(root);

    }

    static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    static Node creatBST(ArrayList<Integer> list, int st, int ed) {
        if (st > ed) {
            return null;
        }
        int mid = (st + ed) / 2;
        Node root = new Node(list.get(mid));
        root.left = creatBST(list, st, mid - 1);
        root.right = creatBST(list, mid + 1, ed);
        return root;
    }

    static Node mergBST(Node root1, Node root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        getInorder(root1, list1);
        getInorder(root2, list2);
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                list.add(list1.get(i));
                i++;
            } else {
                list.add(list2.get(j));
                j++;

            }
        }
        while (i < list1.size()) {
            list.add(list1.get(i));
            i++;

        }
        while (j < list1.size()) {
            list.add(list2.get(j));
            j++;

        }
        Node root = creatBST(list, 0, list.size() - 1);
        return root;

    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.err.print(root.data + " ");
        inorder(root.right);
    }

    static void levelOrder(Node root) {
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
