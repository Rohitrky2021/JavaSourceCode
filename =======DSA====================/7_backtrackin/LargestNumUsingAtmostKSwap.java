 

import java.io.*;
// https://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps/
class Res {
    static String max = "";
}

class LargestNumUsingAtmostKSwap {

    // Function to perform swapping of digits
    public static void swap(char[] ar, int i, int j) {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    // Function to find maximum possible number by performing at-most k swap
    // operations
    public static void findMaximumNum(char ar[], int k, Res r) {
        if (k == 0)  // atmost swaps end here 
            return;
        int n = ar.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ar[j] > ar[i]) {
                    swap(ar, i, j);
                    String st = new String(ar);

                    if (r.max.compareTo(st) < 0) {
                        r.max = st;
                    }
                    findMaximumNum(ar, k - 1, r);
                    // Backtracking  --> array ko waapis wesse he for next swap --> FOr diff elemt of same level of tree
                    swap(ar, i, j);
                }
            }
        }
    }

    // Main function
    public static void main(String[] args) {
        String str = "129814999";
        int k = 4;
        Res r = new Res();
        r.max = str;
        findMaximumNum(str.toCharArray(), k, r);
        // Print the maximum number obtained after k swaps
        System.out.println(r.max);
    }
}
