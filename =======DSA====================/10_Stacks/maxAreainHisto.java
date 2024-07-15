import java.util.*;

public class maxAreainHisto {
    public static void main(String args[]) {
        // String s1="(a+b)";
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        nsl(arr);// next smaller left

    }

    public static void nsl(int arr[]) {
        Stack<Integer> ss = new Stack<>();
        // int arr[]={6,8,0,1,3};
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            while (!ss.isEmpty() && arr[ss.peek()] >= arr[i]) {
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
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i) + " ");
        }

    }

}
