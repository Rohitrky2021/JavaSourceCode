import java.util.*;
import java.io.*;

public class Main {

  public static int minPages(int[]arr, int m) {

    // Have to distribute in max M persons 
    //write your code here
    int sum = 0;
    int max = 0;
    
    for(int i = 0; i < arr.length; i++){
        sum = sum + arr[i];
        max = Math.max(max, arr[i]);
    }
    
    int lo = max;
    int hi = sum;
    int a = 0;
    
    while(lo <= hi){
        int mid = (lo + hi) / 2;
        
        if(i(arr, mid, m) == true) {
            a = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    
    return a;
    
  }
  
  public static boolean i(int[]arr, int mid, int m) {
      int st = 1;
      int sum = 0;
      
      for(int i = 0; i < arr.length; i++) {
          sum = sum + arr[i];
          
          if(sum > mid) {
              st++;
              sum = arr[i];
          }
      }
      
      return st <= m;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int m = scn.nextInt();

    int ans = minPages(arr, m);
    System.out.println(ans);
  }
}


// More OPIMISED Using Prefix Sum + Binary Search 

public class Main {

    public static int minPages(int[] arr, int m) {
        // Calculate prefix sum array
        int[] prefixSum = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        int sum = prefixSum[arr.length];
        int max = Arrays.stream(arr).max().getAsInt();

        int lo = max;
        int hi = sum;
        int a = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (isValid(arr, prefixSum, mid, m)) {
                a = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return a;
    }

    public static boolean isValid(int[] arr, int[] prefixSum, int mid, int m) {
        int st = 1;
        int prev = 0;

        for (int i = 1; i <= arr.length; i++) {
            if (prefixSum[i] - prefixSum[prev] > mid) {    // i-j<=k --- >  i <= j+k -->Y 
                st++;                                   //   i<=Y
                prev = i - 1;     // 1 2 3 4 5  --> 1 3 6 10 15 ->  8  10 13 11 21 
            }
        }

        return st <= m;
    }

    public static void main(String[] args) {
        // Input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int m = scn.nextInt();

        int ans = minPages(arr, m);
        System.out.println(ans);
    }
}
