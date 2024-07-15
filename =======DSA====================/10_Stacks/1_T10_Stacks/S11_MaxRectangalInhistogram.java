package T10_Stacks;

import java.util.Stack;

public class S11_MaxRectangalInhistogram {
    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        printArr(arr);
        System.out.println(maxRectangal(arr));
    }

    public static int maxRectangal(int arr[]) {
        int nextSmall[] = nextSmaller(arr);
        int preSmall[] = preSmaller(arr);

        int maxRectangal = 0;
        int curRectangal = 0;
        for (int i = 0; i < arr.length; i++) {
            curRectangal = arr[i] * (nextSmall[i] - preSmall[i] - 1);
            if (maxRectangal < curRectangal) {
                maxRectangal = curRectangal;
            }
        }
        return maxRectangal;
    }

    public static int[] nextSmaller(int arr[]) {
        int ans[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = arr.length;
            } else {
                ans[i] = s.peek();
            }
            s.push(i);
        }
        // printArr(ans);
        return ans;

    }

    public static int[] preSmaller(int arr[]) {
        int ans[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = s.peek();
            }
            s.push(i);
        }
        // printArr(ans);
        return ans;

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
