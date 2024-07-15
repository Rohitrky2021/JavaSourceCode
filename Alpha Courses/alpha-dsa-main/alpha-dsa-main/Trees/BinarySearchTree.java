package Trees;

import java.util.ArrayList;

public class BinarySearchTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public Node insert(Node root, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        return root;
    }

    private Node insert(Node node, int n) {
        if (node == null) {
            node = new Node(n);
            return node;
        }

        if (node.data < n) {
            node.right = insert(node.right, n);
        } else {
            node.left = insert(node.left, n);
        }

        return node;
    }

    public boolean search(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (node.data == value) {
            return true;
        }

        if (value < node.data) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }

    }

    public Node delete(Node root, int value) {
        if (value < root.data) {
            root = delete(root.left, value);
        } else if (value > root.data) {
            root = delete(root.right, value);
        } else {
            // value == root.data
            // we have to delete this node

            // CASE 1 - leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // CASE 2 - single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // CASE 3 - both children
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    private Node findInOrderSuccessor(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void printRoot2Leaf(Node node, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.data);
        if (node.left == null && node.right == null) {
            printPath(path);
        }

        printRoot2Leaf(node.left, path);
        printRoot2Leaf(node.right, path);
        path.remove(path.size() - 1);
    }

    public void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public boolean validateBST(Node node, Node min, Node max) {
        if (node == null) {
            return true;
        }

        if (min != null && node.data <= min.data) {
            return false;
        } else if (max != null && node.data >= max.data) {
            return false;
        }

        return validateBST(node.left, min, node) && validateBST(node.right, node, max);
    }

    public Node mirror(Node node) {
        if (node == null) {
            return null;
        }

        Node leftChild = mirror(node.left);
        Node rightChild = mirror(node.right);

        node.left = rightChild;
        node.right = leftChild;

        return node;
    }

    public Node createBSTFromSortedArray(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = createBSTFromSortedArray(arr, start, mid - 1);
        node.right = createBSTFromSortedArray(arr, mid + 1, end);
        return node;
    }

    public void getInorder(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        getInorder(node.left, list);
        list.add(node.data);
        getInorder(node.right, list);
    }

    public Node createBSTFromSortedArrayList(ArrayList<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(list.get(mid));
        node.left = createBSTFromSortedArrayList(list, start, mid - 1);
        node.right = createBSTFromSortedArrayList(list, mid + 1, end);
        return node;
    }

    public Node balanceBST(Node root) {
        // get inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // convert inorder to BST
        root = createBSTFromSortedArrayList(inorder, 0, inorder.size() - 1);
        return root;
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = largestBST(root.left);
        Info right = largestBST(root.right);

        int size = left.size + right.size + 1;
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));

        if (root.data <= left.max || root.data >= right.min) {
            return new Info(false, size, min, max);
        }

        if (left.isBST && right.isBST) {
            maxBST = Math.max(size, maxBST);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public void mergeTwoLists(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3) {
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                list3.add(list1.get(i));
                i++;
            } else {
                list3.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            list3.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            list3.add(list2.get(j));
            j++;
        }
    }

    public Node mergeTwoBSTs(Node root1, Node root2) {
        // get inorder seq of both trees
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        getInorder(root1, list1);
        getInorder(root2, list2);

        // merge the two lists
        ArrayList<Integer> list3 = new ArrayList<>();
        mergeTwoLists(list1, list2, list3);

        // now creating final tree from the final sorted array
        return createBSTFromSortedArrayList(list3, 0, list3.size() - 1);
    }


    public static void main(String args[]) {
        int[] arr = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };

        Node root = null;

        BinarySearchTree bst = new BinarySearchTree();
        root = bst.insert(root, arr);
        bst.preorder(root);
        System.out.println(bst.search(root, 6666));
        bst.delete(root, 5);
        bst.preorder(root);

    }

}
