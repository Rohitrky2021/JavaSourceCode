package T20_Segment_Tree;

public class ST06_maxSTupdate {

    static int tree[];

    static void buildST(int arr[]) {
        tree = new int[(arr.length - 1) * 4];
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
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    static void update(int arr[], int idx, int newVal) {
        buildST(arr);
        printTree();

       
        arr[idx] = newVal;
        update_util(0, 0, arr.length - 1, idx, newVal);
        printTree();
    }

    static void update_util(int i, int sti, int stj, int idx, int newVal) {
        if (idx < sti || stj < idx) {
            return;
        }

        tree[i] = Math.max(tree[i], newVal);
         
        if (sti != stj) {
            int mid = (sti + stj) / 2;
            update_util(2 * i + 1, sti, mid, idx, newVal);
            update_util(2 * i + 2, mid + 1, stj, idx, newVal);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        update(arr, 2, 20);
    }
}
