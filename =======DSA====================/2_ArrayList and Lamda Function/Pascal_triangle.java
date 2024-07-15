import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal_triangle {
    public static void main(String[] args) {

    }

    // 1
    // 1 1
    // 1 2 1
    // 1 3 3 1
    // 1 4 6 4 1

    public List<Integer> getRow(int r) {
        List<Integer> anss = new ArrayList<>();
        int ans[][] = new int[r][r];
        ans[0][0] = 1;

        for (int i = 1; i < ans.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i - 1][j - 1];
            }
            ans[i][j] = 1;
        }

        for(int i:ans[r]){
            anss.add(i);
        }
        return anss;

    }
}


class Solution {

    public List<Integer> getRow(int r) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // if (r == 0) {
        //     anss.add(1);
        //     return anss;
        // }
        int ans[][] = new int[r + 1][r + 1];
        if (ans.length >= 1) ans[0][0] = 1;

        for (int i = 1; i < ans.length; i++) {
            ans[i][0] = 1;
            for (int j = 1; j < i; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i - 1][j - 1];
            }
            ans[i][i] = 1;
        }

        for (int i : ans ) {
           triangle.add(Arrays.asList(i));
        }
        return triangle;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // if (r == 0) {
        //     anss.add(1);
        //     return anss;
        // }
        int ans[][] = new int[r + 1][r + 1];
        if (ans.length >= 1) ans[0][0] = 1;

        for (int i = 1; i < ans.length; i++) {
            ans[i][0] = 1;
            for (int j = 1; j < i; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i - 1][j - 1];
            }
            ans[i][i] = 1;
        }

        for (Integer[] i : ans ) {
           triangle.add(Arrays.asList(i));
        }
        return triangle;
    }
}
