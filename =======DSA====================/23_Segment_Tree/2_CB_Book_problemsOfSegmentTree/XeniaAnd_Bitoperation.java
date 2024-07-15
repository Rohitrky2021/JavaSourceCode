 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class XeniaAnd_Bitoperation {

    // https://codeforces.com/contest/339/problem/D   ==>  Depending on the level of the tree have to perform OR and XOR 
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[(int) Math.pow(2, n)];
        int m = sc.nextInt();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int trees[] = create(arr);

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < m; i++) {
            int idx = sc.nextInt();
            int val = sc.nextInt();
            idx--;

            update(trees, val - arr[idx], idx, arr);
            sb.append(Integer.toString(trees[0]) + "\n");
        }
        System.out.print(sb);
    }

    public static void update(int[] trees, long diff, int idx, int arr[]) {
        updateTrees(trees, diff, idx, 0, arr.length - 1, 0);
        arr[idx] += diff;
    }

    public static int updateTrees(int[] trees, long diff, int idx, int st, int end, int curidx) {
        if (st > idx || end < idx) {
            return -1;
        }
        if (st == end  ) {
            trees[curidx] += diff;
            return 1;
        }

        int mid = (st + end) / 2;

        int num1 = updateTrees(trees, diff, idx, st, mid, 2 * curidx + 1);
        int num2 = updateTrees(trees, diff, idx, mid + 1, end, 2 * curidx + 2);

        if (Math.max(num1, num2) % 2 == 0) {
            trees[curidx] = trees[2 * curidx + 1] ^ trees[2 * curidx + 2];
        } else {
            trees[curidx] = trees[2 * curidx + 1] | trees[2 * curidx + 2];
        }

        return Math.max(num1, num2) + 1;
    }

    public static int[] create(int arr[]) {
        int trees[] = new int[4 * arr.length];
        createTrees(trees, arr, 0, arr.length - 1, 0);
        return trees;
    }

    public static int createTrees(int trees[], int arr[], int st, int end, int idx) {
        if (st == end) {
            trees[idx] = arr[st];
            return 1;
        }

        int mid = (st + end) / 2;

        int num1 = createTrees(trees, arr, st, mid, 2 * idx + 1);
        createTrees(trees, arr, mid + 1, end, 2 * idx + 2);

        if (num1 % 2 == 0) {
            trees[idx] = trees[2 * idx + 1] ^ trees[2 * idx + 2];
        } else {
            trees[idx] = trees[2 * idx + 1] | trees[2 * idx + 2];
        }
        return num1 + 1;
    }
}
