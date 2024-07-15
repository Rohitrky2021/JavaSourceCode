package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    public BinaryTree() {

    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner scanner) {
        System.out.println("Enter the root node : ");
        int value = scanner.nextInt();

        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter the left of " + node.value + " ?");
        boolean left = scanner.nextBoolean();

        if (left) {
            System.out.println("Enter the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter the right of " + node.value + " ?");
        boolean right = scanner.nextBoolean();

        if (right) {
            System.out.println("Enter the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }

    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level + 1);

    }

    public void levelOrderTraversal() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (q != null) {
            Node curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    System.out.println();
                    q.add(null);
                }
            } else {
                System.out.println(curr.value + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    public int heightCalc() {
        return heightCalc(root);
    }

    private int heightCalc(Node node) {
        if (node == null) {
            return 0;
        }

        int h1 = heightCalc(node.left);
        int h2 = heightCalc(node.right);

        return Math.max(h1, h2) + 1;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        }

        int leftCount = countNodes(node.left);
        int rightCount = countNodes(node.right);

        return (1 + leftCount + rightCount);
    }

    public int sumOfNodes() {
        return sumOfNodes(root);
    }

    private int sumOfNodes(Node node) {
        if (node == null) {
            return 0;
        }

        int leftSum = sumOfNodes(node.left);
        int rightSum = sumOfNodes(node.right);

        return (leftSum + rightSum + node.value);
    }

    public int diameterOfTree() {
        return diameterOfTree(root).diameter;
    }

    // private int diameterOfTree(Node node) {
    // if (node == null) {
    // return 0;
    // }

    // int ld = diameterOfTree(node.left);
    // int rd = diameterOfTree(node.right);

    // int d = heightCalc(node.left) + heightCalc(node.right) + 1;

    // return Math.max(Math.max(ld, rd), d);
    // }

    private Info diameterOfTree(Node node) {
        if (node == null) {
            return new Info(0, 0);
        }

        Info ld = diameterOfTree(node.left);
        Info rd = diameterOfTree(node.right);

        int d = Math.max(Math.max(ld.diameter, rd.diameter), (ld.height + rd.height + 1));
        int ht = Math.max(ld.height, rd.height) + 1;

        return new Info(d, ht);
    }

    public class Info {
        int diameter;
        int height;

        public Info(int d, int h) {
            this.diameter = d;
            this.height = h;
        }
    }

    public boolean isSubtree(Node root, Node subroot) {
        if (root == null) {
            return false;
        }

        if (root.value == subroot.value) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }

        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public boolean isIdentical(Node node, Node subroot) {

        if (node == null && subroot == null) {
            return true;
        } else if (node == null || subroot == null || node.value != subroot.value) {
            return false;
        }

        if (!isIdentical(node.left, subroot.left)) {
            return false;
        }

        if (!isIdentical(node.right, subroot.right)) {
            return false;
        }

        return true;
    }

    public class Info2 {
        int hd;
        Node node;

        public Info2(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public void topView(Node root) {
        // level order traversal
        Queue<Info2> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info2(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info2 curr = q.remove();

            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Info2(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info2(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }

        }

        // printing nodes from hashmap
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).value + " ");
        }
        System.out.println();

    }

    public void kLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.value + " ");
            return;
        }

        kLevel(root.left, level + 1, k);
        kLevel(root.right, level + 1, k);
    }

    public Node leastCommanAncestor(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        Node LCA = path1.get(i - 1);
        return LCA;
    }

    public boolean getPath(Node node, int n, ArrayList<Node> path) {
        if (node == null) {
            return false;
        }

        path.add(node);

        if (node.value == n) {
            return true;
        }

        boolean foundLeft = getPath(node.left, n, path);
        boolean foundRight = getPath(node.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

}
