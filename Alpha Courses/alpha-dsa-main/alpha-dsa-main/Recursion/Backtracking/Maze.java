package Recursion.Backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String args[]) {
        System.out.println(countPaths(3, 3));
        printPaths("", 3, 3);
        System.out.println(retPaths("", 3, 3));
        System.out.println(pathDiagonal("", 3, 3));
    }

    static ArrayList<String> pathDiagonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        if (r > 1 && c > 1) {
            ans.addAll(pathDiagonal(p + 'D', r - 1, c - 1));
        }
        if (r > 1) {
            ans.addAll(pathDiagonal(p + 'V', r - 1, c));
        }
        if (c > 1) {
            ans.addAll(pathDiagonal(p + 'H', r, c - 1));
        }

        return ans;
    }

    static ArrayList<String> retPaths(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();

        if (r > 1) {
            ans.addAll(retPaths(p + 'D', r - 1, c));
        }

        if (c > 1) {
            ans.addAll(retPaths(p + 'R', r, c - 1));
        }

        return ans;
    }

    static void printPaths(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            printPaths(p + 'D', r - 1, c);
        }

        if (c > 1) {
            printPaths(p + 'R', r, c - 1);
        }
    }

    static int countPaths(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int left = countPaths(r - 1, c);
        int right = countPaths(r, c - 1);

        return left + right;
    }
}