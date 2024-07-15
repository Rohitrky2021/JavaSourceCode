
package T20_Segment_Tree;

public class ST05_maxSTqueries {

    static int tree[];

    static void buildST(int arr[]) {
        tree = new int[(arr.length - 1) * 4];
        buildST_util(arr, 0, 0, arr.length - 1);
        printTree();
    }

    static void printTree() {
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    static void buildST_util(int arr[], int i, int s, int e) {
        if (s == e) {
            tree[i] = arr[s];  // Leaf p kya hai wo main hai 
            return;
        }
        int mid = (s + e) / 2;
        buildST_util(arr, 2 * i + 1, s, mid);
        buildST_util(arr, 2 * i + 2, mid + 1, e);
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]); // ab jo leave m tha uske saath krna kya hai 
    }

    static int getMax(int arr[], int i, int j) {
        buildST(arr);
        return getMax_util(0, 0, arr.length - 1, i, j);
    }

    static int getMax_util(int i, int sti, int stj, int qi, int qj) {
        if (qj < sti || qi > stj) {
            return Integer.MIN_VALUE;
        } else if (sti >= qi && qj >= stj) {
            return tree[i];
        } else {
            int mid = (sti + stj) / 2;
            int left = getMax_util(2 * i + 1, sti, mid, qi, qj);
            int right = getMax_util(2 * i + 2, mid + 1, stj, qi, qj);
            return Math.max(left, right);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(getMax(arr, 2, 4));
    }
}
  