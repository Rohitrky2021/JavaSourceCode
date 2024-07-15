import java.util.*;

public class tree {
    private static int[] tree;
    private static int n;

    static class SegmentTree {
        public SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[n * 4]; // Note: 4 times the size to accommodate all possible nodes
            buildTree(0, 0, n - 1, arr);
        }

        public int getMax(int arr[], int qi, int qj) {
            return getMaxUtil(0, 0, n - 1, qi, qj);
        }

        public int getMaxUtil(int i, int si, int sj, int qi, int qj) {
            if (si > qj || sj < qi) {
                return Integer.MIN_VALUE;
            } else if (si >= qi && sj <= qj) {
                // Complete overlap
                return tree[i];
            } else {
                int mid = (si + sj) / 2;
                int leftAns = getMaxUtil(2 * i + 1, si, mid, qi, qj);
                int rightAns = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);
                return Math.max(leftAns, rightAns);
            }
        }

        public void update(int index, int value) {
            index += n;
            tree[index] = value;
            while (index > 0) {
                int parent = index / 2;
                tree[parent] = Math.max(tree[parent * 2], tree[parent * 2 + 1]);
                index = parent;
            }
        }

        public int rangeSum(int startIndex, int endIndex) {
            int sum = 0;
            startIndex += n;
            endIndex += n;
            while (startIndex <= endIndex) {
                if (startIndex % 2 == 1) {
                    sum += tree[startIndex];
                    startIndex++;
                }
                if (endIndex % 2 == 0) {
                    sum += tree[endIndex];
                    endIndex--;
                }
                startIndex /= 2;
                endIndex /= 2;
            }
            return sum;
        }

        // Build the segment tree recursively
        public void buildTree(int i, int si, int sj, int arr[]) {
            if (si == sj) {
                tree[i] = arr[si];
                return;
            }
            int mid = (si + sj) / 2;
            buildTree(2 * i + 1, si, mid, arr);
            buildTree(2 * i + 2, mid + 1, sj, arr);
            tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
        }
    }

    public static void main(String args[]) {
        int[] arr = { 87, 2, 9, 11, 5 };
        SegmentTree st = new SegmentTree(arr);
        int startIndex = 0;
        int endIndex = 3; // You can modify this to set the desired range
        int indexToUpdate = 3;
        int newValue = 88;
        st.update(indexToUpdate, newValue);
        int max = st.getMax(arr, startIndex, endIndex);
        for (int i = 0; i < tree.length; i++) {
            System.out.println(tree[i]);
        }

        System.out.println("Max Value in Range: " + max);
        // System.out.println("Sum: " +st.rangeSum(0, 1));
    }
}

// import java.util.*;

// public class tree {
// // public class MaxMin {
// public static int[] tree;
// private static int n;

// static class SegmentTree {
// public SegmentTree(int[] arr) {
// n = arr.length;
// tree = new int[n * 4]; // Note: 4 times the size to accommodate all possible
// nodes

// // Build the segment tree using the provided buidtree function
// buildTree(0, 0, n - 1, arr);
// }

// public int getMax(int arr[], int qi, int qj) {
// // int n = arr.length;
// return getMaxUtil(0, 0, n - 1, qi, qj);
// }

// public int getMaxUtil(int i, int si, int sj, int qi, int qj) {
// if (si > qj || sj < qi) {
// return Integer.MIN_VALUE;
// } else if (si >= qi && sj <= qj) {
// // Complete overlap
// return tree[i];
// } else {
// int mid = (si + sj) / 2;
// int leftAns = getMaxUtil(2 * i + 1, si, mid, qi, qj);
// int rightAns = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);
// return Math.max(leftAns, rightAns);
// }
// }
// public int rangeSum(int startIndex, int endIndex) {
// int sum = 0;
// startIndex += n;
// endIndex += n;
// while (startIndex <= endIndex) {
// if (startIndex % 2 == 1) {
// sum += tree[startIndex];
// startIndex++;
// }
// if (endIndex % 2 == 0) {
// sum += tree[endIndex];
// endIndex--;
// }
// startIndex /= 2;
// endIndex /= 2;
// }
// return sum;
// }

// public void update(int index, int value) {
// index += n;
// tree[index] = value;

// while (index > 0) {
// int parent = index / 2;
// tree[parent] = tree[parent * 2] + tree[parent * 2 + 1];
// index = parent;
// }
// }

// // Build the segment tree recursively
// public void buildTree(int i, int si, int sj, int arr[]) {
// if (si == sj) {
// tree[i] = arr[si];
// return;
// }
// int mid = (si + sj) / 2;
// buildTree(2 * i + 1, si, mid, arr);
// buildTree(2 * i + 2, mid + 1, sj, arr);
// tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
// }
// }

// public static void main(String args[]) {
// int[] arr = { 87, 2, 9, 11, 5 };
// SegmentTree st = new SegmentTree(arr);
// int startIndex = 0;
// int endIndex = 4;
// int indexToUpdate = 3;
// int newValue = 88;
// st.update(indexToUpdate, newValue);
// int max = st.getMax(arr, startIndex, endIndex);

// System.out.println("Max Value in Range: " + max);
// System.out.println("Sum: " +st.rangeSum(0, 1));

// }
// }