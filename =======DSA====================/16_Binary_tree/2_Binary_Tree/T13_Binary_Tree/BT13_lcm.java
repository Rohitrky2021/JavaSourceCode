package T13_Binary_Tree;

import java.util.ArrayList;

public class BT13_lcm {
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

    BT13_lcm() {
        root = null;
    }

    boolean getPath(Node root, int k, ArrayList<Node> list) {
        if (root == null) {
            return false;
        }

        list.add(root);

        if (root.data == k) {
            return true;
        }
        boolean left = getPath(root.left, k, list);
        boolean right = getPath(root.right, k, list);
        if (left || right) {
            return true;
        }

        list.remove(root);
        return false;

    }

    Node lcaNode(Node root, int k1, int k2) {
        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();
        getPath(root, k1, list1);
        getPath(root, k2, list2);

        int i;
        for (i = 0; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                break;
            }
        }

        return list1.get(i - 1);
    }


    // Optimised APProach -- > M 2
    
    Node lcaNode2(Node root, int k1, int k2) {
        if (root == null || root.data == k1 || root.data == k2) {
            return root;
        }
        Node leftLca = lcaNode2(root.left, k1, k2);
        Node rightLca = lcaNode2(root.right, k1, k2);

        if (rightLca == null) {
            return leftLca;
        }

        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static void main(String[] args) {
        BT13_lcm tree = new BT13_lcm();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        int ans = tree.lcaNode2(tree.root, 3, 4).data;
        System.out.println(ans);
    }
}
