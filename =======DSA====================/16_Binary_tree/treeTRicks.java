package DSA.binary_tree;

public class treeTRicks {
    
}

Sure, here are code snippets for each of the five examples I provided earlier:
// --------------->>>>

Finding the kth smallest element in a binary search tree:
scss
Copy codez
public int kthSmallest(TreeNode root, int k) {
    List<Integer> elements = new ArrayList<>();
    inorderTraversal(root, elements);
    return elements.get(k - 1);
}

private void inorderTraversal(TreeNode node, List<Integer> elements) {
    if (node == null) {
        return;
    }
    inorderTraversal(node.left, elements);
    elements.add(node.val);
    inorderTraversal(node.right, elements);
}
// --------------->>>>

Serializing and deserializing a binary tree:
scss
Copy code
public String serialize(TreeNode root) {
    List<Integer> elements = new ArrayList<>();
    preorderTraversal(root, elements);
    return elements.toString();
}

public TreeNode deserialize(String data) {
    if (data.isEmpty()) {
        return null;
    }
    String[] values = data.substring(1, data.length() - 1).split(", ");
    List<Integer> elements = new ArrayList<>();
    for (String value : values) {
        elements.add(Integer.parseInt(value));
    }
    return buildTree(elements, 0, elements.size() - 1);
}

private void preorderTraversal(TreeNode node, List<Integer> elements) {
    if (node == null) {
        elements.add(null);
        return;
    }
    elements.add(node.val);
    preorderTraversal(node.left, elements);
    preorderTraversal(node.right, elements);
}

private TreeNode buildTree(List<Integer> elements, int start, int end) {
    if (start > end) {
    
        return null;
    }
    
    int mid = start + (end - start) / 2;
    TreeNode node = new TreeNode(elements.get(mid));
    node.left = buildTree(elements, start, mid - 1);
    node.right = buildTree(elements, mid + 1, end);
    return node;
}

// --------------->>>>

Converting a binary tree to a doubly linked list:
scss
Copy code
public TreeNode convertToDoublyLinkedList(TreeNode root) {
    List<TreeNode> nodes = new ArrayList<>();
    inorderTraversal(root, nodes);
    for (int i = 0; i < nodes.size() - 1; i++) {
        nodes.get(i).right = nodes.get(i + 1);
        nodes.get(i + 1).left = nodes.get(i);
    }
    return nodes.isEmpty() ? null : nodes.get(0);
}

private void inorderTraversal(TreeNode node, List<TreeNode> nodes) {
    if (node == null) {
        return;
    }
 
    inorderTraversal(node.left, nodes);
    nodes.add(node);
    inorderTraversal(node.right, nodes);
}
// --------------->>>>

Finding the shortest path in a tree between two nodes:
cpp
Copy code
public int shortestPath(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == null || q == null) {
        return -1;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    List<TreeNode> nodes = new ArrayList<>();
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            nodes.add(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        if (nodes.contains(p) && nodes.contains(q)) {
            int indexP = nodes.indexOf(p);
            int indexQ = nodes.indexOf(q);
            int distance = Math.abs(indexP - indexQ);
            return distance;
        }
        nodes.clear();
    }
    return -1;
}