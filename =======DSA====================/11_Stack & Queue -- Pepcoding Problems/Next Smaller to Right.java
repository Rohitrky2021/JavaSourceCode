import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + "
");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
  }

  public static int[] solve(int[] arr) {
    int n = arr.length;
    int[] nse = new int[n];
    
    Stack<Integer> stk = new Stack<>();
    for(int i=n-1; i>=0; i--){
        
        // Pop Smaller Elements
        while(stk.size() > 0 && stk.peek() > arr[i]){
            stk.pop();
        }
        
        // Answer -> Stack's top
        if(stk.size() == 0){
            nse[i] = -1;
        } else {
            nse[i] = stk.peek();
        }
        
        // Push Yourself
        stk.push(arr[i]);
    }
    
    return nse;
  }

  // M2 
  static void printNSE(int[] arr)
      {
          int n = arr.length;
          Stack<Integer> stack
              = new Stack<>(); // Stack to store indices of
                               // elements
          int[] ans
              = new int[n]; // Array to store the results
   
          // Iterate through each element in the array
          for (int i = 0; i < n; i++) {
              int next = arr[i];
   
              // Pop elements from the stack and update
              // results for elements with smaller neighbors
              while (!stack.isEmpty()
                     && arr[stack.peek()] > next) {
                  ans[stack.pop()] = next;
              }
   
              // Push the current index onto the stack
              stack.push(i);
          }
   
          // For remaining elements in the stack, set their
          // result to -1
          while (!stack.isEmpty()) {
              ans[stack.pop()] = -1;
          }
   
          // Print the original array elements and their
          // corresponding nearest smaller elements
          for (int i = 0; i < n; i++) {
              System.out.println(arr[i] + " --> " + ans[i]);
          }
      }
   

}
