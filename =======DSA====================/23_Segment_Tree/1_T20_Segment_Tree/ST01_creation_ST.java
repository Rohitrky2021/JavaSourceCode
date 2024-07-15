// package T20_Segment_Tree;

// https://leetcode.com/problems/range-sum-query-mutable/

public class ST01_creation_ST {

    static int tree[];

    static void init(int arr[]) {
        tree = new int[(arr.length - 1) * 4];
        buildST(arr, 0, 0, arr.length - 1);
        printTree();
    }

    static void printTree() {
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    static void buildST(int arr[], int i, int s, int e) {
        if (s == e) {
            tree[i] = arr[s];
            return;
        }
        int mid = (s + e) / 2;
        buildST(arr, 2 * i + 1, s, mid);
        buildST(arr, 2 * i + 2, mid + 1, e);
        
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        System.out.println(tree[i] + " ");
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        init(arr);

    }
}
