import java.util.ArrayList;
import java.util.Stack;

public class nextGreaterele {
    public static void main(String args[]) {
        Stack<Integer> ss = new Stack<>();
        int arr[] = { 6, 8, 0, 1, 3 };
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!ss.isEmpty() && arr[ss.peek()] <= arr[i]) {
                ss.pop();
            }
            if (ss.isEmpty()) {
                // ss.push(-1);
                ans.add(-1);
            } else {
                ans.add(arr[ss.peek()]);
            }
            ss.push(i);// index se check krenge value
        }

        int anss[]=new int[arr.length];
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i) + " ");
        }

    }
}
