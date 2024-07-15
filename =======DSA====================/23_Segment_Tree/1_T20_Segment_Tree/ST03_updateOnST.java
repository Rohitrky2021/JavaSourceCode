// package T20_Segment_Tree;

public class ST03_updateOnST {

    static int tree[];

    static void buildST(int arr[]) {
        tree = new int[arr.length * 4]; // Corrected array size to arr.length * 4
        buildST_util(arr, 0, 0, arr.length - 1);
    }

    static void printTree() {
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }
  
    static void buildST_util(int arr[], int i, int s, int e) {
        if (s == e) {
            tree[i] = arr[s];
            return;
        }
        int mid = (s + e) / 2;
        buildST_util(arr, 2 * i + 1, s, mid);
        buildST_util(arr, 2 * i + 2, mid + 1, e);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    static void update(int arr[], int idx, int val) {
        buildST(arr);
        printTree();

        int dif = val - arr[idx];
        arr[idx] = val;
        update_util(0, 0, arr.length - 1, idx, dif);
        printTree();
    }

    // Point Update
    static void update_util(int i, int sti, int stj, int idx, int dif) {
        if (idx < sti || stj < idx) {
            return; // No Overlap no update 
        }

        /* For more clarity you can here also write if(ss==se) but No need */
        tree[i] += dif;   // After sending what to do write here

        if (sti != stj) {  // Send to left, right part 
            int mid = (sti + stj) / 2;
            update_util(2 * i + 1, sti, mid, idx, dif);
            update_util(2 * i + 2, mid + 1, stj, idx, dif);
        }
    }

    // Range Update
    static void update_util(int i, int sti, int stj, int l, int r, int dif) {
        // No Overlap
        if (r < sti || stj < l) {
            return;
        }

        // Full Overlap
        if (sti == stj) { // Corrected condition from (l <= sti && stj <= r) to (sti == stj)
            tree[i] += dif; // Update the node in the range [l, r]
            return;
        }

        // Partial Overlap - Update the current node and go to left and right children
        int mid = (sti + stj) / 2;
        update_util(2 * i + 1, sti, mid, l, r, dif);
        update_util(2 * i + 2, mid + 1, stj, l, r, dif);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2]; // Added to ensure tree is updated correctly
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        update(arr, 2, 2);
    }
}
