package T10_Stacks;

import java.util.*;

public class S07_StockSpane {
    public static void main(String[] args) {
        int arr[] = { 100, 80, 60, 70, 60, 85, 100 };
        ArrayList<Integer> ans = StockSpane(arr);
        System.out.println(ans);
        ans = stockSpane(arr);
        System.out.println(ans);
    }

    public static ArrayList<Integer> StockSpane(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        int i = 0;
        while (i < arr.length) {
            if (s.isEmpty()) {
                ans.add(i + 1);
                s.push(i);
                i++;
            } else if (arr[s.peek()] > arr[i]) {
                ans.add(i - s.peek());
                s.push(i);
                i++;
            } else {
                s.pop();
            }
        }
        return ans;
    }

    public static ArrayList<Integer> stockSpane(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        ans.add(1);
        s.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans.add(i + 1);
            } else {
                ans.add(i - s.peek());

            }
            s.push(i);
        }
        return ans;
    }
}
