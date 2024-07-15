package Recursion.RecursionArraysQuestions;

import java.util.ArrayList;

public class LinearSearchOnMultipleOccurances {
    public static void main(String args[]) {
        // ArrayList<Integer> ans = new ArrayList<>();
        int[] arr = { 1, 2, 3, 4, 5, 5, 6, 7, 8 };
        int target = 5;
        // searchMultipleIndex(arr, ans, target, 0);
        // System.out.println(ans);
        System.out.println(findAllIndex(arr, target, 0));
    }

    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (index == arr.length) {
            return ans;
        }
        if (arr[index] == target) {
            ans.add(index);
        }
        ArrayList<Integer> ansFromBelowCells = findAllIndex(arr, target, index + 1);
        ans.addAll(ansFromBelowCells);
        return ans;
    }

    static ArrayList<Integer> searchMultipleIndex(int[] arr, ArrayList<Integer> ans,
            int target, int index) {
        if (index == arr.length) {
            return ans;
        }
        if (arr[index] == target) {
            ans.add(index);
        }
        return searchMultipleIndex(arr, ans, target, index + 1);
    }



}
