package T14_Binary_Search_Tree;

import java.util.ArrayList;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BST05_printRoot2Leaf {
    Node root;

    BST05_printRoot2Leaf() {
        root = null;
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

    void print2leaf(Node root, ArrayList<Node> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        if (root.left == null && root.right == null) {
            printPath(list);
        }
        print2leaf(root.left, list);
        print2leaf(root.right, list);
        list.remove(root);
    }

    void printPath(ArrayList<Node> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).data + "-> ");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        BST05_printRoot2Leaf tree = new BST05_printRoot2Leaf();

        for (int i = 0; i < values.length; i++) {
            root = tree.insertbts(root, values[i]);
        }

        tree.print2leaf(root, new ArrayList<>());

    }
}
